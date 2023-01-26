package io.piramal.lmsWorkers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import io.piramal.model.LoanInformation;
import io.piramal.service.LoanCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service

public class LoanWorker implements Worker {

    @Autowired
    private LoanCreationService loanCreationService;

    @Override
    public String getTaskDefName() {
        return "fetch_customer_details";
    }

    @Override
    public TaskResult execute(Task task) {
        TaskResult result = new TaskResult(task);
        result.addOutputData("loanType",task.getInputData().get("loanType"));
        Map<String,Object> map = task.getInputData();
        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final LoanInformation loanInformation = mapper.convertValue(map, LoanInformation.class);

        result.setStatus(TaskResult.Status.COMPLETED);
        return result;
    }
}
