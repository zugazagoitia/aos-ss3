package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.Job;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-04-13T12:14:18.539Z[GMT]")
@RestController
public class JobsApiController implements JobsApi {

    private static final Logger log = LoggerFactory.getLogger(JobsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private JobRepository repository;

//    @org.springframework.beans.factory.annotation.Autowired
//    private JobService jobService;

    @org.springframework.beans.factory.annotation.Autowired
    public JobsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addJob(@Parameter(in = ParameterIn.DEFAULT, description = "Job object that needs to be added", required = true, schema = @Schema()) @Valid @RequestBody Job body) {
        String accept = request.getHeader("Accept");
        repository.save(body);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    public ResponseEntity<Void> deleteJob(@Parameter(in = ParameterIn.PATH, description = "Job id to delete", required = true, schema = @Schema()) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (!repository.findById(id).isPresent()) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            repository.deleteById(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }

    public ResponseEntity<List<Job>> findJobsByStatus(@NotNull @Parameter(in = ParameterIn.QUERY, description = "Status values that need to be considered for filter", required = true, schema = @Schema(allowableValues = {"created", "scheduled", "started", "done"}
    )) @Valid @RequestParam(value = "status", required = true) List<String> status) {
        String accept = request.getHeader("Accept");
        HashSet<Job.StatusEnum> set = new HashSet<>();
        for (String s : status) {
            set.add(Job.StatusEnum.fromValue(s));
        }
        Iterable<Job> it = repository.findByStatusIn(new HashSet<Job.StatusEnum>(set));
        ArrayList<Job> jobs = new ArrayList<>();
        it.forEach(e -> jobs.add(e));
        return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
    }

    public ResponseEntity<List<Job>> findJobsByVehicle(@NotNull @Parameter(in = ParameterIn.QUERY, description = "Vehicle IDs to filter by", required = true, schema = @Schema()) @Valid @RequestParam(value = "ids", required = true) List<Integer> ids) {
        String accept = request.getHeader("Accept");
        Iterable<Job> it = repository.findByVehicleIn(ids.stream().mapToLong(Integer::longValue).boxed().collect(Collectors.toSet()));
        ArrayList<Job> jobs = new ArrayList<>();
        it.forEach(e -> jobs.add(e));
        return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);

    }

    public ResponseEntity<Job> getJobById(@Parameter(in = ParameterIn.PATH, description = "ID of job to return", required = true, schema = @Schema()) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        Optional<Job> j = repository.findById(id);
        if (j.isPresent()) return new ResponseEntity<Job>(j.get(), HttpStatus.OK);
        else return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);

    }

    public ResponseEntity<List<Job>> getJobs() {
        String accept = request.getHeader("Accept");
        Iterable<Job> it = repository.findAll();
        ArrayList<Job> jobs = new ArrayList<>();
        it.forEach(e -> jobs.add(e));
        return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
    }

    public ResponseEntity<Void> updateJob(@Parameter(in = ParameterIn.PATH, description = "ID of job to update", required = true, schema = @Schema()) @PathVariable("id") Long id, @Parameter(in = ParameterIn.DEFAULT, description = "Job object that needs to be added", required = true, schema = @Schema()) @Valid @RequestBody Job body) {
        String accept = request.getHeader("Accept");
        Optional<Job> opt = repository.findById(id);
        if (opt.isPresent()) {
            Job j = opt.get();
            j.setDate(body.getDate());
            j.setDescription(body.getDescription());
            j.setStatus(body.getStatus());
            j.setVehicle(body.getVehicle());
            repository.save(j);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }

}
