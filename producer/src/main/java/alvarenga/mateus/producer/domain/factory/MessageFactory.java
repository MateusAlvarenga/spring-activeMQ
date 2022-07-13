package alvarenga.mateus.producer.domain.factory;

import alvarenga.mateus.producer.domain.vo.Message;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.sql.Timestamp;
import java.util.Random;

public class MessageFactory {
    public static Message createMessage() {
        Message message = new Message();
        message.setRandomNumber(new Random().nextInt(100));
        message.setCreatedAt(String.valueOf(new Timestamp(System.currentTimeMillis())));
        return message;
    }

    @SneakyThrows
    public  static  String createMessageAsJSON() {
        Message message = createMessage();
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        return mapper.writeValueAsString(message);
    }
}
