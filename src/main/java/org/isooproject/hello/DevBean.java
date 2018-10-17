package org.isooproject.hello;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevBean {
    // dev 환경에서만 Bean으로 돌아가게 하는 것

}
