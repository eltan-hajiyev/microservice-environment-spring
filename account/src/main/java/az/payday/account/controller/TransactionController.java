package az.payday.account.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.payday.account.UserDetails;
import az.payday.account.dto.AccountDTORes;
import az.payday.account.dto.TransactionDTO;
import az.payday.account.model.Account;
import az.payday.account.model.Transaction;
import az.payday.account.repository.AccountRepository;
import az.payday.account.repository.TransactionRepository;
import excludeautoscan.internal_service.intrface.a003.UserIDTO;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@GetMapping("/all")
	public List<TransactionDTO> getAllTransactionList() {
		UserIDTO user = UserDetails.getUserIDTO();

		List<Account> accountList = accountRepository.findByIdUser(user.getId());

		List<Transaction> transactionlist = transactionRepository.findByAccountIn(accountList);

		return transactionlist.stream().map(transaction -> {
			TransactionDTO transactionDTO = new TransactionDTO();
			transactionDTO.setIdAccount(transaction.getAccount().getId());
			transactionDTO.setToken(transaction.getToken());
			return transactionDTO;
		}).collect(Collectors.toList());
	}

}
