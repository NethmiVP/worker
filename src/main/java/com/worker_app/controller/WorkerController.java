package com.worker_app.controller;

import com.worker_app.data.Worker;
import com.worker_app.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @GetMapping(path = "/workers")
    public List<Worker> getAllWorkers(){
        return workerService.getAllWorkers();
    }

    @GetMapping(path = "/workers/{id}")
    public Worker getWorkerById(@PathVariable int id){
        return workerService.getWorkerById(id);
    }

    @PostMapping(path = "/workers")
    public Worker createWorkers(@RequestBody Worker work){
        return workerService.createWorkers(work);
    }

    @PutMapping(path = "/workers")
    public Worker updateWorkers(@RequestBody Worker work){
        return workerService.updateWorkers(work);
    }

    @DeleteMapping(path = "/workers{id}")
    public void deleteById(@PathVariable int id){
        workerService.deleteById(id);
    }


}
