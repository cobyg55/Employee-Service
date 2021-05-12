package co.com.employee.service.faceId.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaRepositories("co.com.employee.service.faceId.domain.repository")
@EntityScan("co.com.employee.service.faceId.domain.model")
@ComponentScan("co.com.employee.service.faceId.*")
@EnableAsync
@EnableFeignClients("co.com.employee.service.faceId.client")
public class EmployeeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }

}
