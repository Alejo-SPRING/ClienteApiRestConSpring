package com.consumApi.backEnd.app.web;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumoDeApisRestConSpringApplication {

	private static final org.slf4j.Logger loger = org.slf4j.LoggerFactory.getLogger(ConsumoDeApisRestConSpringApplication.class); 
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumoDeApisRestConSpringApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return (args) -> {
			//crear headers de la api
			HttpHeaders headers = new HttpHeaders();
			//codigo del usuario de azure
			headers.add("api-key", "faswefwfsadfsafsf");
			//agregamos los headers a un entity
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			//agregamos las credenciales de la cuenta de azure para acceder a la pai
			restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor("username", "password"));
			//al dar la respuesta nos retorna un ResponseEntity donde queda guardado todos los datos de la respuesta de la api
			//se le envia en el primer parametro la url de la api, el tipo de metodo HTTP, los headers, la clase que va a retornar<Collection> de java
			ResponseEntity<Map> response = restTemplate.exchange("url de la api", HttpMethod.GET, entity, Map.class);
			//nos retorna un Map donde cada atributo del Json es un id del map
			loger.info(response.getBody().get("content").toString());
		};
	}
	
}
