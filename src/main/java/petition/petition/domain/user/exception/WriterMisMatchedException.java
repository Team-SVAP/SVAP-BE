package petition.petition.domain.user.exception;

import petition.petition.global.error.exception.BusinessException;
import petition.petition.global.error.exception.ErrorCode;

public class WriterMisMatchedException extends BusinessException {
    public static final BusinessException EXCEPTION = new WriterMisMatchedException();
    private WriterMisMatchedException(){
        super(ErrorCode.USER_NOT_FOUND);
    }
}
