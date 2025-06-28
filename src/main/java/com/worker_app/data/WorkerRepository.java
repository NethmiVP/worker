package com.worker_app.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {

    @Query("select w from Worker w where w.fname=?1 and w.location=?2")
    //defining a method
    public List<Worker> searchWorkers(String fname, String location);

}
