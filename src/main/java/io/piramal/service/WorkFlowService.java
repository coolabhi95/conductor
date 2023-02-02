package io.piramal.service;

import io.piramal.model.LoanInformation;

import java.io.IOException;
import java.util.Map;

public interface WorkFlowService {

    void StartLoanWorkFlow(LoanInformation loanInformation);

    void CreateWorkFlow() throws IOException;

    void UpdateWorkFlow () throws IOException;

    void StartWorkFloe(String name, Map<String,Object> input) ;


}
