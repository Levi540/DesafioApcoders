package br.com.apcoders.desafio.service;

import br.com.apcoders.desafio.api.model.CreateUnityDTO;
import br.com.apcoders.desafio.api.model.UnityDTO;
import br.com.apcoders.desafio.domain.repository.UnityRepository;
import br.com.apcoders.desafio.mapper.UnityMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class UnityService {
    private final UnityRepository unityRepository;
    private final UnityMapper unityMapper;

    public UnityService(UnityRepository unityRepository, UnityMapper unityMapper) {
        this.unityRepository = unityRepository;
        this.unityMapper = unityMapper;
    }

    public List<UnityDTO> listUnits() {
        var units = unityRepository.findAll();
        return units.stream().map(unityMapper::fromEntityToDto).collect(Collectors.toList());
    }

    public UnityDTO createUnity(CreateUnityDTO createUnityDTO) {
        var unity = unityMapper.fromCreateUnityDtoToEntity(createUnityDTO);
        unityRepository.save(unity);
        return unityMapper.fromEntityToDto(unity);
    }
}
