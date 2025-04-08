package webclientgroup.villainroleai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import webclientgroup.villainroleai.aiapi.VillainResponse;
import webclientgroup.villainroleai.foxapi.Fox;
import webclientgroup.villainroleai.service.FoxService;
import webclientgroup.villainroleai.service.VillainService;

@RestController
public class AIController {
    private final VillainService villainService;
    private final FoxService foxService;

    public AIController(VillainService villainService, FoxService foxService) {
        this.villainService = villainService;
        this.foxService = foxService;
    }

    //send RequestParam question to AI and return AI response.
    @GetMapping("/villain")
    public Mono<VillainResponse> getVillain(@RequestParam String question) {
        return villainService.getResponse(question);
    }

    @GetMapping("/fox")
    public Mono<Fox> getFox(){
        return foxService.getRandomFox();
    }
}
