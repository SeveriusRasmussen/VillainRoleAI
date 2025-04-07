package webclientgroup.villainroleai.api;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VillainRequest {

   private String model;
   private List<Message> messages;
   private double temperature;


}
