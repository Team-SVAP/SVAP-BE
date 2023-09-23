package petition.petition.domain.user.exception;


import petition.petition.global.error.exception.BusinessException;
import petition.petition.global.error.exception.ErrorCode;

public class BannedUserException extends BusinessException {
    public static final BusinessException EXCEPTION = new BannedUserException();
    private BannedUserException() {
        super(ErrorCode.BANNED_USER);
    }
}