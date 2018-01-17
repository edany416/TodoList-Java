package sample;

public class SelectedTodoStageController {

    private static Todo selectedTodo;


    static void setSelectedTodo(Todo todo) {
        selectedTodo = todo;
    }

    static Todo getSelectedTodo() {
        return selectedTodo;
    }
}
