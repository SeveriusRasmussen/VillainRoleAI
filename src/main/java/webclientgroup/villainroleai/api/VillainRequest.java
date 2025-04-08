package webclientgroup.villainroleai.api;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VillainRequest { //messages sent to AI.
   private String model; //defines AI model. eg mistral, latest, small, large.
   private List<Message> messages;
   private double temperature;
}
