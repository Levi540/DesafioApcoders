package br.com.apcoders.desafio.domain.repository;

import br.com.apcoders.desafio.domain.entity.Unity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnityRepository extends JpaRepository<Unity, Long> {}
