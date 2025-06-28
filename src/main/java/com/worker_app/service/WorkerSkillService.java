package com.worker_app.service;

import com.worker_app.data.Worker;
import com.worker_app.data.WorkerRepository;
import com.worker_app.data.WorkerSkill;
import com.worker_app.data.WorkerSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerSkillService {

    @Autowired
    private WorkerSkillRepository skillRepo;

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
        return skillRepo.save(skill);
    }

    public WorkerSkill updateWorkerSkills(WorkerSkill skill){
        return skillRepo.save(skill);
    }

    public void deleteSkillById(int id){
        skillRepo.deleteSkillById(id);
    }
}
