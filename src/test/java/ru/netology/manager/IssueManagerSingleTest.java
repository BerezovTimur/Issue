package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IssueManagerSingleTest {
    private IssueRepository repository = new IssueRepository();
    private IssueManager manager = new IssueManager(repository);

    private Issue issue1 = new Issue(1, true, "Tolstoy", 2, new HashSet<String>(Arrays.asList("Детство", "Отрочество", "Юность")), new HashSet<String>(Arrays.asList("Pushkin", "Lermontov", "Block")));
    
    @BeforeEach
    void setUp(){
        manager.issueAdd(issue1);
    }

    @Test
    void shouldFindByAuthor() {
        List<Issue> expected = new ArrayList<>(List.of(issue1));
        List<Issue> actual = manager.findByAuthor("Tolstoy");
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyIfNotFindAuthor() {
        List<Issue> expected = new ArrayList<>();
        List<Issue> actual = manager.findByAuthor("Chekhov");
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByLabel() {
        List<Issue> expected = new ArrayList<>(List.of(issue1));
        List<Issue> actual = manager.findByLabel(new HashSet<String>(Arrays.asList("Отрочество")));
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyIfNotFindLabel() {
        List<Issue> expected = new ArrayList<>();
        List<Issue> actual = manager.findByLabel(new HashSet<String>(Arrays.asList("Отцы")));
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByAssigned() {
        List<Issue> expected = new ArrayList<>(List.of(issue1));
        List<Issue> actual = manager.findByAssigned(new HashSet<String>(Arrays.asList("Block")));
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyIfNotFindByAssigned() {
        List<Issue> expected = new ArrayList<>();
        List<Issue> actual = manager.findByAssigned(new HashSet<String>(Arrays.asList("Esenin")));
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnOneToSortByNew() {
        List<Issue> expected = new ArrayList<>(List.of(issue1));
        List<Issue> actual = manager.sortByNew();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnOneToSortByEarly() {
        List<Issue> expected = new ArrayList<>(List.of(issue1));
        List<Issue> actual = manager.sortByEarly();
        assertEquals(expected, actual);
    }
}
