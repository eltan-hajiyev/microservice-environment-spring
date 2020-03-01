package az.payday.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.payday.account.model.Account;
import java.lang.Integer;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	List<Account> findByIdUser(Integer iduser);

	Account findByIdAndIdUser(Integer idAccount, Integer iduser);

}
