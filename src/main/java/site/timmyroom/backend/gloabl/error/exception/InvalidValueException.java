package site.timmyroom.backend.gloabl.error.exception;

public class InvalidValueException extends BusinessException {

    public InvalidValueException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public InvalidValueException(ErrorCode errorCode) {
        super(errorCode);
    }
}
