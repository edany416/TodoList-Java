package sample.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class TodoList {

    private static TodoList todoListInstance = null;
    private static ObservableList<Todo> todoList;
    private static Todo selectedTodo;

    public static TodoList getTodoListInstance() {
        if(todoListInstance == null) {
            todoListInstance = new TodoList();
            if (todoList == null) {
                todoList = FXCollections.observableArrayList();
            }
        }
        return todoListInstance;
    }

    public static void addTodo(Todo newTodo) {
        getTodoListInstance().todoList.add(newTodo);
    }

    public static void removeTodo(Todo todo) {
        getTodoListInstance().todoList.remove(todo);
    }

    public static ObservableList<Todo> getTodoList() {
        return getTodoListInstance().todoList;
    }

    public static Todo getTodoAtIndex(int index) {
        return getTodoListInstance().todoList.get(index);
    }

    public static void sortByDueDate() {
        ArrayList<Todo> todosWithDate = new ArrayList<>();
        ArrayList<Todo>  todosWithoutDate = new ArrayList<>();
        Iterator<Todo> itr = todoList.iterator();

        while(itr.hasNext()) {
            Todo todo = itr.next();
            if (todo.getDueDate() != null) {
                todosWithDate.add(todo);
            } else {
                todosWithoutDate.add(todo);
            }
        }

        Collections.sort(todosWithDate);
        todosWithDate.addAll(todosWithoutDate);
        todoList.clear();
        todoList.addAll(todosWithDate);

    }

    public static void setSelectedTodo(Todo selectedTodo) {
        TodoList.selectedTodo = selectedTodo;
    }

    public static Todo getSelectedTodo() {
        return selectedTodo;
    }
}
