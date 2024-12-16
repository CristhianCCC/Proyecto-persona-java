package Proyecto_01;

import Proyecto_01.entities.Persona;
import Proyecto_01.repository.PersonaRepository;
import Proyecto_01.service.PersonaService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Data
@SpringBootApplication
public class Proyecto01Application /*implements CommandLineRunner*/{


	//Herencia de Repository
	@Autowired
	private PersonaService personaService;

	public static void main(String[] args) {
		SpringApplication.run(Proyecto01Application.class, args);
	}

	/*
	@Override
	public void run(String... args) throws Exception {
	personaService.crearPersona(new Persona(1L, "Cristhian", 23));
	personaService.crearPersona(new Persona(2L, "Nathy", 20));
	}*/
}
