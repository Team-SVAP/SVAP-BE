package petition.petition.domain.petition.exception;


import petition.petition.global.error.exception.BusinessException;
import petition.petition.global.error.exception.ErrorCode;

public class NotAdminException extends BusinessException {
    public static final BusinessException EXCEPTION = new NotAdminException();
    private NotAdminException(){
        super (ErrorCode.NOT_ADMIN);
    }
}