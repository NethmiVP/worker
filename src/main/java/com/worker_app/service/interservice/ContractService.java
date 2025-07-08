package com.worker_app.service.interservice;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ContractService {
    private WebClient webClient;

    public ContractService(WebClient.Builder builder){
        this.webClient = builder.baseUrl("http://localhost:8089/contract-service").build();
    }

    public void cancelContracts0ForWorker(int id){
        webClient.patch()
                .uri("/workers/"+id+"/contracts/status")
                .retrieve()
                .toBodilessEntity()
                .subscribe();
    }
}
