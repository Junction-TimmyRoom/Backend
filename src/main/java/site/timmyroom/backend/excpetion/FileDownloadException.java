package site.timmyroom.backend.excpetion;

import site.timmyroom.backend.gloabl.error.exception.BusinessException;
import site.timmyroom.backend.gloabl.error.exception.ErrorCode;

public class FileDownloadException extends BusinessException {
    public FileDownloadException() {
        super(ErrorCode.FILE_DOWNLOAD_FAIl);
    }
}
