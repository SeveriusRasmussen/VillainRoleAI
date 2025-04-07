package webclientgroup.villainroleai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import webclientgroup.villainroleai.api.VillainResponse;
import webclientgroup.villainroleai.service.VillainService;

@RestController
public class AIController {

    private VillainService villainService;

    public AIController(VillainService villainService) {
        this.villainService = villainService;
    }

    @GetMapping("/villain")
    public Mono<VillainResponse> getVillain() {
        return villainService.getResponse();
    }
}
