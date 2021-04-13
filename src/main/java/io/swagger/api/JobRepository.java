package io.swagger.api;

import io.swagger.model.Job;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface JobRepository extends CrudRepository<Job, Long> {

    List<Job> findByVehicleIn(Set<Long> vehicle);

    List<Job> findByStatusIn(Set<Job.StatusEnum> status);

}