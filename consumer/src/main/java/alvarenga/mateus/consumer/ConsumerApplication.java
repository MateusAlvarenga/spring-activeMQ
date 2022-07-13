package alvarenga.mateus.consumer;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.sql.Timestamp;
import java.time.Instant;

@SpringBootApplication
@CommonsLog
@EnableScheduling
public class ConsumerApplication {

    public static void main(String[] args) {
        log.info("ConsumerApplication:main");
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Scheduled(fixedDelay = 3000, initialDelay = 10000)
    public void schedule() {
         log.info("ConsumerApplication: schedule :" + Timestamp.from(Instant.now()));
    }
}
