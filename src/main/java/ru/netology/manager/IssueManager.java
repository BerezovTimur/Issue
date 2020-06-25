package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class IssueManager {
    private IssueRepository repository;

    public IssueManager(IssueRepository repository) {
        this.repository = repository;
    }

    public void issueAdd(Issue item) {
        repository.save(item);
    }

    public List<Issue> getAll() {
        return repository.findAll();
    }

    public boolean addAll(List<Issue> items) {
        return repository.addAll(items);
    }

    public List<Issue> sortByNew() {
        Comparator byNew = Comparator.naturalOrder();
        List<Issue> issues = new ArrayList<>();
        issues.addAll(repository.findAll());
        issues.sort(byNew);
        return issues;
    }

    public List<Issue> sortByEarly() {
        Comparator ByEarly = Comparator.reverseOrder();
        List<Issue> issues = new ArrayList<>();
        issues.addAll(repository.findAll());
        issues.sort(ByEarly);
        return issues;
    }

    public List<Issue> findByAuthor(String author) {
        Predicate<String> byAuthor = Predicate.isEqual(author);
        List<Issue> issues = new ArrayList<>();
        for (Issue item : repository.findAll())
            if (byAuthor.test(item.getAuthor())) {
                issues.add(item);
            }
        return issues;
    }

    public List<Issue> findByLabel(Set<String> label) {
        Predicate<Set<String>> byLabel = t -> t.containsAll(label);
        List<Issue> issues = new ArrayList<>();
        for (Issue item : repository.findAll())
            if (byLabel.test(item.getLabels())) {
                issues.add(item);
            }
        return issues;
    }

    public List<Issue> findByAssigned(Set<String> assigned) {
        Predicate<Set<String>> byLabel = t -> t.containsAll(assigned);
        List<Issue> issues = new ArrayList<>();
        for (Issue item : repository.findAll())
            if (byLabel.test(item.getAssigned())) {
                issues.add(item);
            }
        return issues;
    }
}
