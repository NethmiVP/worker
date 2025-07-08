package com.worker_app.service;

import com.worker_app.data.Worker;
import com.worker_app.data.WorkerRepository;
import com.worker_app.service.interservice.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workRepo;
    @Autowired
    private ContractService contractService;

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

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Worker createWorkers(Worker work){

        if (workRepo.findByUsername(work.getUsername()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists!");
        }

        String encodedPassword = passwordEncoder.encode(work.getPassword());
        work.setPassword(encodedPassword);
        return workRepo.save(work);
    }

    public Worker updateWorkers(Worker work){
        Optional<Worker> optionalCustomer = workRepo.findById(work.getId());

        if (workRepo.findByUsername(work.getUsername()) != null && !work.getUsername().equals(optionalCustomer.get().getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists!");
        }

        if (work.getPassword() != null && !work.getPassword().isEmpty()) {
            work.setPassword(passwordEncoder.encode(work.getPassword()));
        }else {
            work.setPassword(optionalCustomer.get().getPassword());
        }

        return workRepo.save(work);
    }

    public void deleteById(int id){
        workRepo.deleteById(id);
        contractService.cancelContracts0ForWorker(id);
    }

    public List<Worker> searchWorkers(String fname, String location){
        return workRepo.searchWorker(fname, location);
    }

    public List<Worker> searchWorkerNames(String fname){
        return workRepo.searchWorkerName(fname);
    }

    public List<Worker> searchWorkerLocations(String location){
        return workRepo.searchWorkerLocation(location);
    }

    public Worker login(Worker work) {
        Worker existingWorker = workRepo.findByUsername(work.getUsername());
        if (existingWorker != null && passwordEncoder.matches(work.getPassword(), existingWorker.getPassword())) {
            existingWorker.setPassword(null); // Hide the password
            return existingWorker;
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password is wrong!");
        }
}

}
