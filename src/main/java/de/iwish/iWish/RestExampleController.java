package de.iwish.iWish;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class RestExampleController {
    @GetMapping(path = "/wish")
    public ResponseEntity<List<Wish>> getWishes() {
        WishList instance = new WishList();
        return ResponseEntity.ok(instance.getInstance());
    }
}