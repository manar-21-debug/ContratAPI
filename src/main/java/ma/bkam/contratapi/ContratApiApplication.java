package ma.bkam.contratapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = {"ma.bkam.contratapi"})
public class ContratApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContratApiApplication.class, args);


		System.out.println("Hello BKAM");
	}



}
