package io.piramal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanInformation {
    private String customerId;
    private String leadId;
    private String branchId;
    private String loanTenure;

    private String interestRate;
    private String interestRateType;
    private String loanStartDate;
    private String installmentAmount;
    private String totalOutstandingAmount;
    private String totalOutsatndingPrincipal;
    private String modeOfRepayment;
    private String totalDisbursementAmount;
    private String loanType;

}
