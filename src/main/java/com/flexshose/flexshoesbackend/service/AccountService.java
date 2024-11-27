package com.flexshose.flexshoesbackend.service;

import java.util.List;

import com.flexshose.flexshoesbackend.dto.AccountDTO;
import com.flexshose.flexshoesbackend.exception.MyAppException;

public interface AccountService {
	public AccountDTO save(AccountDTO account) throws MyAppException;

	public AccountDTO findByID(Integer id) throws MyAppException;

	public AccountDTO updatePassword(Integer id, AccountDTO account) throws MyAppException;

	public String delete(Integer id) throws MyAppException;

	public List<AccountDTO> findAllAccount() throws MyAppException;
	
	public AccountDTO getMyInfor() throws MyAppException;
	
}
