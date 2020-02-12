/**
 * 
 */
package com.leovegas.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leovegas.model.TransactionRequest;

/**
 * @author ayush.a.mittal
 *
 */
@Repository
public interface TransactionRepository 
              extends JpaRepository<TransactionRequest, Long> {

}
