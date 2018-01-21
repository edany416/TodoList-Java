package sample.Views;

import sample.ViewControllers.AddNewTodoViewController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class AddNewTodoView {

    private Button saveButton;
    private Scene scene;
    private TextField nameField;
    private DatePicker dueDate;
    private TextArea notesArea;

    public AddNewTodoView(AddNewTodoViewController vc) {

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        nameField = new TextField();
        dueDate = new DatePicker();
        pane.add(new Label("Todo:"),0,0);
        pane.add(nameField, 1, 0);
        pane.add(new Label("Due Date:"),0, 1);
        pane.add(dueDate, 1, 1);
        pane.add(new Label("Notes:"),0, 2);

        notesArea = new TextArea();
        notesArea.setPrefRowCount(10);
        pane.add(notesArea, 1, 2);

        saveButton = new Button("Save");
        saveButton.setOnAction(vc);

        pane.add(saveButton, 0, 3);
        scene = new Scene(pane);

    }

    public Scene getScene() {
        return scene;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public TextField getNameField() {
        return nameField;
    }

    public DatePicker getDueDate() {
        return dueDate;
    }

    public TextArea getNotesArea() {
        return notesArea;
    }
}
