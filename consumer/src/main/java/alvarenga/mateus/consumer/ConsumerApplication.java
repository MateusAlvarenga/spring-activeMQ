package alvarenga.mateus.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        System.out.println("ConsumerApplication.main() 20:00");
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
