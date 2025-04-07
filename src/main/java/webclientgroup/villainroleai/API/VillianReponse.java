package webclientgroup.villainroleai.API;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class VillianReponse {

    private String role;
    private String contents;
    private List<String> Message;

}
