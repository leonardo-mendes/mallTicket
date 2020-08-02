package com.ticket.example.repository;

import com.ticket.example.domain.UserBalance;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBalanceRepository extends CrudRepository<UserBalance, Integer> {

    Optional<UserBalance> findByUserId(Integer userId);
}
