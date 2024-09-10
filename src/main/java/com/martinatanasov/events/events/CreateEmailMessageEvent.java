package com.martinatanasov.events.events;

import com.martinatanasov.events.objects.EmailInfo;
import lombok.*;
import org.springframework.security.core.Authentication;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class CreateEmailMessageEvent {
    private EmailInfo emailInfo;
    private Authentication authentication;
}
