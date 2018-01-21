package sample.ViewControllers;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ListCell;
import javafx.stage.Stage;
import sample.Model.Todo;
import sample.Model.TodoList;
import sample.Views.TodoListView;


public class TodoListViewController implements EventHandler {
    private final Stage primaryStage;
    TodoListView view = new TodoListView(TodoList.getTodoList(), this);

    public TodoListViewController(final Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Todo List");
        this.primaryStage.setResizable(false);
        setListViewCellFactory();
        primaryStage.setScene(view.getScene());
    }

    @Override
    public void handle(final Event event) {
        Object source = event.getSource();

        if (source.equals(view.getCreateNewTodoButton())) {
            launchAddNewTodoStage();
        }

        if (source.equals(view.getSortByDueDateButton())) {
            TodoList.sortByDueDate();
        }
    }

    private void setListViewCellFactory() {
        view.getListView().setCellFactory(lv -> {
            ListCell<Todo> cell = new ListCell<Todo>() {
                @Override
                protected void updateItem(Todo item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(item == null ? "" : item.toString());
                }
            };
            cell.setOnMouseClicked(e -> {
                if (e.getClickCount() == 2 && !cell.isEmpty()) {
                    Stage stage = new Stage();
                    stage.setScene(new TodoDetailViewController(cell.getItem(), stage).getScene());
                    stage.show();
                }
            });
            return cell ;
        });
    }

    private void launchAddNewTodoStage() {
        Stage addNewTodoStage = new Stage();
        addNewTodoStage.setScene(new AddNewTodoViewController(addNewTodoStage).getScene());
        addNewTodoStage.show();
    }

}
