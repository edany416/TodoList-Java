package sample;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Iterator;

public class PersistenceService {

    static void saveData() {
        JSONObject obj  = new JSONObject();
        JSONArray todoContainer = new JSONArray();
        for(int i = 0; i < TodoList.getTodoList().size(); i++) {
            JSONObject todoData = new JSONObject();
            Todo todoToSave = TodoList.getTodoAtIndex(i);
            todoData.put("Name", todoToSave.getName());
            if (todoToSave.getDueDate() != null) {
                todoData.put("DueDate", todoToSave.getDueDate().toString());
            } else {
                todoData.put("DueDate", null);
            }
            if (todoToSave.getNotes() != null) {
                todoData.put("Notes", todoToSave.getNotes());
            } else {
                todoData.put("Notes", null);
            }

            todoContainer.add(todoData);
        }

        obj.put("TodoContainer", todoContainer);

        try (FileWriter file = new FileWriter("TodoFile")) {
            file.write(obj.toJSONString());
            file.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Shit wasn't saved");
        }

        System.out.println("Object was successfully saved");
        //System.out.print(obj);
    }

    static void loadData() {
        //Load Data
        JSONParser parser = new JSONParser();

        try {
            File dataFile = new File("TodoFile");
            if (dataFile.exists() && dataFile.length() != 0) {
                Object parsedObj = parser.parse(new FileReader(dataFile.getName()));
                JSONObject jsonObject = (JSONObject) parsedObj;
                JSONArray todoContainer = (JSONArray) jsonObject.get("TodoContainer");
                Iterator<JSONObject> iterator = todoContainer.iterator();
                while (iterator.hasNext()) {
                    JSONObject obj = iterator.next();
                    String name = (String)obj.get("Name");
                    String dueDate = (String)obj.get("DueDate");
                    String notes = (String)obj.get("Notes");
                    Todo todo = new Todo(name, dueDate, notes);
                    TodoList.addTodo(todo);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
