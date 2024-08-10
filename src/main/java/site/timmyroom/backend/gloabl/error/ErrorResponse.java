package site.timmyroom.backend.gloabl.error;

import lombok.Data;
import site.timmyroom.backend.gloabl.error.exception.ErrorCode;

@Data
public class ErrorResponse {
    private final String code;
    private final String message;
    private final Integer status;

    public ErrorResponse(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.status = errorCode.getStatus();
    }
}
