package alvarenga.mateus.consumer;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.sql.Timestamp;
import java.time.Instant;

@SpringBootApplication
@CommonsLog
@EnableScheduling
public class ConsumerApplication {

    @Value("${activemq.broker.url}")
    private String BROKER_URL;

    @Value("${activemq.broker.username}")
    private String BROKER_USERNAME;

    @Value("${activemq.broker.password}")
    private String BROKER_PASSWORD;

    public static void main(String[] args) {
        log.info("ConsumerApplication:main");
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(BROKER_URL);
        activeMQConnectionFactory.setUserName(BROKER_USERNAME);
        activeMQConnectionFactory.setPassword(BROKER_PASSWORD);
        return activeMQConnectionFactory;
    }
}
