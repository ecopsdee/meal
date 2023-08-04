package com.dexdee.meal.Service;

import com.dexdee.meal.DTO.MineralDTO;
import com.dexdee.meal.Models.Recipe;
import com.dexdee.meal.Models.RecipeResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface RecipeService {
    public List<String> availableCuisine();
    public ResponseEntity<RecipeResponse> getRecipeByCuisine(String cuisine);
    public List<String> availableDiet();
    public ResponseEntity<RecipeResponse> getRecipeByDiet(String diet);
    public ResponseEntity<RecipeResponse> getRecipeByMinCarb(Integer minCarbs);
    public ResponseEntity<RecipeResponse> getRecipeByMaxCarb(Integer maxCarbs);
    public ResponseEntity<RecipeResponse> getRecipeByMinProtein(Integer minProtein);
    public ResponseEntity<RecipeResponse> getRecipeByMaxProtein(Integer maxProtein);
    public ResponseEntity<RecipeResponse> getRecipeByMinerals(MineralDTO mineralDTO);
}
