package sample.Views;

import javafx.stage.Stage;
import sample.Model.Todo;
import sample.Model.TodoList;
import sample.ViewControllers.TodoDetailViewController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class TodoDetailView {

    private TextField nameField;
    private DatePicker dueDate;
    private TextArea notesArea;
    private Button  leftButton;
    private Button middleButton;
    private Button rightButton;
    private Scene scene;
    private GridPane pane;
    private Label daysUntilDueLabel;
    private Stage stage;
    private boolean isInEditMode;

    public TodoDetailView(TodoDetailViewController vc) {
        nameField = new TextField();
        nameField.setEditable(false);
        dueDate = new DatePicker();
        dueDate.setEditable(false);
        isInEditMode = false;

        pane = new GridPane();
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        pane.add(new Label("Todo:"),0,0);
        pane.add(nameField, 1, 0);
        pane.add(new Label("Due Date:"),0, 1);
        pane.add(dueDate, 1, 1);
        pane.add(new Label("Notes:"),0, 2);

        notesArea = new TextArea();
        notesArea.setEditable(false);

        notesArea.setPrefRowCount(10);
        pane.add(notesArea, 1, 2);

        leftButton = new Button();
        leftButton.setOnAction(vc);
        middleButton = new Button();
        middleButton.setOnAction(vc);
        rightButton = new Button();
        rightButton.setOnAction(vc);
        pane.add(leftButton, 0, 3);
        pane.add(middleButton, 1, 3);
        pane.add(rightButton, 2, 3);

        scene = new Scene(pane);
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

    public Button getLeftButton() {
        return leftButton;
    }

    public Button getMiddleButton() {
        return middleButton;
    }

    public Button getRightButton() {
        return rightButton;
    }

    public void setLeftButtonText(String text) {
        leftButton.setText(text);
    }

    public void setMiddleButtonText(String text) {
        middleButton.setText(text);
    }

    public void setRightButtonText(String text) {
        rightButton.setText(text);
    }

    public void setNameFieldText(String text) {
        this.nameField.setText(text);
    }

    public void setDueDateDate(LocalDate dueDate) {
        if (dueDate != null) {
            this.dueDate.setValue(dueDate);
        }
    }

    public void setNotesAreaText(String notes) {
        if (notes != null) {
            this.notesArea.setText(notes);
        }
    }

    public void setDueDateLabelElapseTime(LocalDate dueDate) {

        if (dueDate != null) {
            int daysUntilDue = dueDate.getDayOfMonth() -
                    LocalDate.now().getDayOfMonth();

            if (daysUntilDue > 0) {
                daysUntilDueLabel = new Label("Due in " + daysUntilDue + " days");
            } else if (daysUntilDue == 0) {
                daysUntilDueLabel = new Label("DUE TODAY");
            } else {
                daysUntilDueLabel = new Label("Due " + Math.abs(daysUntilDue) + " days ago" );
                daysUntilDueLabel.setTextFill(Color.RED);
            }

            pane.add(daysUntilDueLabel, 2, 1);
        }

    }

    public void loadView() {
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void closeView() {
        stage.close();
    }

    public void enableEditing() {
        nameField.setEditable(true);
        notesArea.setEditable(true);
        dueDate.setEditable(true);
        isInEditMode = true;
    }

    public void disableEditing() {
        nameField.setEditable(false);
        notesArea.setEditable(false);
        dueDate.setEditable(false);
        isInEditMode = false;
    }

    public boolean isEditable() {
        return isInEditMode;
    }




}
