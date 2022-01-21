package br.com.apcoders.desafio.controller;

import static java.util.concurrent.CompletableFuture.supplyAsync;

import br.com.apcoders.desafio.api.facade.UnitsApi;
import br.com.apcoders.desafio.api.model.CreateUnityDTO;
import br.com.apcoders.desafio.api.model.UnityDTO;
import br.com.apcoders.desafio.service.UnityService;
import br.com.apcoders.desafio.util.ResponseEntityUtils;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnityController implements UnitsApi {
    private final Executor controllersExecutor;
    private final UnityService unityService;

    public UnityController(Executor controllersExecutor, UnityService unityService) {
        this.controllersExecutor = controllersExecutor;
        this.unityService = unityService;
    }

    @Override
    public CompletableFuture<ResponseEntity<UnityDTO>> createUnity(CreateUnityDTO createUnityDTO) {
        return supplyAsync(() -> unityService.createUnity(createUnityDTO), controllersExecutor)
            .thenApply(ResponseEntityUtils::created);
    }

    @Override
    public CompletableFuture<ResponseEntity<List<UnityDTO>>> listUnity() {
        return supplyAsync(unityService::listUnits, controllersExecutor).thenApply(ResponseEntityUtils::ok);
    }
}
