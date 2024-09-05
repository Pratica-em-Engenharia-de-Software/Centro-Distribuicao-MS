package com.pes.centro_distribuicao_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CentroDistribuicaoMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentroDistribuicaoMsApplication.class, args);
	}

}
