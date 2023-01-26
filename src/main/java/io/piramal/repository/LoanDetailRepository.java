package io.piramal.repository;

import io.piramal.model.db.LoanDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanDetailRepository extends CrudRepository<LoanDetails,Long> {

    List<LoanDetails> findByLoanAccountNumber(String loanAccountNumber);
}
