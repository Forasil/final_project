package ru.iagodka15.currencytracking.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.iagodka15.currencytracking.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    @Query(value = """
        SELECT * FROM currency
        LIMIT :limit
        OFFSET :offset
    """, nativeQuery = true)
    List<Currency> findCurrenciesPage(int limit, int offset);

    @Query(value = """
        SELECT * FROM currency;
    """, nativeQuery = true)
    Stream<Currency> findAllCurrencies();

    @Query("""
        SELECT c FROM Currency c WHERE c.currencyName = :currencyName
    """)
    List<Currency> findCurrenciesByName(String currencyName);

}