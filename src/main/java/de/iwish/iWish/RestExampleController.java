package de.iwish.iWish;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class RestExampleController {
    @GetMapping(path = "/wish")
    public ResponseEntity<List<Wish>> getWishes() {
        List<Wish> wishes = new ArrayList<>();
        wishes.add(new Wish("Fußball", 10.9, LocalDate.of(2024, 4, 1), "www.amazon.de", Wish.Priority.MITTEL));
        wishes.add(new Wish("Laptop", 999.99, LocalDate.of(2024, 12, 25), "www.ebay.de", Wish.Priority.HOCH));
        wishes.add(new Wish("Buch", 14.99, LocalDate.of(2024, 6, 15), "www.buch.de", Wish.Priority.NIEDRIG));
        return ResponseEntity.ok(wishes);
    }
}