package com.evently.app;
import com.evently.app.model.Role;
import com.evently.app.model.Utilisateur;
import com.evently.app.repository.UtilisateurRepository;
import com.evently.app.role.TypeDeRole;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

//z@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
@AllArgsConstructor
public class EventlyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventlyApplication.class, args);
	}


	}

