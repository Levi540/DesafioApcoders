package br.com.apcoders.desafio.controller;

import static java.util.concurrent.CompletableFuture.supplyAsync;

import br.com.apcoders.desafio.api.facade.TenantsApi;
import br.com.apcoders.desafio.api.model.CreateTenantDTO;
import br.com.apcoders.desafio.api.model.TenantDTO;
import br.com.apcoders.desafio.service.TenantService;
import br.com.apcoders.desafio.util.ResponseEntityUtils;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TenantController implements TenantsApi {
    private final Executor controllersExecutor;
    private final TenantService tenantService;

    public TenantController(Executor controllerExecutor, TenantService tenantService) {
        this.controllersExecutor = controllerExecutor;
        this.tenantService = tenantService;
    }

    @Override
    public CompletableFuture<ResponseEntity<List<TenantDTO>>> listTenant(String name, Integer age, String sex, String telephone, String email) {
        return supplyAsync(tenantService::listTenant, controllersExecutor).thenApply(ResponseEntityUtils::ok);
    }

    @Override
    public CompletableFuture<ResponseEntity<TenantDTO>> createTenant(CreateTenantDTO createTenantDTO) {
        return supplyAsync(() -> tenantService
            .createTenant(createTenantDTO), controllersExecutor)
            .thenApply(ResponseEntityUtils::created);
    }
}
