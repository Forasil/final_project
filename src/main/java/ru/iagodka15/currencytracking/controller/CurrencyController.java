package ru.iagodka15.currencytracking.controller;

import ru.iagodka15.currencytracking.model.Currency;
import ru.iagodka15.currencytracking.model.CurrencyRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/currencies")
public class CurrencyController {

    // Имитация базы данных
    private final Map<String, Currency> currencies = new HashMap<>();

    // Метод для получения списка всех валют

    @GetMapping
    public ResponseEntity<List<Currency>> getCurrencies() {
        return ResponseEntity.ok(new ArrayList<>(currencies.values()));
    }

    // Метод для добавления новой валюты

    @PostMapping
    public ResponseEntity<Currency> addCurrency(@RequestBody CurrencyRequest request) {
        // Генерация уникального идентификатора
        String id = UUID.randomUUID().toString();
        Currency currency = new Currency(
                id,
                request.getName(),
                request.getBaseCurrency(),
                request.getPriceChangeRange(),
                request.getDescription()
        );
        currencies.put(id, currency);
        return ResponseEntity.status(HttpStatus.CREATED).body(currency);
    }

    // Метод для получения информации о конкретной валюте

    @GetMapping("/{id}")
    public ResponseEntity<Currency> getCurrencyById(@PathVariable String id) {
        if (!currencies.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(currencies.get(id));
    }

    // Метод для обновления данных валюты

    @PutMapping("/{id}")
    public ResponseEntity<Currency> updateCurrency(@PathVariable String id, @RequestBody CurrencyRequest request) {
        if (!currencies.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        Currency updatedCurrency = new Currency(
                id,
                request.getName(),
                request.getBaseCurrency(),
                request.getPriceChangeRange(),
                request.getDescription()
        );
        currencies.put(id, updatedCurrency);
        return ResponseEntity.ok(updatedCurrency);
    }

    // Метод для удаления валюты

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurrency(@PathVariable String id) {
        if (!currencies.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        currencies.remove(id);
        return ResponseEntity.noContent().build();
    }
}