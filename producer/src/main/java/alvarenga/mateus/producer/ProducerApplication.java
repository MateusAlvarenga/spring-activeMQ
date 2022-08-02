package alvarenga.mateus.producer;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.Queue;

@SpringBootApplication
@CommonsLog
@EnableScheduling
public class ProducerApplication {

    @Value("${activemq.broker.url}")
    private String BROKER_URL;

    @Value("${activemq.broker.username}")
    private String BROKER_USERNAME;

    @Value("${activemq.broker.password}")
    private String BROKER_PASSWORD;

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("my-queue");
    }

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(BROKER_URL);
        activeMQConnectionFactory.setUserName(BROKER_USERNAME);
        activeMQConnectionFactory.setPassword(BROKER_PASSWORD);
        return activeMQConnectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        return new JmsTemplate(activeMQConnectionFactory());
    }

    public static void main(String[] args) {
        log.info("ProducerApplication:main");
        SpringApplication.run(ProducerApplication.class, args);
    }
}
