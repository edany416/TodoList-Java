package sample.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TodoList {

    private static TodoList todoListInstance = null;
    private static ObservableList<Todo> todoList;

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
        FXCollections.sort(todoList);
    }
}
