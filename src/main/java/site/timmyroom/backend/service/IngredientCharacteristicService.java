package site.timmyroom.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.timmyroom.backend.entity.IngredientCharacteristic;
import site.timmyroom.backend.repository.IngredientCharacteristicRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientCharacteristicService {

    private final IngredientCharacteristicRepository ingredientCharacteristicRepository;

    public List<IngredientCharacteristic> findIngredientCharacteristicsByMenuId(Long menuId){
        return ingredientCharacteristicRepository.findIngredientCharacteristicsByMenuId(menuId);
    }
}
