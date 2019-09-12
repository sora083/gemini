package com.sora.proto.gemini.controller;

import com.sora.proto.gemini.domain.Currency;
import com.sora.proto.gemini.service.CurrencyService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping("/")
    public ResponseEntity<CurrencyResponse> getCurrencies() {
        List<Currency> currencies = currencyService.findAll();
        CurrencyResponse currencyResponse = new CurrencyResponse(currencies);
        return new ResponseEntity<>(currencyResponse, HttpStatus.OK);
    }

    @Getter
    @AllArgsConstructor
    private class CurrencyResponse {

        private List<Currency> currencies;
    }

    @PostMapping("/")
    public ResponseEntity<HttpStatus> save(@Valid @RequestBody CurrencyAddRequest request) {
        currencyService.save(request.getName(), request.getSymbol());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Getter
    @Setter
    private static class CurrencyAddRequest {
        @NotNull
        private String name;

        @NotNull
        private String symbol;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        currencyService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
