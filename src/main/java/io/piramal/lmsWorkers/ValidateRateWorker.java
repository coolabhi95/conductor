package io.piramal.lmsWorkers;

import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Map;

@Component
public class ValidateRateWorker implements Worker {
    @Override
    public String getTaskDefName() {
        return "validate_interest_rate";
    }

    @Override
    public TaskResult execute(Task task) {
        TaskResult result = new TaskResult(task);
        result.setStatus(TaskResult.Status.COMPLETED);
        String currentTimeOnServer = Instant.now().toString();
        Map<String, Object> map = task.getInputData();
        if((map.containsKey("interest_rate") && map.get("interest_rate").toString().startsWith("12")))
            result.addOutputData("is_interest_rate_valid", "isValidRate") ;

        else
            result.addOutputData("is_interest_rate_valid", "isInValidRate");

        return result;
    }
}
