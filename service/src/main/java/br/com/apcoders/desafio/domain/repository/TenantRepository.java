package br.com.apcoders.desafio.domain.repository;

import br.com.apcoders.desafio.domain.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {}
