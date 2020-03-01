package az.payday.account.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import az.payday.account.UserDetails;
import az.payday.account.dto.AccountDTORes;
import az.payday.account.dto.AccountDTOReq;
import az.payday.account.model.Account;
import az.payday.account.repository.AccountRepository;
import excludeautoscan.internal_service.intrface.a003.UserIDTO;

@RestController
@RequestMapping("/")
public class AccountController {
	@Autowired
	AccountRepository accountRepository;

	@PostMapping("/create")
	public void createAccount(@Valid AccountDTOReq accountDTO) {
		UserIDTO user = UserDetails.getUserIDTO();

		Account account = new Account();
		account.setIdUser(user.getId());
		account.setAccountType(accountDTO.getAccountType());

		accountRepository.save(account);
	}

	@GetMapping("/all")
	public List<AccountDTORes> getAllAcounts(@RequestParam(required = false) Integer idAccount) {
		UserIDTO user = UserDetails.getUserIDTO();

		List<Account> accountlist = accountRepository.findByIdUser(user.getId());

		return accountlist.stream().map(account -> {
			AccountDTORes accountDTO = new AccountDTORes();
			accountDTO.setIdUser(account.getIdUser());
			accountDTO.setAccountType(account.getAccountType());
			accountDTO.setBalance(account.getBalance());
			return accountDTO;
		}).collect(Collectors.toList());
	}

	@GetMapping("/idAccount")
	public AccountDTORes getAcountById(@RequestParam(required = false) Integer idAccount) {
		UserIDTO user = UserDetails.getUserIDTO();

		Account account = accountRepository.findByIdAndIdUser(idAccount, user.getId());
		AccountDTORes accountDTO = new AccountDTORes();
		accountDTO.setAccountType(account.getAccountType());
		accountDTO.setIdUser(user.getId());

		return accountDTO;
	}

}
