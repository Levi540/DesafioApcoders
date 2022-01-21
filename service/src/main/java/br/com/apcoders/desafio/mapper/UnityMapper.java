package br.com.apcoders.desafio.mapper;

import br.com.apcoders.desafio.api.model.CreateUnityDTO;
import br.com.apcoders.desafio.api.model.UnityDTO;
import br.com.apcoders.desafio.domain.entity.Unity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UnityMapper {

    public abstract UnityDTO fromEntityToDto(Unity unity);

    public abstract Unity fromCreateUnityDtoToEntity(CreateUnityDTO createUnityDTO);
}
