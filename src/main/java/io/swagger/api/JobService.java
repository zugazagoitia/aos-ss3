package io.swagger.api;

import io.swagger.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository repository;

    public List<Job> findAll() {
        Iterable<Job> it = repository.findAll();
        ArrayList<Job> jobs = new ArrayList<>();
        it.forEach(e -> jobs.add(e));
        return jobs;
    }

    public void addJob(Job job){
        repository.save(job);
    }

}
