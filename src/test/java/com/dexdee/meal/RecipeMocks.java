package com.dexdee.meal;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class RecipeMocks {
    public static void setupMockRecipesResponse(WireMockServer recipeService) throws IOException {
        recipeService.stubFor(get(urlEqualTo("/complexSearch"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(StreamUtils.copyToString(
                                RecipeMocks.class.getClassLoader().getResourceAsStream(""), Charset.defaultCharset()
                        ))));
    }
}
