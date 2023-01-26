package io.piramal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
@Builder
@Data
@NoArgsConstructor
public class StartWortkFlowRequest {
    // import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
    public class AdditionalProp1{
    }

    public class AdditionalProp2{
    }

    public class AdditionalProp3{
    }

    public class DecisionCases{
        public ArrayList<String> additionalProp1;
        public ArrayList<String> additionalProp2;
        public ArrayList<String> additionalProp3;
    }

    public class Input{
        public AdditionalProp1 additionalProp1;
        public AdditionalProp2 additionalProp2;
        public AdditionalProp3 additionalProp3;
    }

    public class InputParameters{
        public AdditionalProp1 additionalProp1;
        public AdditionalProp2 additionalProp2;
        public AdditionalProp3 additionalProp3;
    }

    public class InputTemplate{
        public AdditionalProp1 additionalProp1;
        public AdditionalProp2 additionalProp2;
        public AdditionalProp3 additionalProp3;
    }

    public class OutputParameters{
        public AdditionalProp1 additionalProp1;
        public AdditionalProp2 additionalProp2;
        public AdditionalProp3 additionalProp3;
    }

    public class Root{
        public String correlationId;
        public String createdBy;
        public String externalInputPayloadStoragePath;
        public Input input;
        public String name;
        public int priority;
        public TaskToDomain taskToDomain;
        public int version;
        public WorkflowDef workflowDef;
    }

    public class SubWorkflowParam{
        public String name;
        public TaskToDomain taskToDomain;
        public int version;
        public String workflowDefinition;
    }

    public class Task{
        public boolean asyncComplete;
        public DecisionCases decisionCases;
        public ArrayList<String> defaultCase;
        public ArrayList<String> defaultExclusiveJoinTask;
        public String description;
        public String dynamicForkTasksInputParamName;
        public String dynamicForkTasksParam;
        public String dynamicTaskNameParam;
        public String evaluatorType;
        public String expression;
        public ArrayList<ArrayList<String>> forkTasks;
        public InputParameters inputParameters;
        public ArrayList<String> joinOn;
        public String loopCondition;
        public ArrayList<String> loopOver;
        public String name;
        public boolean optional;
        public boolean rateLimited;
        public int retryCount;
        public String scriptExpression;
        public String sink;
        public int startDelay;
        public SubWorkflowParam subWorkflowParam;
        public TaskDefinition taskDefinition;
        public String taskReferenceName;
        public String type;
        public String workflowTaskType;
    }

    public class TaskDefinition{
        public int backoffScaleFactor;
        public int concurrentExecLimit;
        public int createTime;
        public String createdBy;
        public String description;
        public String executionNameSpace;
        public ArrayList<String> inputKeys;
        public InputTemplate inputTemplate;
        public String isolationGroupId;
        public String name;
        public ArrayList<String> outputKeys;
        public String ownerApp;
        public String ownerEmail;
        public int pollTimeoutSeconds;
        public int rateLimitFrequencyInSeconds;
        public int rateLimitPerFrequency;
        public int responseTimeoutSeconds;
        public int retryCount;
        public int retryDelaySeconds;
        public String retryLogic;
        public String timeoutPolicy;
        public int timeoutSeconds;
        public int updateTime;
        public String updatedBy;
    }

    public class TaskToDomain{
        public String additionalProp1;
        public String additionalProp2;
        public String additionalProp3;
    }

    public class Variables{
        public AdditionalProp1 additionalProp1;
        public AdditionalProp2 additionalProp2;
        public AdditionalProp3 additionalProp3;
    }

    public class WorkflowDef{
        public int createTime;
        public String createdBy;
        public String description;
        public String failureWorkflow;
        public ArrayList<String> inputParameters;
        public InputTemplate inputTemplate;
        public String name;
        public OutputParameters outputParameters;
        public String ownerApp;
        public String ownerEmail;
        public boolean restartable;
        public int schemaVersion;
        public ArrayList<Task> tasks;
        public String timeoutPolicy;
        public int timeoutSeconds;
        public int updateTime;
        public String updatedBy;
        public Variables variables;
        public int version;
        public boolean workflowStatusListenerEnabled;
    }


}
