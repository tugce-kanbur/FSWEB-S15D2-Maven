package org.example.entity;
import java.util.*;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }
    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public Set<Task> getTasks(String person) {
        switch (person.toLowerCase()) {
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                return TaskData.getUnion(Arrays.asList(annsTasks, bobsTasks, carolsTasks));
            default: return Collections.emptySet();
        }
    }
    public static Set<Task> getUnion(List<Set<Task>> taskSets) {
        Set<Task> result = new HashSet<>();
        for (Set<Task> set : taskSets) {
            result.addAll(set);
        }
        return result;
    }
    public Set<Task> getUnion(Set<Task> set1, Set<Task> set2) {
        Set<Task> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }
    public Set<Task> getIntersection(Set<Task> set1, Set<Task> set2){
        Set<Task> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }
    public Set<Task> getDifferences(Set<Task> set1, Set<Task> set2){
        Set<Task> result = new HashSet<>(set1);
        result.removeAll(set2);
        return result;
    }
    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    public Set<Task> getCommonTasks() {
        Set<Task> all = getUnion(Arrays.asList(annsTasks, bobsTasks, carolsTasks));
        Set<Task> unique = new HashSet<>();
        Set<Task> duplicates = new HashSet<>();
        for (Task task : all) {
            if (!unique.add(task)) {
                duplicates.add(task);
            }
        }
        return duplicates;
    }
}
