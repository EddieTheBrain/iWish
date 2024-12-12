package de.iwish.iWish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WishService {
    @Autowired
    private WishRepository wishRepository;

    public Optional<Wish> getWish(int id) {
        return wishRepository.findById(id);
    }

    public Wish addWish(Wish wish) {
        return wishRepository.save(wish);
    }
}
