package petition.petition.domain.ban.exception;


import petition.petition.global.error.exception.BusinessException;
import petition.petition.global.error.exception.ErrorCode;

public class BanNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new BanNotFoundException();
    private BanNotFoundException(){
        super (ErrorCode.BAN_NOT_FOUND);
    }
}