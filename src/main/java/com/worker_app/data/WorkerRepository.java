package com.worker_app.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {

    @Query("select w from Worker w where w.fname=?1 and w.location=?2")
    public List<Worker> searchWorker(String fname, String location);

    @Query("select wn from Worker wn where wn.fname=?1")
    public List<Worker> searchWorkerName(String fname);

    @Query("select wl from Worker wl where wl.location=?1")
    public List<Worker> searchWorkerLocation(String location);

    Worker findByUsername(String username);
}
