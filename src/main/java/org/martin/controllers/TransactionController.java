package org.martin.controllers;
import org.martin.dtos.requests.AirtimeRequest;
import org.martin.dtos.requests.TransferRequest;
import org.martin.dtos.responses.TransactionResponse;
import org.martin.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

@Autowired
    private TransactionService transactionService;

@PostMapping("/airtime")
    public ResponseEntity<TransactionResponse> buyAirtime(@RequestBody AirtimeRequest request){
        TransactionResponse response = transactionService.processAirtime(request);
        return ResponseEntity.ok(response);
    }
@PostMapping("/transfer")
    public ResponseEntity<TransactionResponse> doTransfer(@RequestBody TransferRequest request){
    TransactionResponse response = transactionService.transfer(request);
        return ResponseEntity.ok(response);
    }

}
