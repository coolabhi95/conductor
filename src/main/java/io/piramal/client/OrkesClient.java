package io.piramal.client;

import com.fasterxml.jackson.databind.JsonNode;
import io.piramal.config.AppConfig;
import io.piramal.model.StartLoanWortkFlowRequest;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(
        name = "workFlowService",
        url = "${orkes.service.base.url}",
        configuration = AppConfig.class)
public interface OrkesClient {


    @PostMapping("/workflow")
    void startWorkFlow(@RequestHeader Map<String, Object> header,@RequestBody StartLoanWortkFlowRequest workFLowRequest);

    @PostMapping
    void CreateWorkFLow(@RequestHeader Map<String, Object> header,@RequestBody StartLoanWortkFlowRequest workFLowRequest);



        @PostMapping("/metadata/workflow")
        void upload(@RequestHeader Map<String, Object> header,@RequestBody JsonNode node);

    @PutMapping("/metadata/workflow")
    void updateWorkflow(@RequestHeader Map<String, Object> header,@RequestBody JsonNode node);
    }

