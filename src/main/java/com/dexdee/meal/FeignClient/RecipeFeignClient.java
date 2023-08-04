package com.dexdee.meal.FeignClient;

import com.dexdee.meal.Models.Recipe;
import com.dexdee.meal.Models.RecipeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "RecipeFeignClient", url = "${client.recipes.baseurl}")
public interface RecipeFeignClient {

    @GetMapping("/complexSearch")
    public ResponseEntity<RecipeResponse> getRecipeByCuisine(@RequestParam String cuisine);
    @GetMapping("/complexSearch")
    public ResponseEntity<RecipeResponse> getRecipeByDiet(@RequestParam String diet);
    @GetMapping("/complexSearch")
    public ResponseEntity<RecipeResponse> getRecipeByMinCarb(@RequestParam Integer minCarbs);
    @GetMapping("/complexSearch")
    public ResponseEntity<RecipeResponse> getRecipeByMaxCarb(@RequestParam Integer maxCarbs);
    @GetMapping("/complexSearch")
    public ResponseEntity<RecipeResponse> getRecipeByMinProtein(@RequestParam Integer minProtein);
    @GetMapping("/complexSearch")
    public ResponseEntity<RecipeResponse> getRecipeByMaxProtein(@RequestParam Integer maxProtein);











}
