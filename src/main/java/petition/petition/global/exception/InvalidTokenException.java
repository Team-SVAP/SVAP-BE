package petition.petition.global.exception;


import petition.petition.global.error.exception.BusinessException;
import petition.petition.global.error.exception.ErrorCode;

public class InvalidTokenException extends BusinessException {
    public static final BusinessException EXCEPTION = new InvalidTokenException();
    private InvalidTokenException(){
        super(ErrorCode.INVALID_TOKEN);

    }
}
