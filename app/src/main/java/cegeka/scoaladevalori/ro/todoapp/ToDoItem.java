package cegeka.scoaladevalori.ro.todoapp;

import java.io.Serializable;
import java.util.Date;

public class ToDoItem implements Serializable {
    public String title;
    public String description;
    public int priority;
    public Date dueDate;
}
