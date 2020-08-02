package com.ticket.example.repository;

import com.ticket.example.domain.UserCheckIn;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCheckInRepository extends CrudRepository<UserCheckIn, Integer> {

    UserCheckIn findByUserIdOrderByCreatedAtDesc(Integer userId);
}
