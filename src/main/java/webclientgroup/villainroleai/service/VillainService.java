package webclientgroup.villainroleai.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import webclientgroup.villainroleai.api.Message;
import webclientgroup.villainroleai.api.VillainRequest;
import webclientgroup.villainroleai.api.VillainResponse;

import java.util.List;

@Service
public class VillainService {
    @Value("${api.key}")
    private String key; //Secret API key for AI

    //get response. Should take parameter with message content later. And hsould be renamed.
    public Mono<VillainResponse> getResponse() {
        WebClient webClient = WebClient.create("https://api.mistral.ai");

        VillainRequest villainRequest = new VillainRequest();//new villain request. Contains messages.

        villainRequest.setModel("mistral-small-latest"); //get AI model.
        villainRequest.setTemperature(1); //how RANDOM should the answer be.
        Message message = new Message("user", "Hello, I am a villain. How do i conquer the world?"); //set role and content of message.
        //user: user message (eg. "what's the best cheese?")
        //system: how should the AI behave. (eg. be a snobby parisian)

        villainRequest.setMessages(List.of(message)); //set messages in villainRequest. List.of(message) creates new List<Message> containing message.

        //post message, return AI response:
        Mono<VillainResponse> villainResponseMono = webClient.post()
                .uri("/v1/chat/completions")//specify endpoint.
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + key) //set credentials
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(villainRequest)//create JSON from villainRequest.
                .retrieve()//get response
                .bodyToMono(VillainResponse.class);//create mono from response.
                /*.subscribe(response -> { //??
                    String content = response.getChoices().get(0).getMessage().getContent(); //get content from response.
                    System.out.println("AI: " + content); //print content.
                });
*/
        //System.out.println(villianRequest); //
        return villainResponseMono;
    }
}



