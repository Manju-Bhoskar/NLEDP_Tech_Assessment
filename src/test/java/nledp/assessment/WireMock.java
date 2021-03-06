package nledp.assessment;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class WireMock {
    // Get URL: https://petstore.swagger.io/v2/pet/findByStatus?status=available
    private WireMockServer wireMockServer;

    @Before
    public void setup()
    {
        wireMockServer = new WireMockServer(wireMockConfig().port(8889).extensions(new ResponseTemplateTransformer(true)));
        wireMockServer.start();
        configureFor("localhost", wireMockServer.port());
        stubFor(get(urlMatching("/v2/pet/findByStatus.*"))
                .willReturn(aResponse().withBodyFile("pets.json")));
    }

    @After
    public void teardown()
    {
        wireMockServer.stop();
    }
}
