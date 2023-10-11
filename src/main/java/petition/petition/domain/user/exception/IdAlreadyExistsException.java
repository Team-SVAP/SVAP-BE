package petition.petition.domain.user.exception;

import petition.petition.global.error.exception.BusinessException;
import petition.petition.global.error.exception.ErrorCode;

public class IdAlreadyExistsException extends BusinessException {
    public static final BusinessException EXCEPTION = new IdAlreadyExistsException();
    private IdAlreadyExistsException(){
        super(ErrorCode.ID_ALREADY_EXISTS);
    }
}
