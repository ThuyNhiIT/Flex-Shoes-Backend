package com.flexshose.flexshoesbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.flexshose.flexshoesbackend.dto.AccountDTO;
import com.flexshose.flexshoesbackend.entity.Account;

@Mapper(componentModel = "spring")
public interface AccountMapper {

	AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

@Mapping(target = "customerId", source = "customer.customerId")
	AccountDTO maptoAccountDTO(Account account);
	Account maptoAccount(AccountDTO accountDTO);
}
