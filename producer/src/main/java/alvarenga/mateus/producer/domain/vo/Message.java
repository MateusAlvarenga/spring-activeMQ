package alvarenga.mateus.producer.domain.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
public class Message {
    public Integer randomNumber;
    public String createdAt;
}
