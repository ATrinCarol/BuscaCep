package one.digitalinnovation.gof;

import org.springframework.boot.SpringApplication;

/**
 * Projeto Spring Boot utilizando o Initializr, com os seguintes módulos:
 * Spring Data JPA
 * Spring Web
 * H2 Database
 * OpenFeign
 * 
 * Mediação do instrutor FalvoJr da DIO
 * 
 * @author ATrinCarol | Caroline Trindade
 *
 */

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication(scanBasePackages = {"one.digitalinnovation.gof"})
public class LabPadroesProjetoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabPadroesProjetoSpringApplication.class, args);

		
	} 

}
