package webclientgroup.villainroleai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import webclientgroup.villainroleai.api.VillainResponse;
import webclientgroup.villainroleai.service.VillainService;

@RestController
public class AIController {
    private final VillainService villainService;

    public AIController(VillainService villainService) {
        this.villainService = villainService;
    }

    //send RequestParam question to AI and return AI response.
    @GetMapping("/villain")
    public Mono<VillainResponse> getVillain(@RequestParam String question) {
        return villainService.getResponse(question);
    }
}
