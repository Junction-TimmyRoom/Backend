package site.timmyroom.backend.excpetion;


import site.timmyroom.backend.gloabl.error.exception.BusinessException;
import site.timmyroom.backend.gloabl.error.exception.ErrorCode;

public class UserAlreadyExistsException extends BusinessException {
    public UserAlreadyExistsException() {
        super(ErrorCode.USER_ALREADY_EXISTS);
    }
}
