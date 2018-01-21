package sample;

import sample.Model.Todo;

public class SelectedTodoController {

    private static Todo selectedTodo;


    static void setSelectedTodo(Todo todo) {
        selectedTodo = todo;
    }

    static Todo getSelectedTodo() {
        return selectedTodo;
    }
}
