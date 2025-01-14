package de.iwish.iWish;

import de.iwish.iWish.entity.Wish;
import de.iwish.iWish.service.WishService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RestControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WishService wishService;

    @BeforeEach
    void setUpMockRepository() {
        Wish laptop = new Wish(1, "laptop", BigDecimal.valueOf(999.99), LocalDate.of(2024, 12, 25), "link3", Wish.Priority.MITTEL);
        Wish buch = new Wish(2, "buch", BigDecimal.valueOf(1234), LocalDate.of(2022, 11, 23), "link2", Wish.Priority.NIEDRIG);
        when(wishService.getWishes()).thenReturn(List.of(laptop, buch));
    }

    @Test
    void shouldReturnWishesAsJson() throws Exception {
        this.mockMvc.perform(get("/api/wishes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("laptop"))
                .andExpect(jsonPath("$[0].price").value(999.99))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("buch"))
                .andExpect(jsonPath("$[1].price").value(1234));
    }
}