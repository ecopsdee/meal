package com.dexdee.meal.ServiceImpl;

import com.dexdee.meal.DTO.MineralDTO;
import com.dexdee.meal.FeignClient.RecipeFeignClient;
import com.dexdee.meal.Models.Cuisine;
import com.dexdee.meal.Models.Recipe;
import com.dexdee.meal.Models.RecipeResponse;
import com.dexdee.meal.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private Cuisine cuisine;

    @Autowired
    private RecipeFeignClient recipeFeignClient;


    @Override
    public List<String> availableCuisine() {
        return cuisine.getCuisines() ;
    }

    @Override
    public ResponseEntity<RecipeResponse> getRecipeByCuisine(String cuisine) {
        return recipeFeignClient.getRecipeByCuisine(cuisine);
    }

    @Override
    public List<String> availableDiet() {
        return cuisine.getDiets();
    }

    @Override
    public ResponseEntity<RecipeResponse> getRecipeByDiet(String diet) {
        return recipeFeignClient.getRecipeByDiet(diet);
    }

    @Override
    public ResponseEntity<RecipeResponse> getRecipeByMinCarb(Integer minCarbs) {
        return recipeFeignClient.getRecipeByMinCarb(minCarbs);
    }

    @Override
    public ResponseEntity<RecipeResponse> getRecipeByMaxCarb(Integer maxCarbs) {
        return recipeFeignClient.getRecipeByMaxCarb(maxCarbs);
    }

    @Override
    public ResponseEntity<RecipeResponse> getRecipeByMinProtein(Integer minProtein) {
        return recipeFeignClient.getRecipeByMinProtein(minProtein);
    }

    @Override
    public ResponseEntity<RecipeResponse> getRecipeByMaxProtein(Integer maxProtein) {
        return recipeFeignClient.getRecipeByMaxProtein(maxProtein);
    }

    @Override
    public ResponseEntity<RecipeResponse> getRecipeByMinerals(MineralDTO mineralDTO) {
        List<Recipe> _recipesWithMinerals = new ArrayList<>();
        if(isMineralDTOEmpty(mineralDTO)){
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
        if(mineralDTO.getMinCarbs() !=  null){
            List<Recipe> _recipesWithMinCarb = recipeFeignClient.getRecipeByMinCarb(mineralDTO.getMinCarbs()).getBody().getResults();
            _recipesWithMinerals.addAll(_recipesWithMinCarb);
        }
        if(mineralDTO.getMaxCarbs() !=  null){
            List<Recipe> _recipesWithMaxCarb = recipeFeignClient.getRecipeByMaxCarb(mineralDTO.getMaxCarbs()).getBody().getResults();
            _recipesWithMinerals.addAll(_recipesWithMaxCarb);
        }
        if(mineralDTO.getMinProtein() !=  null){
            List<Recipe> _recipesWithMinProtein = recipeFeignClient.getRecipeByMinProtein(mineralDTO.getMinProtein()).getBody().getResults();
            _recipesWithMinerals.addAll(_recipesWithMinProtein);
        }
        if(mineralDTO.getMaxProtein() !=  null){
            List<Recipe> _recipesWithMaxProtein = recipeFeignClient.getRecipeByMaxProtein(mineralDTO.getMaxProtein()).getBody().getResults();
            _recipesWithMinerals.addAll(_recipesWithMaxProtein);
        }
        RecipeResponse _recipeResponse = RecipeResponse.builder().results(_recipesWithMinerals).build();

        return new ResponseEntity<>(_recipeResponse, HttpStatus.OK);
    }

    public Boolean isMineralDTOEmpty(MineralDTO mineralDTO){
        if(mineralDTO.getMaxCarbs() == null && mineralDTO.getMinCarbs() == null && mineralDTO.getMinProtein() == null && mineralDTO.getMaxProtein() == null){
            return true;
        }
        return false;
    }


}
