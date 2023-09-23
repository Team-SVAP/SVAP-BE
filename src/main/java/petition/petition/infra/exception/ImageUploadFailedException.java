package petition.petition.infra.exception;

import petition.petition.global.error.exception.BusinessException;
import petition.petition.global.error.exception.ErrorCode;

public class ImageUploadFailedException extends BusinessException {

    public static final BusinessException EXCEPTION =
            new ImageUploadFailedException();

    private ImageUploadFailedException() { super(ErrorCode.IMAGE_UPLOAD_FAIL);}
}
