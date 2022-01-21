package br.com.apcoders.desafio.mapper;

import br.com.apcoders.desafio.api.model.CreateUnitExpenseDTO;
import br.com.apcoders.desafio.api.model.UnitExpenseDTO;
import br.com.apcoders.desafio.domain.entity.UnitExpense;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UnitExpenseMapper {

    public abstract UnitExpenseDTO fromEntityToDto(UnitExpense unitExpense);

    public abstract UnitExpense fromCreateUnitExpenseDtoToEntity(CreateUnitExpenseDTO createUnitExpenseDTO);
}
