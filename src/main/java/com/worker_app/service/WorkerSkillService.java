package com.worker_app.service;

import com.worker_app.data.Worker;
import com.worker_app.data.WorkerRepository;
import com.worker_app.data.WorkerSkill;
import com.worker_app.data.WorkerSkillRepository;
import com.worker_app.service.interservice.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerSkillService {

    @Autowired
    private WorkerSkillRepository skillRepo;
    @Autowired
    private WorkerService workerService;
    @Autowired
    private ServiceService servService;

    public List<WorkerSkill> getAllWorkerSkills(){
        return skillRepo.findAll();
    }

    public WorkerSkill getWorkerSkillById(int id){
        Optional<WorkerSkill> skill = skillRepo.findById(id);
        if(skill.isPresent()){
            return skill.get();
        }
        return null;
    }

    public WorkerSkill createWorkerSkills(WorkerSkill skill){
        if (!workerService.workerExistsById(skill.getWork_id())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Worker was not found");
        }
        if (!servService.ServiceExists(skill.getService_id())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Service category was not found");
        }
        return skillRepo.save(skill);
    }

    public WorkerSkill updateWorkerSkills(WorkerSkill skill){
        if (!workerService.workerExistsById(skill.getWork_id())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Worker was not found");
        }
        if (!servService.ServiceExists(skill.getService_id())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Service category was not found");
        }
        return skillRepo.save(skill);
    }

    public void deleteSkillById(int id){
        skillRepo.deleteById(id);
    }

    public List<WorkerSkill> searchWorkerSkills(int service_id){
        return skillRepo.searchWorkerSkill(service_id);
    }

    //method to delete worker skills for deleted services
    public void deleteWorkerSkillsByServiceId(int id){
        skillRepo.deleteAllByServiceId(id);
    }
}
