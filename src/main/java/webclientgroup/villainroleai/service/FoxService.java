package webclientgroup.villainroleai.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import webclientgroup.villainroleai.foxapi.Fox;

@Service
public class FoxService {
    public Mono<Fox> getRandomFox(){

        WebClient webClient = WebClient.create("https://randomfox.ca");

        Mono<Fox> monoFox = webClient.get().
                uri("/floof/").
                retrieve().
                bodyToMono(Fox.class);

        return monoFox;
    }
}
