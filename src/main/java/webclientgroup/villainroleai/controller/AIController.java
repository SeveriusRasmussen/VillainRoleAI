package webclientgroup.villainroleai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import webclientgroup.villainroleai.service.VillainService;

@RestController
public class AIController {

    private VillainService villainService;

    public AIController(VillainService villainService) {
        this.villainService = villainService;
    }

    @GetMapping("/Villian")
    public void getVillian() {
        villainService.getResponse();


    }
}
