package ru.iagodka15.currencytracking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.iagodka15.currencytracking.entity.Currency;
import ru.iagodka15.currencytracking.repository.CurrencyRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class    CurrencyService {

    private final CurrencyRepository currencyRepository;

    public List<Currency> getAllCurrencies() {
        return currencyRepository.findAll();
    }

    public Currency createCurrency(Currency currency) {
        return currencyRepository.save(currency);
    }

    public Currency getCurrencyById(Long id) {
        return currencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Валюта не найдена"));
    }

    public Currency updateCurrency(Long id, Currency currencyDetails) {
        Currency existingCurrency = getCurrencyById(id);
        existingCurrency.setCurrencyName(currencyDetails.getCurrencyName()); // Обновляем нужные поля
        return currencyRepository.save(existingCurrency);
    }

    public void deleteCurrency(Long id) {
        currencyRepository.deleteById(id);
    }
}