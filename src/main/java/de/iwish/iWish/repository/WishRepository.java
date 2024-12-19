package de.iwish.iWish.repository;

import de.iwish.iWish.entity.Wish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishRepository extends CrudRepository<Wish, Integer> {
}
