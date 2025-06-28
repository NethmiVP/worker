package com.worker_app.controller;

import com.worker_app.data.Worker;
import com.worker_app.data.WorkerSkill;
import com.worker_app.service.WorkerService;
import com.worker_app.service.WorkerSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @DeleteMapping(path = "/skills{id}")
    public void deleteSkillById(@PathVariable int id){
        workerSkillService.deleteSkillById(id);
    }
}
