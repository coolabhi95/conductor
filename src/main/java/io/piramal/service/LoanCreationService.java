package io.piramal.service;

import io.piramal.model.LoanInformation;
import io.piramal.model.db.LoanDetails;

public interface LoanCreationService {

    LoanDetails createLoanDetails(LoanInformation loanInformation);

    LoanDetails getLoanDetails(String loanAccountNumber);
}
