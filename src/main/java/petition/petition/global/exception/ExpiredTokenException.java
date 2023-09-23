package petition.petition.global.exception;


import petition.petition.global.error.exception.BusinessException;
import petition.petition.global.error.exception.ErrorCode;

public class ExpiredTokenException extends BusinessException {
    public static final BusinessException EXCEPTION = new ExpiredTokenException();
    private ExpiredTokenException(){
        super(ErrorCode.EXPIRED_TOKEN);
    }
}