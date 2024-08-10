package site.timmyroom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.timmyroom.backend.entity.PregnancyNutritionByMonth;

@Repository
public interface PregnancyNutritionByMonthRepository extends JpaRepository<PregnancyNutritionByMonth, Integer> {
}
