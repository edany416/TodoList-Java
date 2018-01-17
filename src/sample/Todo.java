package sample;

import javafx.scene.control.DatePicker;
import java.time.LocalDate;

public class Todo {

        private String name;
        private LocalDate dueDate;
        private String notes;

        public Todo(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public LocalDate getDueDate() {
            return dueDate;
        }

        public String getNotes() {
            return notes;
        }

        public void setDueDate(DatePicker dueDate) {
            this.dueDate = dueDate.getValue();
        }

        public void setNote(String notes) {
            this.notes = notes;
        }

        @Override
        public String toString() {
            return name;
        }
}
