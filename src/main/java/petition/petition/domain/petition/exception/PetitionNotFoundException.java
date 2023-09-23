package petition.petition.domain.petition.exception;


import petition.petition.global.error.exception.BusinessException;
import petition.petition.global.error.exception.ErrorCode;

public class PetitionNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new PetitionNotFoundException();
    private PetitionNotFoundException(){
        super (ErrorCode.PETITION_NOT_FOUND);
    }
}