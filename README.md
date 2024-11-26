# SVAP-BE
SVAP 백엔드 레포지토리입니다.

vim bogoseo.c

gcc -o bogoseo bogoseo.c
./bogoseo


vim FileList

SwBlock1;
App1_Para1 ;
App1_Para2 ;

SwBlock2;
App2_Para1 ;
App2_Para2 ;
App2_Para3 ;

SwBlock3;
App3_Para1 ;



#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <signal.h>
#include <time.h>
#include <ctype.h>

#define MAX_SW_BLOCKS 10
#define MAX_PARAMS 3
#define MAX_STR 256

struct swInfo {
    char name[MAX_STR];            
    char params[MAX_PARAMS][MAX_STR]; 
    int paramCount;                
    int restartCount;             
    char lastRestartReason[MAX_STR]; 
    time_t lastRestartTime;    
};

struct swInfo swBlocks[MAX_SW_BLOCKS];
int swBlockCount = 0;          
char *trim(char *str) {
    char *end;

    while (isspace((unsigned char)*str)) str++;

    if (*str == '\0') return str;
    end = str + strlen(str) - 1;
    while (end > str && isspace((unsigned char)*end)) end--;

    *(end + 1) = '\0';
    return str;
}
void readFileList(const char *filePath) {
    FILE *fp = fopen(filePath, "r");
    if (!fp) {
        perror("Failed to open file");
        exit(EXIT_FAILURE);
    }

    char line[MAX_STR];
    while (fgets(line, sizeof(line), fp)) {
        if (swBlockCount >= MAX_SW_BLOCKS) break;

        char *token = strtok(line, ";");
        if (!token) continue;

        strcpy(swBlocks[swBlockCount].name, trim(token));

        int paramIndex = 0;
        while ((token = strtok(NULL, ";")) && paramIndex < MAX_PARAMS) {
            strcpy(swBlocks[swBlockCount].params[paramIndex++], trim(token));
        }
        swBlocks[swBlockCount].paramCount = paramIndex;
        swBlocks[swBlockCount].restartCount = 0;

        swBlockCount++;
    }

    fclose(fp);
    printf("Loaded %d S/W blocks\n", swBlockCount);
}

void restartSwBlock(int blockIndex, const char *reason) {
    if (blockIndex < 0 || blockIndex >= swBlockCount) return;

    struct swInfo *block = &swBlocks[blockIndex];
    block->restartCount++;
    block->lastRestartTime = time(NULL);
    strcpy(block->lastRestartReason, reason);

    FILE *logFile = fopen("./log/restart.txt", "a");
    if (logFile) {
        fprintf(logFile, "S/W Name: %s, Time: %s, Reason: %s, Restart Count: %d\n",
                block->name, ctime(&block->lastRestartTime), block->lastRestartReason, block->restartCount);
        fclose(logFile);
    }

    printf("Restarted %s (Reason: %s, Count: %d)\n",
           block->name, block->lastRestartReason, block->restartCount);
}
void printRestartInfo() {
    printf("S/W Block Name    Restart Count    Start Time              Reason\n");
    printf("---------------------------------------------------------------\n");

    for (int i = 0; i < swBlockCount; i++) {
        struct swInfo *block = &swBlocks[i];
        printf("%-16s %-16d %-24s %-16s\n",
               block->name,
               block->restartCount,
               block->restartCount > 0 ? ctime(&block->lastRestartTime) : "-",
               block->restartCount > 0 ? block->lastRestartReason : "Init.");
    }
}
void signalHandler(int signal) {
    for (int i = 0; i < swBlockCount; i++) {
        if (strcmp(swBlocks[i].name, "SwBlock2") == 0) {
            restartSwBlock(i, "Signal(SIGTERM)");
            break;
        }
    }
}

void setupSignalHandler() {
    signal(SIGTERM, signalHandler);
}
int main() {
    system("mkdir -p ./log");

    readFileList("./FileList");

    setupSignalHandler();

    restartSwBlock(0, "Init.");
    restartSwBlock(1, "Exit(5)");

    printRestartInfo();

    return 0;
}
