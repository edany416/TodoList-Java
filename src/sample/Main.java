package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Todo List");
        primaryStage.setResizable(false);

        PersistanceService.loadData();

        //Pane set up
        VBox container = new VBox();
        HBox buttonPane = new HBox();
        buttonPane.setAlignment(Pos.CENTER);

        //Button set up
        Button createNewTodoButton = new Button("Create new todo");
        Listeners.createNewTodoListener(createNewTodoButton);
        Button sortByDueDateButton = new Button("Sort");

        //List and data set up
        ListView<Todo> listView = new ListView<>(TodoList.getTodoListInstance().getTodoList());
        listView.setItems(TodoList.getTodoListInstance().getTodoList());

        //Final set up
        buttonPane.getChildren().add(createNewTodoButton);
        buttonPane.getChildren().add(sortByDueDateButton);
        container.getChildren().add(listView);
        container.getChildren().add(buttonPane);

        sortByDueDateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TodoList.getTodoListInstance().sortByDueDate();
            }
        });

        Listeners.selectedIndexListener(listView);

        primaryStage.setScene(new Scene(container, 300, 275));
        primaryStage.show();
    }



    @Override
    public void stop() {
        PersistanceService.saveData();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
