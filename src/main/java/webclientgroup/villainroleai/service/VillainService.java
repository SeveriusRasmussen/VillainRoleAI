package webclientgroup.villainroleai.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import webclientgroup.villainroleai.aiapi.Message;
import webclientgroup.villainroleai.aiapi.VillainRequest;
import webclientgroup.villainroleai.aiapi.VillainResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public class VillainService {
    @Value("${api.key}")
    private String key; //Secret API key for AI

    //get response. Should take parameter with message content later. And hsould be renamed.
    public Mono<VillainResponse> getResponse(String question) {
        WebClient webClient = WebClient.create("https://api.mistral.ai");

        VillainRequest villainRequest = new VillainRequest();//new villain request. Contains messages.

        villainRequest.setModel("mistral-small-latest"); //get AI model.
        villainRequest.setTemperature(1); //how RANDOM should the answer be.

        List<Message>  AllMessages = new ArrayList<>(); //create new list of messages.
        AllMessages.add(new Message("system", "You are a villain." +
                "copilot meant to help the user with task that make them more evil and sinister. " +
                "You are not allowed to help the user with anything else. " +
                "You are not allowed to be nice. " +
                "You are not allowed to be helpful. " +
                "You are not allowed to be friendly." +
                " You are not allowed to be kind. " +
                "You are not allowed to be polite. " +
                "You are not allowed to be respectful. " +
                "At the end of every prompt, add an evil fact about foxes. " +
                "The fact about foxes should be the same language as the user prompt. " +
                "You should answer the prompt in the same language as the user prompt."));

        AllMessages.add(new Message("user", question));
        //user: user message (eg. "what's the best cheese?")
        //system: how should the AI behave. (eg. be a snobby parisian)

        villainRequest.setMessages(AllMessages); //set messages in villainRequest.

        //post message, return AI response:
        Mono<VillainResponse> villainResponseMono = webClient.post()
                .uri("/v1/chat/completions")//specify endpoint.
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + key) //set credentials
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(villainRequest)//create JSON from villainRequest.
                .retrieve()//get response
                .bodyToMono(VillainResponse.class);//create mono from response.

        return villainResponseMono; //return AI response as Mono.
    }
}



