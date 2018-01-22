package sample.ViewControllers;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Model.ViewController;
import sample.Views.AddNewTodoView;
import sample.Model.Todo;
import sample.Model.TodoList;

public class AddNewTodoViewController extends ViewController implements EventHandler {

    private AddNewTodoView view;

    public AddNewTodoViewController() {
        view = new AddNewTodoView(this);
        view.loadView();

    }

    @Override
    public void handle(final Event event) {
        final Object source = event.getSource();
        if (source.equals(view.getSaveButton())) {
            addNewTodo();
        }
    }

    private void addNewTodo() {
        if (view.getNameField().getText() != null && !view.getNameField().getText().isEmpty()) {
            Todo newTodo;
            newTodo = new Todo(view.getNameField().getText());

            if (view.getDueDate().getValue() != null) {
                newTodo.setDueDate(view.getDueDate());
            }

            if (view.getNotesArea().getText() != null && !view.getNotesArea().getText().isEmpty()) {
                newTodo.setNote(view.getNotesArea().getText());
            }

            TodoList.addTodo(newTodo);
            view.closeView();
        }
    }
}
