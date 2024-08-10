package site.timmyroom.backend.excpetion;


import site.timmyroom.backend.gloabl.error.exception.EntityNotFoundException;
import site.timmyroom.backend.gloabl.error.exception.ErrorCode;

public class UserNotFoundException extends EntityNotFoundException {
    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
