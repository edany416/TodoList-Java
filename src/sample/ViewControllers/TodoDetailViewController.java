package sample.ViewControllers;

import javafx.event.Event;
import javafx.event.EventHandler;
import sample.Model.Todo;
import sample.Model.ViewController;
import sample.Views.TodoDetailView;
import sample.Model.TodoList;


public class TodoDetailViewController extends ViewController implements EventHandler  {

    private TodoDetailView view;
    private Todo selectedTodo;
    public TodoDetailViewController() {

        view = new TodoDetailView(this);
        populateDetailFields();
        view.setLeftButtonText("Complete");
        view.setMiddleButtonText("Delete");
        view.setRightButtonText("Edit");
        view.getDueDate().setOnMouseClicked(e -> {
            if (!view.getDueDate().isEditable()) {
                view.getDueDate().hide();
            }
        });
        view.loadView();

    }

    @Override
    public void handle(Event event) {
        Object source = event.getSource();

        if (source.equals(view.getLeftButton())) {
            if (!view.isEditable()) {
                TodoList.removeSelectedTodo();
                view.closeView();
            } else {
                Todo updatedTodo = new Todo(view.getNameField().getText());
                updatedTodo.setDueDate(view.getDueDate());
                updatedTodo.setNote(view.getNotesArea().getText());
                TodoList.updatedSelectedTodo(updatedTodo);
                view.getLeftButton().setText("Complete");
                view.getRightButton().setText("Edit");
                view.disableEditing();
                populateDetailFields();

            }

        } else if (source.equals(view.getMiddleButton())) {
            if (!view.isEditable()) {
                TodoList.removeSelectedTodo();
                view.closeView();
            }

        } else if (source.equals(view.getRightButton())) {
            if(!view.isEditable()) {
                view.enableEditing();
                view.getLeftButton().setText("Save");
                view.getRightButton().setText("Cancel");
            } else {
                populateDetailFields();
                view.disableEditing();
                view.getLeftButton().setText("Complete");
                view.getRightButton().setText("Edit");
            }

        }

    }

    private void populateDetailFields() {
        selectedTodo = TodoList.getSelectedTodo();
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
