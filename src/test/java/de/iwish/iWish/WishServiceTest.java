package de.iwish.iWish;

import de.iwish.iWish.entity.Wish;
import de.iwish.iWish.repository.WishRepository;
import de.iwish.iWish.service.WishService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

class WishServiceTest {

    @InjectMocks
    private WishService wishService;

    @Mock
    private WishRepository wishRepository;

    @BeforeEach
    void setUpMockRepository() {
        MockitoAnnotations.openMocks(this);
        final Wish handy = new Wish("handy", BigDecimal.valueOf(123), LocalDate.of(2024, 12, 24), "link1", Wish.Priority.HOCH);
        final Wish buch = new Wish("buch", BigDecimal.valueOf(1234), LocalDate.of(2022, 11, 23), "link2", Wish.Priority.NIEDRIG);
        doReturn(List.of(handy, buch)).when(wishRepository).findAll();
    }

    @Test
    void getWishes() {
        final Iterable<Wish> resultAsIterable = wishService.getWishes();
        final List<Wish> result = StreamSupport.stream(resultAsIterable.spliterator(), false).toList();
        assertEquals(2, result.size());
    }
}