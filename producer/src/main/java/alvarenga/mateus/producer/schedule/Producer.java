package alvarenga.mateus.producer.schedule;

import alvarenga.mateus.producer.domain.factory.MessageFactory;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.sql.Timestamp;
import java.time.Instant;

@Component
@CommonsLog
@AllArgsConstructor
public class Producer {

    private JmsTemplate jmsTemplate;
    private Queue queue;

    @Scheduled(fixedDelay = 3000, initialDelay = 10000)
    @SneakyThrows
    public void produce() {
        String message = MessageFactory.createMessageAsJSON();
        log.info("ProducerApplication: produced message :" + message);
        jmsTemplate.convertAndSend(queue, message);
    }
}
