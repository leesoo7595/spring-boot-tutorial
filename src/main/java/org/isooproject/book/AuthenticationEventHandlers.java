package org.isooproject.book;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEventHandlers {

    @EventListener
    public void handleBadCredential (AuthenticationFailureBadCredentialsEvent event) {
        System.out.println(event.getAuthentication().getPrincipal() + " 인증 시도 중...");
        System.out.println("비번이 틀렷습니다.");
    }
}
