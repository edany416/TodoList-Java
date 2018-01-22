package sample.ViewControllers;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Model.Todo;
import sample.Model.ViewController;
import sample.Views.TodoDetailView;
import sample.Model.TodoList;

public class TodoDetailViewController extends ViewController implements EventHandler  {

    private TodoDetailView view;
    private Todo selectedTodo;
    public TodoDetailViewController() {
        selectedTodo = TodoList.getSelectedTodo();
        view = new TodoDetailView(this);
        populateDetailFields();
        view.loadView();

    }

    @Override
    public void handle(Event event) {
        Object source = event.getSource();

        if (source.equals(view.getCompleteTodoButton()) || source.equals(view.getDeleteTodoButton())) {
            TodoList.removeTodo(selectedTodo);
            view.closeView();
        }

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
