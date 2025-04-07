package webclientgroup.villainroleai.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import webclientgroup.villainroleai.API.VillianRequest;
import webclientgroup.villainroleai.Service.VillianService;

@RestController
public class AIController {

    private VillianService villianService;

    public AIController(VillianService villianService) {
        this.villianService = villianService;
    }

    @GetMapping("/Villian")
    public void getVillian() {
        villianService.getResponse();


    }
}
