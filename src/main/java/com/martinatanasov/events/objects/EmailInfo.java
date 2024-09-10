package com.martinatanasov.events.objects;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailInfo{
    private Long id;
    private String toEmail;
    private String fromEmail;
    private String subject;
    private String message;
}
