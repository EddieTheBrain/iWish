package de.iwish.iWish;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class Wish {
    private String name;
    private double price;
    private LocalDate date;
    private String link;
    private Priority priority; public enum Priority{HOCH, MITTEL, NIEDRIG}

}
