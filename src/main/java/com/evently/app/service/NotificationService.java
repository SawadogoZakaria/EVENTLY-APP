package com.evently.app.service;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import com.evently.app.model.Validation;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class NotificationService {
    JavaMailSender javaMailSender;

    public  void  envoyer(Validation validation){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("EventPlanner-no-replay");
        message.setTo(validation.getUtilisateur().getEmail());
        message.setSubject("Votre code d'activation");

        String texte = String.format(
                "Bonjour et bienvenue à eventplanner %s <br /> " +
                        "Votre code d'activation est %s" +
                        " " + "Votre code est valable pandant 10 minutes;À bientôt",
                validation.getUtilisateur().getNom(),
                validation.getCode()
        );
        message.setText(texte);

        javaMailSender.send(message);
    }
}
