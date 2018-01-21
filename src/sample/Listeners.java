package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;

public class Listeners {


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
}
