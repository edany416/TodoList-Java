package sample.ViewControllers;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ListCell;
import sample.Model.Identifiers;
import sample.Model.Todo;
import sample.Model.TodoList;
import sample.Model.ViewController;
import sample.Views.TodoListView;



public class TodoListViewController extends ViewController implements EventHandler {
    TodoListView view;

    public TodoListViewController() {
        super();
        view = new TodoListView(TodoList.getTodoList(), this);
        setListViewCellFactory();
        view.loadView();
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
                    TodoList.setSelectedTodo(cell.getItem());
                    this.transitionTo(Identifiers.TODO_DETAIL);
                }
            });
            return cell ;
        });
    }

    private void launchAddNewTodoStage() {
        this.transitionTo(Identifiers.ADD_NEW_TODO);
    }

}
