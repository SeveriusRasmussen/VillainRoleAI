package webclientgroup.villainroleai.API;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Villian {

   private  String role;
   private String model;
   private List<String> message;
   private double temperature;


}
