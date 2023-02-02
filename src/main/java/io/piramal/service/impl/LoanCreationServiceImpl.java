package io.piramal.service.impl;

import io.piramal.model.LoanInformation;
import io.piramal.model.db.LoanDetails;
import io.piramal.repository.LoanDetailRepository;
import io.piramal.service.LoanCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class LoanCreationServiceImpl implements LoanCreationService {

     LoanDetailRepository loanDetailRepository;
    public LoanCreationServiceImpl(LoanDetailRepository loanDetailRepository) {
        this.loanDetailRepository = loanDetailRepository;
    }
    @Override
    public LoanDetails createLoanDetails(LoanInformation loanInformation) {
        LoanDetails loanDetails = new LoanDetails();
        loanDetails.setLoanAccountNumber(loanInformation.getCustomerId()+loanInformation.getBranchId()+new Random().nextInt(10000));
        loanDetails.setBranchId(loanInformation.getBranchId());
        loanDetails.setLoanTenure(loanDetails.getLoanTenure());
        loanDetails.setCustomerId(loanInformation.getCustomerId());
        loanDetails.setLoanType(loanInformation.getLoanType());
        loanDetails.setInterestRate(loanInformation.getInterestRate());
        loanDetailRepository.save(loanDetails);
        return loanDetails;
    }

    @Override
    public LoanDetails getLoanDetails(String loanAccountNumber) {
        return loanDetailRepository.findByLoanAccountNumber(loanAccountNumber).get(0);
    }
}
