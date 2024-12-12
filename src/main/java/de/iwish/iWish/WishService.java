package de.iwish.iWish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishService {
    @Autowired
    private WishRepository repository;

    public Iterable<Wish> getWishes() {
        return this.repository.findAll();
    }
}
