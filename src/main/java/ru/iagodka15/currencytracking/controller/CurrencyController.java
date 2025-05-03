package ru.iagodka15.currencytracking.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.iagodka15.currencytracking.entity.Currency;
import ru.iagodka15.currencytracking.service.CurrencyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currencies")
public class CurrencyController {

    private final CurrencyService currencyService;

    /**
     * Метод для получения списка всех валют
     */
    @GetMapping
    public List<Currency> getAllCurrencies() {
        return currencyService.getAllCurrencies();
    }

    /**
     * Метод для добавления новой валюты
     */
    @PostMapping
    public Currency createCurrency(@RequestBody Currency currency) {
        return currencyService.createCurrency(currency);
    }

    /**
     * Метод для получения информации о конкретной валюте
     */
    @GetMapping("/{id}")
    public Currency getCurrencyById(@PathVariable Long id) {
        return currencyService.getCurrencyById(id);
    }

    /**
     * Метод для обновления данных валюты
     */
    @PutMapping("/{id}")
    public Currency updateCurrency(@PathVariable Long id, @RequestBody Currency currencyDetails) {
        return currencyService.updateCurrency(id, currencyDetails);
    }

    /**
     * Метод для удаления валюты
     */
    @DeleteMapping("/{id}")
    public void deleteCurrency(@PathVariable Long id) {
        currencyService.deleteCurrency(id);
    }
}