package io.piramal.workflow;


import com.netflix.conductor.common.metadata.workflow.StartWorkflowRequest;
import com.netflix.conductor.common.run.Workflow;
import io.orkes.conductor.client.ApiClient;
import io.orkes.conductor.client.OrkesClients;
import io.orkes.conductor.client.WorkflowClient;
import io.orkes.conductor.client.http.OrkesWorkflowClient;
import io.piramal.model.CreateLoanRequest;
import io.piramal.model.StartLoanWortkFlowRequest;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.jupiter.api.Test;


import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class WorkflowTest {

    private WorkflowClient workflowClient;
    @Before
    public void setUp(){
        ApiClient apiClient = null;


        String rootUri = "https://play.orkes.io/api/";
        String key = "5e70be55-148a-4132-b3e9-e2988cd2db65";
        String secret = "tKAUrzPlPKF8bHbR20Ev7KANpXMgaeNXly2rBUBdzFN0ai1a";
            apiClient = new ApiClient(rootUri, key, secret);

        workflowClient = new OrkesWorkflowClient(apiClient);
    }

    @Test
    public void test_invalid_customer(){

    }

    @Test
    public void test_invalid_rate(){}

    @Test
    public void test_successful_workflow(){
        ApiClient apiClient = null;


        String rootUri = "https://play.orkes.io/api/";
        String key = "5e70be55-148a-4132-b3e9-e2988cd2db65";
        String secret = "tKAUrzPlPKF8bHbR20Ev7KANpXMgaeNXly2rBUBdzFN0ai1a";
        apiClient = new ApiClient(rootUri, key, secret);

        workflowClient = new OrkesWorkflowClient(apiClient);
        Map<String ,Object> input = new HashMap<>();
        input.put("productId","1234");
        input.put("customer_id","PIR32234");
        input.put("loanAmount","100000");
        input.put("interestrate","12.50");
        input.put("loanType","PL");
        input.put("branchId","BNG1");
        input.put("loanTenure","12");
        StartWorkflowRequest loanWortkFlowRequest = new StartWorkflowRequest();
        loanWortkFlowRequest.setName("create_loan_worlflow");
        loanWortkFlowRequest.setInput(input);
        String workflowId = workflowClient.startWorkflow(loanWortkFlowRequest);
        Workflow workflow = workflowClient.getWorkflow(workflowId,true);
        assertEquals(workflowId, workflow.getWorkflowId());


    }

    @Test
    public void test_failed_scenario(){}



}


