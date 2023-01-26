package io.piramal.service;

import io.piramal.model.LoanInformation;

import java.io.IOException;

public interface WorkFlowService {

    void StartLoanWorkFlow(LoanInformation loanInformation);

    void CreateWorkFlow() throws IOException;

    void UpdateWorkFlow () throws IOException;
}
