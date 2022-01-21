package br.com.apcoders.desafio.controller;

import static java.util.concurrent.CompletableFuture.runAsync;
import static java.util.concurrent.CompletableFuture.supplyAsync;

import br.com.apcoders.desafio.api.facade.UnitExpensesApi;
import br.com.apcoders.desafio.api.model.CreateUnitExpenseDTO;
import br.com.apcoders.desafio.api.model.UnitExpenseDTO;
import br.com.apcoders.desafio.api.model.UpdateUnitExpenseDTO;
import br.com.apcoders.desafio.service.UnitExpenseService;
import br.com.apcoders.desafio.util.ResponseEntityUtils;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnitExpenseController implements UnitExpensesApi {
    private final Executor controllersExecutor;
    private final UnitExpenseService unitExpenseService;

    public UnitExpenseController(Executor controllersExecutor, UnitExpenseService unitExpenseService) {
        this.controllersExecutor = controllersExecutor;
        this.unitExpenseService = unitExpenseService;
    }

    @Override
    public CompletableFuture<ResponseEntity<UnitExpenseDTO>> createUnitExpense(CreateUnitExpenseDTO createUnitExpenseDTO) {
        return supplyAsync(() -> unitExpenseService.createUnitExpense(createUnitExpenseDTO), controllersExecutor)
            .thenApply(ResponseEntityUtils::created);
    }

    @Override
    public CompletableFuture<ResponseEntity<List<UnitExpenseDTO>>> listUnitExpenses(Long idUnity, LocalDate invoiceDueDate) {
        return supplyAsync(() -> unitExpenseService.listUnitExpense(idUnity, invoiceDueDate), controllersExecutor)
            .thenApply(ResponseEntityUtils::ok);
    }

    @Override
    public CompletableFuture<ResponseEntity<Void>> updateUnitExpense(Long id, UpdateUnitExpenseDTO updateUnitExpenseDTO) {
        return runAsync(() -> unitExpenseService.updateUnitExpense(id, updateUnitExpenseDTO), controllersExecutor)
            .thenApply(ResponseEntityUtils::noContent);
    }
}
