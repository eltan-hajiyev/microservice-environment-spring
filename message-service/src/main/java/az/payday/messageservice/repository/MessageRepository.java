package az.payday.messageservice.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.payday.messageservice.model.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {
	List<Message> findByStatusAndInsertDateGreaterThan(Short status, Instant insertDate);
}
