package de.iwish.iWish;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class RestExampleController {
    @GetMapping(path = "/wish")
    public List<Wish> getAllWishes(){
        return service.getAll;
    }
}