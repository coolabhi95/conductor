package io.piramal.lmsWorkers;

import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import io.piramal.model.LoanInformation;
import io.piramal.model.db.LoanDetails;
import io.piramal.service.LoanCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Map;

@Component
public class CreateLoanWorker implements Worker {

    @Autowired
    private LoanCreationService loanCreationService;

    @Override
    public String getTaskDefName() {
        return "loan_creation";
    }

    @Override
    public TaskResult execute(Task task) {
        TaskResult result = new TaskResult(task);
        result.setStatus(TaskResult.Status.COMPLETED);
        String currentTimeOnServer = Instant.now().toString();
        Map<String, Object> map = task.getInputData();
        LoanDetails loanDetails = loanCreationService.createLoanDetails(LoanInformation.builder()
                .customerId((String) map.get("customer_id"))
                .branchId((String) map.get("branchId"))
                .loanTenure((String) map.get("customer_id"))
                .loanType((String) map.get("loanType"))
                .interestRate((String) map.get("interestrate"))
                .loanTenure((String) map.get("loanTenure"))
                .build());
        result.addOutputData("loanAccountNumber",loanDetails.getLoanAccountNumber());
        result.addOutputData("message","loan created successfully");
        return result;
    }
}
