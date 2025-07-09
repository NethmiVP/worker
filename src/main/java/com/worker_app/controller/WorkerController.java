package com.worker_app.controller;

import com.worker_app.data.Worker;
import com.worker_app.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
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

    @PostMapping(path = "/workers/create")
    public ResponseEntity<Worker> createWorkers(@RequestBody Worker work) {
        Worker signupResult = workerService.createWorkers(work);
        return ResponseEntity.ok(signupResult);
    }

    @PutMapping(path = "/workers/update")
    public ResponseEntity<Worker> updateWorkers(@RequestBody Worker work) {
        Worker updateResult = workerService.updateWorkers(work);
        return ResponseEntity.ok(updateResult);
    }

    @DeleteMapping(path = "/workers/{id}")
    public void deleteById(@PathVariable int id){
        workerService.deleteById(id);
    }

    @GetMapping(path = "workers", params = {"fname", "location"})
    public List<Worker> searchWorker(@RequestParam String fname, @RequestParam String location){
        //return null;
        return workerService.searchWorkers(fname, location);
    }

    @GetMapping(path = "workers", params = {"fname"})
    public List<Worker> searchWorkerNames(@RequestParam String fname){
        //return null;
        return workerService.searchWorkerNames(fname);
    }

    @GetMapping(path = "workers", params = {"location"})
    public List<Worker> searchWorkerLocations(@RequestParam String location){
        //return null;
        return workerService.searchWorkerLocations(location);
    }

    @PostMapping("/workers/login")
    public ResponseEntity<Worker> login(@RequestBody Worker work) {
        Worker loggedInWorker = workerService.login(work);
        return ResponseEntity.ok(loggedInWorker);
    }

    @RequestMapping(method = RequestMethod.HEAD, path = "/workers/{id}")
    public ResponseEntity<Void> workerExistsById(@PathVariable int id){
        Boolean exists = workerService.workerExistsById(id);

        if (exists){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
