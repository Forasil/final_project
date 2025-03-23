package ru.iagodka15.currencytracking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyRequest {
    private String name;
    private String baseCurrency;
    private String priceChangeRange;
    private String description;
}