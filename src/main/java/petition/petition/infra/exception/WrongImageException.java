package petition.petition.infra.exception;


import petition.petition.global.error.exception.BusinessException;
import petition.petition.global.error.exception.ErrorCode;

public class WrongImageException extends BusinessException {

    public static final BusinessException EXCEPTION = new WrongImageException();
    private WrongImageException() { super(ErrorCode.WRONG_IMAGE);}
}
