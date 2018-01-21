package sample.ViewControllers;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Model.Todo;
import sample.Views.TodoDetailView;
import sample.Model.TodoList;

public class TodoDetailViewController implements EventHandler {

    private TodoDetailView view;
    private Todo selectedTodo;
    private Stage stage;

    TodoDetailViewController(Todo selectedTodo, Stage stage) {

        view = new TodoDetailView(this);
        this.selectedTodo = selectedTodo;
        this.stage = stage;
        populateDetailFields();

    }

    @Override
    public void handle(Event event) {
        Object source = event.getSource();

        if (source.equals(view.getCompleteTodoButton()) || source.equals(view.getDeleteTodoButton())) {
            TodoList.removeTodo(selectedTodo);
            stage.close();
        }

    }

    public Scene getScene() {
        return view.getScene();
    }

    private void populateDetailFields() {
        view.setNameFieldText(selectedTodo.getName());
        if (selectedTodo.getDueDate() != null) {
            view.setDueDateDate(selectedTodo.getDueDate());
            view.setDueDateLabelElapseTime(selectedTodo.getDueDate());
        }

        if (selectedTodo.getNotes() != null) {
            view.setNotesAreaText(selectedTodo.getNotes());
        }


    }
}
