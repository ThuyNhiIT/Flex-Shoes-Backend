package com.flexshose.flexshoesbackend.service.impl;

import java.util.List;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.flexshose.flexshoesbackend.dto.AccountDTO;
import com.flexshose.flexshoesbackend.entity.Account;
import com.flexshose.flexshoesbackend.entity.Customer;
import com.flexshose.flexshoesbackend.exception.ErrorCode;
import com.flexshose.flexshoesbackend.exception.MyAppException;
import com.flexshose.flexshoesbackend.mapper.AccountMapper;
import com.flexshose.flexshoesbackend.repository.AccountRepository;
import com.flexshose.flexshoesbackend.repository.CustomerRepository;
import com.flexshose.flexshoesbackend.service.AccountService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AccountServiceImpl implements AccountService {

	AccountMapper accountMapper;
	CustomerRepository customerRepository;
	AccountRepository accountRepository;
	PasswordEncoder passwordEncoder;

	@Override
	public AccountDTO save(AccountDTO accountDTO) throws MyAppException {
		// TODO Auto-generated method stub
		Account account = new Account();
		try {
			account = accountMapper.maptoAccount(accountDTO);
			account.setPassword(passwordEncoder.encode(accountDTO.getPassword()));
			Customer customer = customerRepository.findById(accountDTO.getCustomerId()).get();
			account.setCustomer(customer);
			accountRepository.save(account);
		} catch (Exception e) {
			// TODO: handle exception
			throw new MyAppException(ErrorCode.ACTION_FAILD);
		}

		return accountMapper.maptoAccountDTO(account);
	}

	@Override
	@PostAuthorize("returnObject.username == authentication.name")
	public AccountDTO findByID(Integer id) throws MyAppException {
		// TODO Auto-generated method stub
		
		return accountMapper.maptoAccountDTO(
				accountRepository.findById(id).orElseThrow(() -> new MyAppException(ErrorCode.USER_NOT_EXISTED)));

	}
	@Override
	@PostAuthorize("returnObject.username == authentication.username")
	public AccountDTO updatePassword(Integer id, AccountDTO accountDTO) throws MyAppException {
		Account account  = new Account();
		try {
			account = accountRepository.findById(id).orElseThrow(
					() -> new MyAppException(ErrorCode.USER_NOT_EXISTED));
			account.setPassword(passwordEncoder.encode( accountDTO.getPassword()));
			accountRepository.save(account);
		} catch (Exception e) {
			throw new MyAppException(ErrorCode.ACTION_FAILD);
		}
		return  accountMapper.maptoAccountDTO(account);
	}

	@Override
	public String delete(Integer id) throws MyAppException {
		// TODO Auto-generated method stub
		try {
			Account account = accountRepository.findById(id).orElseThrow(
					() ->  new MyAppException(ErrorCode.USER_NOT_EXISTED)
					);
			accountRepository.delete(account);
			return "Delete Success";
		} catch (Exception e) {
			// TODO: handle exception
			throw new MyAppException(ErrorCode.ACTION_FAILD);
		}
	

	}

	@Override
	public List<AccountDTO> findAllAccount() throws MyAppException {
		try {
			return accountRepository.findAll().stream().map(accountMapper::maptoAccountDTO).toList();
		} catch (Exception e) {
			// TODO: handle exception
			throw new MyAppException(ErrorCode.ACTION_FAILD);
		}
		
	}

	@Override
	public AccountDTO getMyInfor() throws MyAppException {
		// TODO Auto-generated method stub
		SecurityContext context =  SecurityContextHolder.getContext();
		String username = context.getAuthentication().getName();
		return accountMapper.maptoAccountDTO(accountRepository
				.findByUsername(username)
				.get()
				);
	}

}
