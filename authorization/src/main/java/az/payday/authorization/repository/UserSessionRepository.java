package az.payday.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.payday.authorization.model.UserSession;

public interface UserSessionRepository extends JpaRepository<UserSession, Integer> {
	UserSession findByAuthKey(String authKey);
}
