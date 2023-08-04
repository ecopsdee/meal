package com.dexdee.meal.Controllers;

import com.dexdee.meal.DTO.MineralDTO;
import com.dexdee.meal.Models.Recipe;
import com.dexdee.meal.Models.RecipeResponse;
import com.dexdee.meal.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/foodMeals")
public class FoodController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/AvailableCuisines")
    public List<String> displayAvailableCuisines(){
        return recipeService.availableCuisine();
    }
    @GetMapping("/RecipesByCuisine")
    public ResponseEntity<RecipeResponse> getRecipeByCuisine(@RequestParam("cuisine") String cuisine){
        ResponseEntity<RecipeResponse> _recipeList = recipeService.getRecipeByCuisine(cuisine);
        return _recipeList;
    }
    @GetMapping("/AvailableDiets")
    public List<String> displayAvailableDiets(){
        return recipeService.availableDiet();
    }
    @GetMapping("/RecipesByDiet")
    public ResponseEntity<RecipeResponse> getRecipeByDiet(@RequestParam("diet") String diet){
        ResponseEntity<RecipeResponse> _recipeList = recipeService.getRecipeByDiet(diet);
        return _recipeList;
    }
    @GetMapping("/RecipesByMinCarbs")
    public ResponseEntity<RecipeResponse> getRecipeByMinCarb(@RequestParam("minCarb") Integer minCarb){
        ResponseEntity<RecipeResponse> _recipeList = recipeService.getRecipeByMinCarb(minCarb);
        return _recipeList;
    }
    @GetMapping("/RecipesByMaxCarbs")
    public ResponseEntity<RecipeResponse> getRecipeByMaxCarb(@RequestParam("maxCarb") Integer maxCarb){
        ResponseEntity<RecipeResponse> _recipeList = recipeService.getRecipeByMaxCarb(maxCarb);
        return _recipeList;
    }
    @PostMapping("/RecipesByMinerals")
    public ResponseEntity<RecipeResponse> getRecipeByMinerals(@RequestBody MineralDTO mineralDTO){
        ResponseEntity<RecipeResponse> _recipeList = recipeService.getRecipeByMinerals(mineralDTO);
        return _recipeList;
    }



}
