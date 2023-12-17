package com.inflearn.restAPI.accounts;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Please explain the class
 *
 * @author : wookjin
 * @fileName : AccountRepository
 * @since : 12/16/23
 */
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Optional<Account> findByEmail(String username);
}
