package com.worker_app.data;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerSkillRepository extends JpaRepository<WorkerSkill, Integer> {
    void deleteSkillById(int id);

    @Query("select s from WorkerSkill s where s.service_id=?1")
    //defining a method
    public List<WorkerSkill> searchWorkerSkill(int service_id);

    @Modifying
    @Query("delete from WorkerSkill s where s.service_id = ?1")
    @Transactional
    public void deleteAllByServiceId(int id);
}
