package io.piramal.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateLoanRequest {

    private String productId;
    private String branchId;

    private String customerId;

    private String loanTenure;
    private String loanType;
    private Double interestRate;

    private Integer loanAmount;

}
