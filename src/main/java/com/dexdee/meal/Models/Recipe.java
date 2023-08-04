package com.dexdee.meal.Models;

import lombok.Data;

import java.io.Serializable;

@Data
public class Recipe implements Serializable {
    private Integer Id;
    private String title;
    private String image;
    private String imageType;


}
