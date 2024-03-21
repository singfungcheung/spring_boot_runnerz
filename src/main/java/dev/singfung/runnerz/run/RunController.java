package dev.singfung.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController // Response to requests (returns responses).
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("")
    List<Run> findAll() {
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findById(id);
        if (run.isEmpty()) {
            throw new RunNotFoundException();
        }
        else {
            return run.get();
        }
    }

    // Post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@RequestBody Run run) {
        runRepository.create(run);
    }

    // Put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@RequestBody Run run, @PathVariable Integer id) {
        runRepository.update(run, id);
    }

    // Delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        runRepository.delete(id);
    }
//    private List<Run> runs = new ArrayList<>();
//    @RequestMapping("/hello")
//    String home() {
//        return "Hello, Runnerz!";
//    }
}
