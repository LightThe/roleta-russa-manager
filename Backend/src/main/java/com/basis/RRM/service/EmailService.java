package com.basis.RRM.service;

import com.basis.RRM.config.*;
import com.basis.RRM.service.dto.*;
import lombok.*;
import org.springframework.mail.javamail.*;
import org.springframework.stereotype.Service;

import javax.mail.internet.*;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class EmailService {
    private JavaMailSender javaMailSender;
    private final ApplicationProperties applicationProperties;

    @SneakyThrows
    public void enviaEmail(EmailDTO dto){
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mime = new MimeMessageHelper(message, false, "UTF-8");
        mime.setTo(dto.getDestinatario());
        mime.setFrom(applicationProperties.enderecoRemetente);
        mime.setSubject(dto.getAssunto());
        for(String s: dto.getCopias()){
            mime.addCc(s);
        }
        mime.setText(dto.getCorpo());
        javaMailSender.send(message);
    }
}
