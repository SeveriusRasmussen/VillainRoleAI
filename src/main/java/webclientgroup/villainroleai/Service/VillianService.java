package webclientgroup.villainroleai.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import webclientgroup.villainroleai.API.Villian;
import webclientgroup.villainroleai.API.VillianReponse;

@Service
public class VillianService {
    @Value("${api.key}")
    private String key;



    public String getResponse(Villian villian) {

        WebClient webClient = WebClient.create("");

        villian.setRole("user");
        villian.setModel("mistral-small-latest");


        webClient.post()
                .uri("https://api.mistral.ai/v1/chat/completions")
                .header("Authorization", key)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(villian)
                .retrieve()
                .bodyToMono(VillianReponse.class);
        


        return VillianReponse;


    }
}



