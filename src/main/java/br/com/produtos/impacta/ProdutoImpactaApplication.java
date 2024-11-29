package br.com.produtos.impacta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class ProdutoImpactaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdutoImpactaApplication.class, args);
	}
}
