package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Todo List");
        primaryStage.setResizable(false);

        //Pane set up
        VBox container = new VBox();
        HBox buttonPane = new HBox();
        buttonPane.setAlignment(Pos.CENTER);

        //Button set up
        Button createNewTodoButton = new Button("Create new todo");
        Listeners.createNewTodoListener(createNewTodoButton);


        //List and data set up
        ListView<Todo> listView = new ListView<>();
        listView.setItems(TodoList.getTodoListInstance().getTodoList());

        //Final set up
        buttonPane.getChildren().add(createNewTodoButton);
        container.getChildren().add(listView);
        container.getChildren().add(buttonPane);

        Listeners.selectedIndexListener(listView);

        primaryStage.setScene(new Scene(container, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
