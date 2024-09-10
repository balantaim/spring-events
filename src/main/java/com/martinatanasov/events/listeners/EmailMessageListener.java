package com.martinatanasov.events.listeners;

import com.martinatanasov.events.objects.EmailInfo;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailMessageListener {

    @Async
    @EventListener
    public void listen(EmailInfo event){
        System.out.println("Email message with ID: " + event.getId() + " sent!");
        System.out.println("Thread ID: " + Thread.currentThread().threadId());
        System.out.println("Thread Name: " + Thread.currentThread().getName() + "\n");
        //Add logic to save the event to the database
//        try {
//            Thread.sleep(2500);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

    }

}
