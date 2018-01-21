package sample.ViewControllers;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Views.AddNewTodoView;
import sample.Model.Todo;
import sample.Model.TodoList;

public class AddNewTodoViewController implements EventHandler{

    private AddNewTodoView view;
    private Stage stage;

    public AddNewTodoViewController(Stage stage) {
        view = new AddNewTodoView(this);
        this.stage = stage;

    }

    @Override
    public void handle(final Event event) {
        final Object source = event.getSource();
        if (source.equals(view.getSaveButton())) {
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
                stage.close();
            }
        }

    }

    public Scene getScene() {
        return view.getScene();
    }
}
