package br.com.apcoders.desafio.service;

import static java.util.Objects.requireNonNull;

import br.com.apcoders.desafio.api.model.CreateUnitExpenseDTO;
import br.com.apcoders.desafio.api.model.UnitExpenseDTO;
import br.com.apcoders.desafio.api.model.UpdateUnitExpenseDTO;
import br.com.apcoders.desafio.domain.entity.UnitExpense;
import br.com.apcoders.desafio.domain.repository.UnitExpensesRepository;
import br.com.apcoders.desafio.exception.UnitExpenseNotFoundException;
import br.com.apcoders.desafio.mapper.UnitExpenseMapper;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UnitExpenseService {
    private final UnitExpensesRepository unitExpensesRepository;
    private final UnitExpenseMapper unitExpenseMapper;

    public UnitExpenseService(UnitExpensesRepository unitExpensesRepository, UnitExpenseMapper unitExpenseMapper) {
        this.unitExpensesRepository = unitExpensesRepository;
        this.unitExpenseMapper = unitExpenseMapper;
    }

    public UnitExpenseDTO createUnitExpense(CreateUnitExpenseDTO createUnitExpenseDTO) {
        var unitExpense = unitExpenseMapper.fromCreateUnitExpenseDtoToEntity(createUnitExpenseDTO);
        unitExpensesRepository.save(unitExpense);
        return unitExpenseMapper.fromEntityToDto(unitExpense);
    }

    public List<UnitExpenseDTO> listUnitExpense(Long idUnity, LocalDate invoiceDueDate) {
        var listUnitExpense = unitExpensesRepository.findAllWithFilters(idUnity, invoiceDueDate);
        return listUnitExpense.stream().map(unitExpenseMapper::fromEntityToDto).collect(Collectors.toList());
    }

    private UnitExpense getUnitExpenseOrThrow(Long unitExpenseId) {
        requireNonNull(unitExpenseId);
        return unitExpensesRepository
            .findById(unitExpenseId)
            .orElseThrow(() -> new UnitExpenseNotFoundException("Unit expense not found: " + unitExpenseId));
    }

    @Transactional
    public void updateUnitExpense(Long unitExpenseId, UpdateUnitExpenseDTO updateUnitExpenseDTO) {
        getUnitExpenseOrThrow(unitExpenseId);
        unitExpensesRepository.updateUnitExpense(
            unitExpenseId,
            updateUnitExpenseDTO.getUnitExpenseDescription(),
            updateUnitExpenseDTO.getTypeExpense(),
            updateUnitExpenseDTO.getAmount(),
            updateUnitExpenseDTO.getInvoiceDueDate(),
            updateUnitExpenseDTO.getPaymentStatus(),
            updateUnitExpenseDTO.getIdUnity()
        );
    }
}
