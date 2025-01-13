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
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

    @Test
    void addWishTest() {
        Wish newWish = new Wish("laptop", BigDecimal.valueOf(999.99), LocalDate.of(2024, 12, 25), "link3", Wish.Priority.MITTEL);

        when(wishRepository.save(newWish)).thenReturn(newWish);

        Wish result = wishService.addWish(newWish);

        assertEquals(newWish.getName(), result.getName());
        assertEquals(newWish.getPrice(), result.getPrice());
        assertEquals(newWish.getPriority(), result.getPriority());
        assertEquals(newWish.getLink(), result.getLink());
        assertEquals(newWish.getDateOfCreation(), result.getDateOfCreation());
    }

    @Test
    void deleteWishTest() {
        Wish wishToDelete = new Wish("buch", BigDecimal.valueOf(1234), LocalDate.of(2022, 11, 23), "link2", Wish.Priority.NIEDRIG);

        wishService.deleteWish(wishToDelete);

        assertTrue(wishRepository.findById(wishToDelete.getId()).isEmpty());
    }

    @Test
    void addWish_invalidWish_shouldThrowException() {
        Wish invalidWish = new Wish("", BigDecimal.valueOf(-123), LocalDate.of(2024, 12, 25), "link3", Wish.Priority.MITTEL);
        when(wishRepository.save(invalidWish)).thenThrow(new IllegalArgumentException("Invalid wish"));

        assertThrows(IllegalArgumentException.class, () -> wishService.addWish(invalidWish));
    }

    @Test
    void getWishes_noWishesFound_shouldReturnEmptyList() {
        doReturn(List.of()).when(wishRepository).findAll();

        Iterable<Wish> result = wishService.getWishes();
        assertEquals(0, StreamSupport.stream(result.spliterator(), false).count());
    }

    @Test
    void getWishes_repositoryFails_shouldThrowException() {
        when(wishRepository.findAll()).thenThrow(new RuntimeException("Database error"));

        assertThrows(RuntimeException.class, () -> wishService.getWishes());
    }

    @Test
    void deleteWish_callsRepositoryDelete() {
        Wish wishToDelete = new Wish("buch", BigDecimal.valueOf(1234), LocalDate.of(2022, 11, 23), "link2", Wish.Priority.NIEDRIG);

        wishService.deleteWish(wishToDelete);

        verify(wishRepository, times(1)).delete(wishToDelete);
    }
}