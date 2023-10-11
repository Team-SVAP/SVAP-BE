package petition.petition.domain.petition.exception;


import petition.petition.global.error.exception.BusinessException;
import petition.petition.global.error.exception.ErrorCode;

public class PasswordMismatchException extends BusinessException {
    public static final BusinessException EXCEPTION = new PasswordMismatchException();
    private PasswordMismatchException(){
        super (ErrorCode.PASSWORD_MISMATCH);
    }
}