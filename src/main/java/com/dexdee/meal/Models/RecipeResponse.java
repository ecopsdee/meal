package com.dexdee.meal.Models;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class RecipeResponse implements Serializable {

    private int offset;
    private int number;
    private List<Recipe> results;
}
