package org.isooproject;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "my")
public class MyEndpoint {

    private String value = "hello world";

    @ReadOperation
    private String getValue() {
        return this.value;
    }

    @WriteOperation
    private void setValue(String value) {
        this.value = value;
    }

    @DeleteOperation
    public void deleteValue() {
        this.value = "hello world";
    }
}
