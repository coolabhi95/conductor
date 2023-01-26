package io.piramal.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.piramal.client.OrkesClient;
import io.piramal.model.LoanInformation;
import io.piramal.model.StartWortkFlowRequest;
import io.piramal.service.WorkFlowService;
import io.piramal.service.util.ServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
@Slf4j
public class WorkFlowServiceImpl implements WorkFlowService {


    @Autowired OrkesClient client;

    @Override
    public void StartLoanWorkFlow(LoanInformation loanInformation) {
        StartWortkFlowRequest request = new StartWortkFlowRequest().builder().build();
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


}
