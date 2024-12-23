package de.iwish.iWish.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Wish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private BigDecimal price;
    private LocalDate dateOfCreation;
    private String link;
    private Priority priority; public enum Priority{HOCH, MITTEL, NIEDRIG}

    public Wish(String name, BigDecimal price, LocalDate dateOfCreation, String link, Priority priority) {
        this.name = name;
        this.price = price;
        this.dateOfCreation = dateOfCreation;
        this.link = link;
        this.priority = priority;
    }
}
