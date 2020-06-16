package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IssueRepositoryTest {
    private IssueRepository repository = new IssueRepository();

    private Issue issue1 = new Issue(1, true, "Tolstoy", 2, new HashSet<String>(Arrays.asList("Детство", "Отрочество", "Юность")), new HashSet<String>(Arrays.asList("Pushkin", "Lermontov", "Block")));
    private Issue issue2 = new Issue(2, false, "Tolstoy", 7, new HashSet<String>(Arrays.asList("Детство", "Отрочество", "Дети")), new HashSet<String>(Arrays.asList("Pushkin", "anton", "Block")));
    private Issue issue3 = new Issue(3, true, "Chekhov", 1, new HashSet<String>(Arrays.asList("Отцы", "Дети", "Ревизор")), new HashSet<String>(Arrays.asList("Fet", "Esenin", "Nekrasov")));
    private Issue issue4 = new Issue(4, true, "Tolstoy", 9, new HashSet<String>(Arrays.asList("Юность", "Детство", "Отцы")), new HashSet<String>(Arrays.asList("Lermontov", "Esenin", "Nekrasov")));

    @BeforeEach
    void setUp() {
        repository.addAll(List.of(issue1, issue2, issue3, issue4));
    }

    @Test
    void shouldFindOpen() {
        List<Issue> expected = new ArrayList<>(List.of(issue1, issue3, issue4));
        List<Issue> actual = repository.findOpen();
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindClosed() {
        List<Issue> expected = new ArrayList<>(List.of(issue2));
        List<Issue> actual = repository.findClosed();
        assertEquals(expected, actual);
    }

    @Test
    void shouldClose() {
        repository.closeById(1);
        List<Issue> expected = new ArrayList<>(List.of(issue1, issue2));
        List<Issue> actual = repository.findClosed();
        assertEquals(expected, actual);
    }

    @Test
    void shouldOpen() {
        repository.openById(2);
        List<Issue> expected = new ArrayList<>(List.of(issue1, issue2, issue3, issue4));
        List<Issue> actual = repository.findOpen();
        assertEquals(expected, actual);
    }
}