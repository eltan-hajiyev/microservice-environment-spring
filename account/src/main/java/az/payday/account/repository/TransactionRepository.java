package az.payday.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.payday.account.model.Account;
import az.payday.account.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	List<Transaction> findByAccountIn(List<Account> accountList);
}
