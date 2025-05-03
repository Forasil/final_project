package ru.iagodka15.currencytracking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Название валюты обязательно")
    @Column(name = "name")
    private String currencyName;
    private String baseCurrency;
    private String priceChangeRange;
    private String description;
}

