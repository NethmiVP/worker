package com.worker_app.service.interservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ContractService {
    private WebClient webClient;

    public ContractService(WebClient.Builder builder, @Value("${service.contract.url}") String url){
        this.webClient = builder.baseUrl(url).build();
    }

    public void cancelContracts0ForWorker(int id){
        webClient.patch()
                .uri("/workers/"+id+"/contracts/status")
                .retrieve()
                .toBodilessEntity()
                .subscribe();
    }
}
