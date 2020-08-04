package com.ticket.example.repository;

import com.ticket.example.domain.UserCheckIn;
import java.time.LocalDateTime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCheckInRepository extends CrudRepository<UserCheckIn, Integer> {

    UserCheckIn findFirstByUserIdOrderByCreatedAtDesc(Integer userId);

    Iterable<UserCheckIn> findByCreatedAtIsBetweenOrderByCreatedAtDesc(
            LocalDateTime start, LocalDateTime end);
}
