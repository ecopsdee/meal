package com.dexdee.meal.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MineralDTO {

    private Integer minCarbs;
    private Integer maxCarbs;
    private Integer minProtein;
    private Integer maxProtein;



}
