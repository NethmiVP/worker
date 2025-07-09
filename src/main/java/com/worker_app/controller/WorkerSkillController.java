package com.worker_app.controller;

import com.worker_app.data.Worker;
import com.worker_app.data.WorkerSkill;
import com.worker_app.service.WorkerService;
import com.worker_app.service.WorkerSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class WorkerSkillController {

    @Autowired
    private WorkerSkillService workerSkillService;

    @GetMapping(path = "/skills")
    public List<WorkerSkill> getAllWorkerSkills(){
        return workerSkillService.getAllWorkerSkills();
    }

    @GetMapping(path = "/skills/{id}")
    public WorkerSkill getWorkerSkillById(@PathVariable int id){
        return workerSkillService.getWorkerSkillById(id);
    }

    @PostMapping(path = "/skills")
    public WorkerSkill createWorkerSkills(@RequestBody WorkerSkill skill){
        return workerSkillService.createWorkerSkills(skill);
    }

    @PutMapping(path = "/skills")
    public WorkerSkill updateWorkerSkills(@RequestBody WorkerSkill skill){
        return workerSkillService.updateWorkerSkills(skill);
    }

    @DeleteMapping(path = "/skills/{id}")
    public void deleteSkillById(@PathVariable int id){
        workerSkillService.deleteSkillById(id);
    }

    @GetMapping(path = "skills", params = {"service_id"})
    public List<WorkerSkill> searchWorkerSkills(@RequestParam int service_id){
        //return null;
        return workerSkillService.searchWorkerSkills(service_id);
    }

    @DeleteMapping(path = "/skills/services/{id}")
    public ResponseEntity<Void> deleteWorkerSkillsByServiceId(@PathVariable int id){
        workerSkillService.deleteWorkerSkillsByServiceId(id);
        return ResponseEntity.ok().build();
    }
}
