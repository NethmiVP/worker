package com.worker_app.service;

import com.worker_app.data.Worker;
import com.worker_app.data.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workRepo;

    public List<Worker> getAllWorkers(){
        return workRepo.findAll();
    }

    public Worker getWorkerById(int id){
        Optional<Worker> work = workRepo.findById(id);
        if(work.isPresent()){
            return work.get();
        }
        return null;
    }

    public Worker createWorkers(Worker work){
        return workRepo.save(work);
    }

    public Worker updateWorkers(Worker work){
        return workRepo.save(work);
    }

    public void deleteById(int id){
        workRepo.deleteById(id);
    }

    public List<Worker> searchWorkers(String fname, String location){
        return workRepo.searchWorkers(fname, location);
    }

}
