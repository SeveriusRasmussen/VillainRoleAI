package webclientgroup.villainroleai.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import webclientgroup.villainroleai.API.Message;
import webclientgroup.villainroleai.API.VillianRequest;
import webclientgroup.villainroleai.API.VillianReponse;

import java.util.List;

@Service
public class VillianService {
    @Value("${api.key}")
    private String key;



    public void getResponse() {
        VillianRequest villianRequest = new VillianRequest();
        WebClient webClient = WebClient.create("https://api.mistral.ai");

        villianRequest.setRole("user");
        villianRequest.setModel("mistral-small-latest");
        villianRequest.setTemperature(1);
        Message message = new Message("user", "Hello, I am a villain. How do i conquer the world?");
        villianRequest.setMessages(List.of(message));




        webClient.post()
                .uri("/v1/chat/completions")
                .header("Authorization", key)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(villianRequest)
                .retrieve()
                .bodyToMono(VillianReponse.class)
                .subscribe(response -> {
                    String content = response.getContents();
                    System.out.println("AI: " + content);
                });

        System.out.println(villianRequest);


    }
}



