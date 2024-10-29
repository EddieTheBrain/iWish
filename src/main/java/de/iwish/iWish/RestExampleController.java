package de.iwish.iWish;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RestExampleController {
    @GetMapping(path = "/wish")
    public ResponseEntity<List<Wish>> getWishes() {
        ArrayList<Wish> wishInstances = new ArrayList<>();
        wishInstances.add(new Wish("Fußball", BigDecimal.valueOf(10.9), LocalDate.of(2024, 4, 1), "www.amazon.de", Wish.Priority.MITTEL));
        wishInstances.add(new Wish("Laptop", BigDecimal.valueOf(999.99), LocalDate.of(2024, 12, 25), "www.ebay.de", Wish.Priority.HOCH));
        wishInstances.add(new Wish("Buch", BigDecimal.valueOf(14.99), LocalDate.of(2024, 6, 15), "www.buch.de", Wish.Priority.NIEDRIG));
        return ResponseEntity.ok(wishInstances);
    }
}