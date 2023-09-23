package petition.petition.domain.user.exception;


import petition.petition.global.error.exception.BusinessException;
import petition.petition.global.error.exception.ErrorCode;

public class CodeMisMatchException extends BusinessException {
    public static final BusinessException EXCEPTION = new CodeMisMatchException();
    private CodeMisMatchException() {
        super(ErrorCode.CODE_MISMATCH);
    }
}