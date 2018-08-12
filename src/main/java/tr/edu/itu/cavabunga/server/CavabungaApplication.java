package tr.edu.itu.cavabunga.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"tr.edu.itu.cavabunga.server", "tr.edu.itu.cavabunga.lib"})
@EntityScan({"tr.edu.itu.cavabunga.lib", "tr.edu.itu.cavabunga.server.entity"})
public class CavabungaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CavabungaApplication.class, args);
	}
}
