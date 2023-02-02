package io.piramal.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.conductor.common.metadata.workflow.StartWorkflowRequest;
import io.orkes.conductor.client.WorkflowClient;
import io.piramal.client.OrkesClient;
import io.piramal.model.LoanInformation;
import io.piramal.model.StartLoanWortkFlowRequest;
import io.piramal.service.WorkFlowService;
import io.piramal.service.util.ServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
@Slf4j
public class WorkFlowServiceImpl implements WorkFlowService {


    @Autowired OrkesClient client;

    @Autowired
    WorkflowClient workflowClient;

    @Override
    public void StartLoanWorkFlow(LoanInformation loanInformation) {
        StartLoanWortkFlowRequest request = new StartLoanWortkFlowRequest().builder().build();
        client.startWorkFlow(ServiceUtil.getHeader(),request);
    }

    @Override
    public void CreateWorkFlow() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File from = new File("/Users/70069796/IdeaProjects/orkesworkers/src/main/resources/workflowDemo.json");
        JsonNode masterJSON = mapper.readTree(from);
        client.upload(ServiceUtil.getHeader(),masterJSON);
        log.info("file uploaded");
    }

    @Override
    public void UpdateWorkFlow() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File from = new File("/Users/70069796/IdeaProjects/orkesworkers/src/main/resources/workflowDemo.json");
        JsonNode masterJSON = mapper.readTree(from);
        client.updateWorkflow(ServiceUtil.getHeader(),masterJSON);
        log.info("file uploaded");
    }

    @Override
    public void StartWorkFloe(String name, Map<String, Object> input) {
        StartWorkflowRequest request = new StartWorkflowRequest();
        request.setName(name);
        request.setInput(input);
        workflowClient.startWorkflow(request);
    }




}
