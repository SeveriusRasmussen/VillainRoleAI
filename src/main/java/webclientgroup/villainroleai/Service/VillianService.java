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



    public void getResponse(Villian villian) {

        WebClient webClient = WebClient.create("https://api.mistral.ai/v1/chat/completions");

        villian.setRole("user");
        villian.setModel("mistral-small-latest");
        villian.setTemperature(1);
        villian.setMessage("boo ");



        webClient.post()
                .uri("https://api.mistral.ai/v1/chat/completions")
                .header("Authorization", key)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(villian)
                .retrieve()
                .bodyToMono(VillianReponse.class)
                .subscribe(response -> {
                    String content = response.getReturnMessage();
                    System.out.println("AI: " + content);
                });

        System.out.println(villian);


    }
}



