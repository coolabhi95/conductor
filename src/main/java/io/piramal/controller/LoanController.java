package io.piramal.controller;

import io.piramal.model.LoanInformation;
import io.piramal.model.db.LoanDetails;
import io.piramal.service.LoanCreationService;
import io.piramal.service.WorkFlowService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("v1/api")
public class LoanController {

    private final WorkFlowService workFlowService;
    private final LoanCreationService loanCreationService;

    public LoanController(WorkFlowService workFlowService, LoanCreationService loanCreationService) {
        this.workFlowService = workFlowService;
        this.loanCreationService = loanCreationService;
    }

    @PostMapping("/lead/{leadId}/applicant/{applicantId}/business-information")
    public ResponseEntity<Void> addBusinessInformation(
            @PathVariable final String leadId,
            @PathVariable final String applicantId,
            @RequestBody LoanInformation loanInformation) {


        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/loan/{loanAccountNumber}")
    public ResponseEntity<LoanDetails> fetchLoanDetails(
            @PathVariable(value = "key")  final String loanAccountNumber ) {
        log.info("Fetching loan details {}", loanAccountNumber);
        LoanDetails loanDetails = loanCreationService.getLoanDetails(loanAccountNumber);
        return ResponseEntity.ok(loanDetails);
    }

    @GetMapping("/create")
    public ResponseEntity<String> createWorkflow() throws IOException {
        workFlowService.CreateWorkFlow();
        return ResponseEntity.ok("workflow created");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateWorkflow() throws IOException {
        workFlowService.UpdateWorkFlow();
        return ResponseEntity.ok("workflow updated");
    }

    @GetMapping
    public ResponseEntity<String> fetchLoanDetailsss() {
        return ResponseEntity.ok("demo");
    }


}
