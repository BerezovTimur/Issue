package ru.netology.domain;

import java.util.Set;

public class Issue implements Comparable<Issue> {
    private int id;
    private boolean isOpen;
    private String author;
    private int dayOpen;
    private Set<String> labels;
    private Set<String> assigned;

    @Override
    public int compareTo(Issue o) {
        return dayOpen - o.dayOpen;
    }

    public Issue(int id, boolean isOpen, String author, int dayOpen, Set<String> labels, Set<String> assigned) {
        this.id = id;
        this.isOpen = isOpen;
        this.author = author;
        this.dayOpen = dayOpen;
        this.labels = labels;
        this.assigned = assigned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getDayOpen() {
        return dayOpen;
    }

    public void setDayOpen(int dayOpen) {
        this.dayOpen = dayOpen;
    }

    public Set<String> getLabels() {
        return labels;
    }

    public void setLabels(Set<String> labels) {
        this.labels = labels;
    }

    public Set<String> getAssigned() {
        return assigned;
    }

    public void setAssigned(Set<String> assigned) {
        this.assigned = assigned;
    }
}
