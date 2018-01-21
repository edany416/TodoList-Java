package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    TodoListViewController todoListViewController;


    @Override
    public void start(Stage primaryStage) throws Exception {
        PersistenceService.loadData();
        todoListViewController = new TodoListViewController(primaryStage);
        primaryStage.show();
    }



    @Override
    public void stop() {
        PersistenceService.saveData();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
