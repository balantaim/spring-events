package com.martinatanasov.events.controllers;

import com.martinatanasov.events.events.CreateEmailMessageEvent;
import com.martinatanasov.events.listeners.EmailMessageListener;
import com.martinatanasov.events.objects.EmailInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HomeController {

    private final ApplicationEventPublisher applicationEventPublisher;

    @GetMapping("")
    public String home(){
        EmailInfo email;
        EmailMessageListener listener;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        for(long i = 1L;i < 5;i++){
            email = generateData(i);
				listener = new EmailMessageListener();
				listener.listen(email);
				applicationEventPublisher.publishEvent(new CreateEmailMessageEvent(email, auth));
            System.out.println("Controller Thread ID: " + Thread.currentThread().threadId());
            System.out.println("Controller Thread Name: " + Thread.currentThread().getName() + "\n");
        }

        return "Home screen";
    }

    private EmailInfo generateData(Long id){
        return new EmailInfo(id,
                "test-email1@abv.bg",
                "test-email2@abv.bg",
                "Verify your account",
                "This is test message");
    }
}
