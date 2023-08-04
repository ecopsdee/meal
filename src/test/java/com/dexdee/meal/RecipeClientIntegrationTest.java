package com.dexdee.meal;

import com.dexdee.meal.FeignClient.RecipeFeignClient;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {WireMockConfig.class})
public class RecipeClientIntegrationTest {

    @Autowired
    private WireMockServer mockRecipeService;
    @Autowired
    private RecipeFeignClient recipeFeignClient;

    @BeforeEach
    void setUp() throws IOException {
        RecipeMocks.setupMockRecipesResponse(mockRecipeService);
    }

    @Test
    void getAllRecipesByCuisine_thenRecipesShouldBeReturned() {
        String cuisine = "African";
        Assertions.assertFalse(recipeFeignClient.getRecipeByCuisine(cuisine).hasBody());

    }
}
