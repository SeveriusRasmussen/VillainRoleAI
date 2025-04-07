package webclientgroup.villainroleai.API;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class VillianRequest {

   private String model;
   private List<Message> messages;
   private double temperature;


}
