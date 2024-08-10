package site.timmyroom.backend.excpetion;

import site.timmyroom.backend.gloabl.error.exception.BusinessException;
import site.timmyroom.backend.gloabl.error.exception.ErrorCode;

public class FileUploadException extends BusinessException {
    public FileUploadException() {
        super(ErrorCode.FILE_UPLOAD_FAIL);
    }
}
