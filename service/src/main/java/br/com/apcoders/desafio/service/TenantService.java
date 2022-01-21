package br.com.apcoders.desafio.service;

import br.com.apcoders.desafio.api.model.CreateTenantDTO;
import br.com.apcoders.desafio.api.model.TenantDTO;
import br.com.apcoders.desafio.domain.repository.TenantRepository;
import br.com.apcoders.desafio.mapper.TenantMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class TenantService {
    private final TenantRepository tenantRepository;
    private final TenantMapper tenantMapper;

    public TenantService(TenantRepository tenantRepository, TenantMapper tenantMapper) {
        this.tenantRepository = tenantRepository;
        this.tenantMapper = tenantMapper;
    }

    public List<TenantDTO> listTenant() {
        var tenants = tenantRepository.findAll();
        return tenants
            .stream()
            .map(tenantMapper::fromEntityToDto)
            .collect(Collectors.toList());
    }

    public TenantDTO createTenant(CreateTenantDTO createTenantDTO) {
        var tenant = tenantMapper.fromCreateTenantDtoToEntity(createTenantDTO);
        tenantRepository.save(tenant);
        return tenantMapper.fromEntityToDto(tenant);
    }
}
