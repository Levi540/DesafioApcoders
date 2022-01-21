package br.com.apcoders.desafio.mapper;

import br.com.apcoders.desafio.api.model.CreateTenantDTO;
import br.com.apcoders.desafio.api.model.TenantDTO;
import br.com.apcoders.desafio.domain.entity.Tenant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class TenantMapper {

    public abstract TenantDTO fromEntityToDto(Tenant tenant);

    public abstract Tenant fromCreateTenantDtoToEntity(CreateTenantDTO createTenantDTO);
}
