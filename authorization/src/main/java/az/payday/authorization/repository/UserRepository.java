package az.payday.authorization.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.payday.authorization.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findByStatus(Short status);

	User findByEmail(String email);
}
