package webclientgroup.villainroleai.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
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
    private String key; //Secret API key for AI

    //get response. Should take parameter with message content later. And hsould be renamed.
    public void getResponse() {
        WebClient webClient = WebClient.create("https://api.mistral.ai");

        VillianRequest villianRequest = new VillianRequest();//new villain request. Contains messages.

        villianRequest.setModel("mistral-small-latest"); //get AI model.
        villianRequest.setTemperature(1); //how RANDOM should the answer be.
        Message message = new Message("user", "Hello, I am a villain. How do i conquer the world?"); //set role and content of message.
        //user: user message (eg. "what's the best cheese?")
        //system: how should the AI behave. (eg. be a snobby parisian)

        villianRequest.setMessages(List.of(message)); //set messages in villainRequest. List.of(message) creates new List<Message> containing message.

        //post message, return AI response:
        webClient.post()
                .uri("/v1/chat/completions")//specify endpoint.
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + key) //set credentials
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(villianRequest)//create JSON from villainRequest.
                .retrieve()//get response
                .bodyToMono(VillianReponse.class)//create mono from response.
                .subscribe(response -> { //??
                    String content = response.getChoices().get(0).getMessage().getContent(); //get content from response.
                    System.out.println("AI: " + content); //print content.
                });

        //System.out.println(villianRequest); //
    }
}



