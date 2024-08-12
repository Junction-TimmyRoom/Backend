package site.timmyroom.backend.excpetion;

import site.timmyroom.backend.gloabl.error.exception.EntityNotFoundException;
import site.timmyroom.backend.gloabl.error.exception.ErrorCode;

public class PregnancyNutritionByMonthNotFound extends EntityNotFoundException {
    public PregnancyNutritionByMonthNotFound() {
        super(ErrorCode.ENTITY_NOT_FOUND);
    }
}
