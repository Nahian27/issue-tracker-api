package com.nahian.issuetrackerapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/issues")
public class IssueController {

    private final IssueRepository issueRepository;

    public IssueController(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    @GetMapping
    public ResponseEntity<List<Issue>> List() {

        return ResponseEntity.ok(issueRepository.findAll());
    }

    @GetMapping("/{slug}")
    public ResponseEntity<Issue> Single(@PathVariable UUID slug) {

        var issue = issueRepository.findById(slug).orElse(null);

        if (issue != null) {
            return ResponseEntity.ok(issue);
        } else return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Issue> Create(@RequestBody Issue issue) {

        return ResponseEntity.ok(issueRepository.save(issue));
    }

    @PutMapping("/{slug}")
    public ResponseEntity<Issue> Edit(@PathVariable UUID slug, @RequestBody Issue newIssue) {

        var issue = issueRepository.findById(slug).orElse(null);

        if (issue != null) {
            issue.setTitle(newIssue.getTitle() != null ? newIssue.getTitle() : issue.getTitle());
            issue.setDescription(newIssue.getDescription() != null ? newIssue.getDescription() : issue.getDescription());

            return ResponseEntity.ok(issueRepository.save(issue));

        } else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{slug}")
    public ResponseEntity<Issue> Delete(@PathVariable UUID slug) {

        var issue = issueRepository.findById(slug).orElse(null);

        if (issue != null) {

            issueRepository.deleteById(slug);
            return ResponseEntity.ok().build();

        } else return ResponseEntity.notFound().build();
    }
}