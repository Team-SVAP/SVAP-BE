package petition.petition.domain.user.exception;

import petition.petition.global.error.exception.BusinessException;
import petition.petition.global.error.exception.ErrorCode;

public class AccountIdAlreadyExistsException extends BusinessException {
    public static final BusinessException EXCEPTION = new AccountIdAlreadyExistsException();
    private AccountIdAlreadyExistsException(){
        super(ErrorCode.ACCOUNT_ID_ALREADY_EXISTS);
    }
}
