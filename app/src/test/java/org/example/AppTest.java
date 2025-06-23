package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AppTest {

    private TodoList todoList;

    @BeforeEach
    void setup() {
        todoList = new TodoList();
    }

    @Test
    void testAddTask() {
        assertTrue(todoList.add("Buy milk"));
        assertEquals(1, todoList.getAllTasks().size());
        assertEquals("Buy milk", todoList.getAllTasks().get(0).getDescription());
    }

    @Test
    void testAddInvalidTask() {
        assertFalse(todoList.add(""));
        assertFalse(todoList.add(null));
        assertEquals(0, todoList.getAllTasks().size());
    }

    @Test
    void testCompleteTask() {
        todoList.add("Buy eggs");
        assertTrue(todoList.complete("Buy eggs"));
        assertTrue(todoList.getAllTasks().get(0).isComplete());
    }

    @Test
    void testCompleteCaseInsensitive() {
        todoList.add("Buy eggs");
        assertTrue(todoList.complete("bUy EgGs"));
    }

    @Test
    void testCompleteNonexistentTask() {
        todoList.add("Buy milk");
        assertFalse(todoList.complete("Nonexistent Task"));
    }

    @Test
    void testCompletedAndIncomplete() {
        todoList.add("Task 1");
        todoList.add("Task 2");
        todoList.complete("Task 1");

        ArrayList<Task> completed = todoList.getCompletedTasks();
        ArrayList<Task> incomplete = todoList.getIncompleteTasks();

        assertEquals(1, completed.size());
        assertEquals(1, incomplete.size());
        assertEquals("Task 1", completed.get(0).getDescription());
        assertEquals("Task 2", incomplete.get(0).getDescription());
    }

    @Test
    void testClearList() {
        todoList.add("Task 1");
        todoList.add("Task 2");
        todoList.clear();
        assertEquals(0, todoList.getAllTasks().size());
    }
}
