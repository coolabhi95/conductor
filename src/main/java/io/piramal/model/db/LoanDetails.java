package io.piramal.model.db;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loan_details")
public class LoanDetails {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private BigInteger id;

    private String loanAccountNumber;

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
