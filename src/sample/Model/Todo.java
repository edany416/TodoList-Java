package sample.Model;

import javafx.scene.control.DatePicker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Todo implements Comparable<Todo> {

    private String name;
    private LocalDate dueDate;
    private String notes;

    public Todo(String name) {
        this.name = name;
    }

    public Todo(String name, String dueDate, String notes) {
        this(name);

        if (dueDate != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
            this.dueDate = LocalDate.parse(dueDate, formatter);
        }
        if (notes != null) {
            this.notes = notes;
        }

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

    @Override
    public int compareTo(Todo o) {
        return this.dueDate.compareTo(o.dueDate);
    }
}
