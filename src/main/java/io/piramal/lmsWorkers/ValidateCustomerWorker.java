package io.piramal.lmsWorkers;

import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Map;

@Component
public class ValidateCustomerWorker implements Worker {

    @Override
    public String getTaskDefName() {
        return "validate_customer";
    }

    @Override
    public TaskResult execute(Task task) {
        TaskResult result = new TaskResult(task);
        result.setStatus(TaskResult.Status.COMPLETED);
        String currentTimeOnServer = Instant.now().toString();
        Map<String, Object> map = task.getInputData();
        if(map.containsKey("customer_id") && map.get("customer_id").toString().startsWith("PIR"))
          result.addOutputData("isValidCustomer", "isValidCustomer");

        else
            result.addOutputData("isValidCustomer", "isInValidCustomer");

        return result;
    }
}
