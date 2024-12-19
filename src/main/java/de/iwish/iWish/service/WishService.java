package de.iwish.iWish.service;

import de.iwish.iWish.entity.Wish;
import de.iwish.iWish.repository.WishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishService {

    @Autowired
    private WishRepository repository;

    public Iterable<Wish> getWishes() {
        return this.repository.findAll();
    }

    public Wish addWish(Wish wish) {
        return this.repository.save(wish);
    }

    public void deleteWish(Wish wish) {
        this.repository.delete(wish);
    }
}
