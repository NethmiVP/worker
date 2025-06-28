package com.worker_app.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerSkillRepository extends JpaRepository<WorkerSkill, Integer> {
    void deleteSkillById(int id);
}
