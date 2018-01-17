package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;

public class StageController {

    private static Stage currentStage;

    /**
     * This method launches the create new task
     * stage when the create new task button is tapped
     */
    static void launchNewTodoStage() {
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("Create Todo");

        currentStage = stage;

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        TextField nameField = new TextField();
        DatePicker dueDate = new DatePicker();
        pane.add(new Label("Todo:"),0,0);
        pane.add(nameField, 1, 0);
        pane.add(new Label("Due Date:"),0, 1);
        pane.add(dueDate, 1, 1);
        pane.add(new Label("Notes:"),0, 2);

        TextArea notesArea = new TextArea();
        notesArea.setPrefRowCount(10);
        pane.add(notesArea, 1, 2);

        Button saveButton = new Button("Save");
        pane.add(saveButton, 0, 3);

        Listeners.saveTodoListener(saveButton, nameField, dueDate, notesArea);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method launched the task view stage when a task
     * in the list view is selected
     * @param selectedTodo
     */
    static void launchSelectedTodoStage(Todo selectedTodo) {
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle(selectedTodo.getName());

        currentStage = stage;
        SelectedTodoStageController.setSelectedTodo(selectedTodo);

        TextField nameField = new TextField();
        nameField.setText(selectedTodo.getName());
        nameField.setEditable(false);
        DatePicker dueDate = new DatePicker();
        dueDate.setValue(selectedTodo.getDueDate());
        dueDate.setEditable(false);



        GridPane pane = new GridPane();
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        pane.add(new Label("Todo:"),0,0);
        pane.add(nameField, 1, 0);
        pane.add(new Label("Due Date:"),0, 1);
        pane.add(dueDate, 1, 1);
        pane.add(new Label("Notes:"),0, 2);

        if (selectedTodo.getDueDate() != null) {
            int daysUntilDue = selectedTodo.getDueDate().getDayOfMonth() -
                    LocalDate.now().getDayOfMonth();
            Label daysUntilDueLabel = new Label("Due in " + daysUntilDue + " days");
            pane.add(daysUntilDueLabel, 2, 1);
        }

        TextArea notesArea = new TextArea();
        notesArea.setText(selectedTodo.getNotes());
        notesArea.setEditable(false);

        notesArea.setPrefRowCount(10);
        pane.add(notesArea, 1, 2);

        Button completeTodoButton = new Button("Complete");
        Button deleteTodoButton = new Button("Delete");
        Button editButton = new Button("Edit");
        pane.add(completeTodoButton, 0, 3);
        pane.add(deleteTodoButton, 1, 3);
        pane.add(editButton, 2, 3);
        Listeners.completeTodoListener(completeTodoButton);
        Listeners.deleteTodoListener(deleteTodoButton);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    static void closeCurrentStage() {
        currentStage.close();
        currentStage = null;
    }

}
