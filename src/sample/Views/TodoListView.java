package sample.Views;

import sample.ViewControllers.TodoListViewController;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.Model.Todo;


public class TodoListView {
    private Button createNewTodoButton;
    private Button sortByDueDateButton;
    private ListView<Todo> listView;
    private Scene scene;

    public TodoListView(ObservableList<Todo> todoList, final TodoListViewController vc) {
        //Pane setup
        VBox container = new VBox();
        HBox buttonPane = new HBox();
        buttonPane.setAlignment(Pos.CENTER);

        //Button setup
        createNewTodoButton = new Button("Create new todo");
        sortByDueDateButton = new Button("Sort");
        createNewTodoButton.setOnAction(vc);
        sortByDueDateButton.setOnAction(vc);


        //List and data setup
        listView = new ListView<>(todoList);

        //Final setup
        buttonPane.getChildren().add(createNewTodoButton);
        buttonPane.getChildren().add(sortByDueDateButton);
        container.getChildren().add(listView);
        container.getChildren().add(buttonPane);

        scene = new Scene(container, 500, 450);
    }

    public Scene getScene() {
        return scene;
    }

    public Button getCreateNewTodoButton() {
        return createNewTodoButton;
    }

    public ListView getListView() {
        return listView;
    }

    public Button getSortByDueDateButton() {
        return sortByDueDateButton;
    }
}
