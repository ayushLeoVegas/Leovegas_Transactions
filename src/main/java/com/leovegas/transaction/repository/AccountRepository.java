/**
 * 
 */
package com.leovegas.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.leovegas.model.AccountDetails;

/**
 * @author ayush.a.mittal
 *
 */
@Repository
public interface AccountRepository 
              extends JpaRepository<AccountDetails, Long> {
	@Query(nativeQuery = true,value= "SELECT * FROM ACCOUNT_DETAILS u WHERE u.account_number = :acc_number and u.player_id = :playerId")
	AccountDetails getOne(@Param("acc_number") String accountNumber,@Param("playerId") String playerId);

}
