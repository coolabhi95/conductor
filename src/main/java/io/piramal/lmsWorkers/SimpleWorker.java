package io.piramal.lmsWorkers;

import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class SimpleWorker implements Worker {

    @Override
    public String getTaskDefName() {
        return "create_PL";
    }

    @Override
    public TaskResult execute(Task task) {
        TaskResult result = new TaskResult(task);
        result.setStatus(TaskResult.Status.COMPLETED);
        String currentTimeOnServer = Instant.now().toString();
        result.addOutputData("loanNumber", "483483471432");
        return result;
    }

}
