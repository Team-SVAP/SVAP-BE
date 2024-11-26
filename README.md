# SVAP-BE
SVAP 백엔드 레포지토리입니다.


gcc -o sw_block_manager sw_block_manager.c


#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_BLOCKS 100
#define MAX_ARGV 4
#define MAX_ARG_LEN 256
#define DELIMITER ";"

typedef struct {
    char swArgv[MAX_ARGV][MAX_ARG_LEN];
} swInfo;

swInfo swBlocks[MAX_BLOCKS];
int blockCount = 0;

void readFileList(const char *filename) {
    FILE *file = fopen(filename, "r");
    if (file == NULL) {
        perror("파일 열기 실패");
        exit(EXIT_FAILURE);
    }

    char line[1024];
    blockCount = 0;

    while (fgets(line, sizeof(line), file)) {
        if (blockCount >= MAX_BLOCKS) {
            fprintf(stderr, "S/W 블록 최대 개수 초과");
            break;
        }

        char *newline = strchr(line, '\n');
        if (newline) *newline = '\0';

        char *token = strtok(line, DELIMITER);
        int i = 0;
        while (token && i < MAX_ARGV) {
            strncpy(swBlocks[blockCount].swArgv[i], token, MAX_ARG_LEN - 1);
            swBlocks[blockCount].swArgv[i][MAX_ARG_LEN - 1] = '\0';
            token = strtok(NULL, DELIMITER);
            i++;
        }
        blockCount++;
    }

    fclose(file);
}

void initializeSWBlocks(const char *filename) {
    printf("S/W 블록 초기화 중...");
    readFileList(filename);
    for (int i = 0; i < blockCount; i++) {
        printf("Initializing block: %s\n", swBlocks[i].swArgv[0]);
    }
    printf("S/W 블록 초기화 완료");
}

void cleanupSWBlocks() {
    printf("기존 S/W 블록 정리 중");
    blockCount = 0;
    printf("기존 S/W 블록 정리 완료");
}

void reinitializeSWBlocks(const char *filename) {
    cleanupSWBlocks();
    initializeSWBlocks(filename);
}

void displaySWBlockInfo() {
    printf("\n현재 S/W 블록 정보");
    for (int i = 0; i < blockCount; i++) {
        printf("Block %d:\n", i + 1);
        for (int j = 0; j < MAX_ARGV; j++) {
            if (strlen(swBlocks[i].swArgv[j]) > 0) {
                printf("  Arg %d: %s\n", j + 1, swBlocks[i].swArgv[j]);
            }
        }
    }
    printf("\n");
}

int main() {
    const char *filename = "sw_list.txt";

    printf("Test Case 1: Text File Parsing 확인");
    initializeSWBlocks(filename);
    displaySWBlockInfo();

    printf("\nTest Case 2: S/W 블록 재초기화 확인");
    reinitializeSWBlocks(filename);
    displaySWBlockInfo();

    return 0;
}

