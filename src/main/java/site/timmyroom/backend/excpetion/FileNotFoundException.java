package site.timmyroom.backend.excpetion;


import site.timmyroom.backend.gloabl.error.exception.EntityNotFoundException;
import site.timmyroom.backend.gloabl.error.exception.ErrorCode;

public class FileNotFoundException extends EntityNotFoundException {
    public FileNotFoundException() {
        super(ErrorCode.ENTITY_NOT_FOUND);
    }
}
