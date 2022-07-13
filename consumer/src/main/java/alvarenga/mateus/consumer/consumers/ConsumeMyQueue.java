package alvarenga.mateus.consumer.consumers;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@CommonsLog
public class ConsumeMyQueue {

    @JmsListener(destination = "my-queue")
    public void consumeMessage(String message) {
        log.info("Message received from activemq queue---"+message);
    }

}
