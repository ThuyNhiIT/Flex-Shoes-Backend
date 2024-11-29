package com.flexshose.flexshoesbackend.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexshose.flexshoesbackend.dto.AccountDTO;
import com.flexshose.flexshoesbackend.dto.response.MyAPIResponse;
import com.flexshose.flexshoesbackend.exception.MyAppException;
import com.flexshose.flexshoesbackend.service.AccountService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class AccountController {
	AccountService accountService;
	
	
	@PostMapping("/register")
	public MyAPIResponse<AccountDTO> register(@RequestBody AccountDTO accountDTO) throws MyAppException{
		MyAPIResponse<AccountDTO> result = new MyAPIResponse<AccountDTO>();
			result.setResult(accountService.save(accountDTO));
		return result;	
	}
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/findByID/{id}")
	public MyAPIResponse<AccountDTO> findByUserName(@PathVariable Integer id) throws MyAppException {	
		log.info("We are staying get all users medthod");
		Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
		log.warn("User currently logged in: " + auth.getPrincipal().toString());
		MyAPIResponse<AccountDTO> result = new MyAPIResponse<AccountDTO>();
		result.setResult(accountService.findByID(id));
		return result;	
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/getAll")
	public MyAPIResponse<List<AccountDTO>> getAllUser() throws MyAppException {
		log.info("We are staying get all users medthod");
		Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
		log.warn("User currently logged in: " + auth.getName());
		auth.getAuthorities().forEach(a -> log.warn(a.getAuthority()));
		MyAPIResponse<List<AccountDTO>> result = new MyAPIResponse<List<AccountDTO>>();
		result.setResult(accountService.findAllAccount());
		return result;
	}
	@PreAuthorize("hasRole('USER')")
	@PutMapping("/update/{id}")
	public MyAPIResponse<AccountDTO> update(@PathVariable Integer id, @RequestBody AccountDTO accountDTO) throws MyAppException{
		MyAPIResponse<AccountDTO> result = new MyAPIResponse<AccountDTO>();
		result.setResult( accountService.updatePassword(id, accountDTO));
		return result;
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	public MyAPIResponse<String> delete(@PathVariable Integer id) throws MyAppException{
        MyAPIResponse<String> result = new MyAPIResponse<String>();
        result.setResult(accountService.delete(id));
        return result;
	}
	@GetMapping("/getMyInfor")
	public MyAPIResponse<AccountDTO> getMyInfor() throws MyAppException {
		MyAPIResponse<AccountDTO> result = new MyAPIResponse<AccountDTO>();
		result.setResult(accountService.getMyInfor());
		return result;
	}
}

