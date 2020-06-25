package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IssueManagerEmptyTest {
    private IssueRepository repository = new IssueRepository();
    private IssueManager manager = new IssueManager(repository);

    @Test
    void shouldReturnEmptyWhenFindByAuthor() {
        List<Issue> expected = new ArrayList<>();
        List<Issue> actual = manager.findByAuthor("Tolstoy");
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyWhenFindByLabel() {
        List<Issue> expected = new ArrayList<>();
        List<Issue> actual = manager.findByLabel(new HashSet<String>(Arrays.asList("Детство")));
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyWhenFindByAssigned() {
        List<Issue> expected = new ArrayList<>();
        List<Issue> actual = manager.findByAssigned(new HashSet<String>(Arrays.asList("Pushkin")));
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyIfNothingToSortByNew() {
        List<Issue> expected = new ArrayList<>();
        List<Issue> actual = manager.sortByNew();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyIfNothingToSortByEarly() {
        List<Issue> expected = new ArrayList<>();
        List<Issue> actual = manager.sortByEarly();
        assertEquals(expected, actual);
    }
}
