package org.isooproject;

import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

public class WebControllerTest {

    @Test
    public void helloTest() {
        // Given
        WebController webController = new WebController();
        Model model = new ExtendedModelMap();
        // When
        webController.hello(model, "isooproject");
        // Then
        model.asMap().forEach((k, v) -> System.out.println("key : " + k + "value :" + v));
    }
}
