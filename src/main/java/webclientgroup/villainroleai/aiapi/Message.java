package webclientgroup.villainroleai.aiapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Message {
    private String role; //user, system(ai behavior), or assistant (ai)
    private String content;

}
