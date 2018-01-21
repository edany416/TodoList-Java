package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;

public class Listeners {

    static void selectedIndexListener(ListView<Todo> listView) {

        listView.setCellFactory(lv -> {
            ListCell<Todo> cell = new ListCell<Todo>() {
                @Override
                protected void updateItem(Todo item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(item == null ? "" : item.toString());
                }
            };
            cell.setOnMouseClicked(e -> {
                if (! cell.isEmpty()) {
                    StageController.launchSelectedTodoStage(cell.getItem());
                }
            });
            return cell ;
        });
    }

    static void createNewTodoListener(Button createNewTodoButton) {
        createNewTodoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StageController.launchNewTodoStage();
            }
        });
    }

    static void saveTodoListener(Button saveTodoButton, TextField nameField, DatePicker dueDate, TextArea notesArea) {
        saveTodoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Todo newTodo;
                if (nameField.getText() != null && !nameField.getText().isEmpty()) {
                    newTodo = new Todo(nameField.getText());

                    if (dueDate.getValue() != null) {
                        newTodo.setDueDate(dueDate);
                    }

                    if (notesArea.getText() != null && !notesArea.getText().isEmpty()) {
                        newTodo.setNote(notesArea.getText());
                    }

                    TodoList.getTodoListInstance().addTodo(newTodo);
                    StageController.closeCurrentStage();
                }
            }
        });
    }

    static void completeTodoListener(Button completeTodoButton) {
        completeTodoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TodoList.removeTodo(SelectedTodoStageController.getSelectedTodo());
                StageController.closeCurrentStage();
            }
        });
    }

    static void deleteTodoListener(Button deleteTodoButton) {
        deleteTodoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TodoList.removeTodo(SelectedTodoStageController.getSelectedTodo());
                StageController.closeCurrentStage();
            }
        });
    }

    static void editTodoButtonListener(Button editButton) {
        editButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }
}
