package de.iwish.iWish;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Wish {
    private final UUID wishId = UUID.randomUUID();
    private String name;
    private BigDecimal price;
    private LocalDate dateOfCreation;
    private String link;
    private Priority priority; public enum Priority{HOCH, MITTEL, NIEDRIG}
}
