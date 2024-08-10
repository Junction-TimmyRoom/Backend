package site.timmyroom.backend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.timmyroom.backend.repository.IngredientRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class IngredientService {
    private final IngredientRepository ingredientRepository;

}
