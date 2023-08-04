package com.dexdee.meal.Models;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Data
public class Cuisine {

    @Value("#{'${cuisine}'.split(',')}")
    private final List<String> cuisines;
    @Value("#{'${diet}'.split(',')}")
    private final List<String> diets;

}
