package sample;

import sample.Model.Identifiers;
import sample.Model.StageTransition;
import sample.ViewControllers.TodoListViewController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    TodoListViewController todoListViewController;
    StageTransition st;

    @Override
    public void start(Stage primaryStage) throws Exception {
        PersistenceService.loadData();
        st = new StageTransition();
        st.performTransition(Identifiers.TODO_LIST);
    }



    @Override
    public void stop() {
        PersistenceService.saveData();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
