package com.worker_app.data;

import jakarta.persistence.*;

@Entity
@Table(name = "Worker_Skill")
public class WorkerSkill {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "worker_id")
    private int worker_id;

    @Column(name = "service_id")
    private int service_id;

    @Column(name = "work_experience")
    private int work_experience;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(int worker_id) {
        this.worker_id = worker_id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public int getWork_experience() {
        return work_experience;
    }

    public void setWork_experience(int work_experience) {
        this.work_experience = work_experience;
    }
}
