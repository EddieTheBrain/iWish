package de.iwish.iWish.controller;

import de.iwish.iWish.entity.Wish;
import de.iwish.iWish.service.WishService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/wishes")
public class RestExampleController {

    private final WishService wishService;

    @GetMapping
    public ResponseEntity<List<Wish>> getWishes() {
        ArrayList<Wish> wishInstances = new ArrayList<>();
        wishService.getWishes().forEach(wishInstances::add);
        return ResponseEntity.ok(wishInstances);
    }

    @PostMapping
    public ResponseEntity<Wish> addWish(@Valid @RequestBody final Wish wish) {
        final Wish created = wishService.addWish(wish);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{wish}")
    public void deleteWish(@PathVariable Wish wish) {
        wishService.deleteWish(wish);
    }
}