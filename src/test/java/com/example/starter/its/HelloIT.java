package com.example.starter.its;

import com.flowlogix.test.AppServerLifecycle;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import java.net.URI;
import static org.assertj.core.api.Assertions.assertThat;

@RunAsClient
@AppServerLifecycle
class HelloIT {
    @Drone
    WebDriver browser;

    @ArquillianResource
    URI baseUri;

    @Test
    void helloApi() {
        browser.get(baseUri + "api/hello");
        assertThat(browser.getPageSource()).contains("Hello World!");
    }
}
