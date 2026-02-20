package model;

import java.util.ArrayList;
import java.util.List;

public class taskLst {
    public static class OneTask{
        private String description;
        private boolean isDone;

        public OneTask(String description){
            this.description = description;
            this.isDone = false;
        }

        public String getDescription(){
            return description;
        }

        public boolean getIsDone(){
            return isDone;
        }

        public void markIfDone(){
            this.isDone = true;
        }

        @Override
        public String toString(){
            String status = isDone ? "[✓]" : "[ ]";
            return status + " " + description;
        }
    }
    private List<OneTask> tasks;

    public taskLst(){
        tasks = new ArrayList<>();
    }

    public void addTask(String description){
        if (description == null || description.trim().isEmpty()){
            return;
        }
        OneTask newTask = new OneTask(description.trim());
        tasks.add(newTask);
    }

    public boolean removeTask(int index){
        if(index >= 0 && index < tasks.size()){
            tasks.remove(index);
            return true;
        }
        return false;
    }

    public boolean markDone(int index){
        if (index >= 0 && index < tasks.size()){
            tasks.get(index).markIfDone();
            return true;
        }
        return false;
    }

    public List<OneTask> getALLtasks(){
        return new ArrayList<>(tasks); // лучше вернуть копию чтобы внешний код ничего не менял в ориг списке.
    }

    public List<OneTask> getActiveTasks(){
        List<OneTask> active = new ArrayList<>();
        for (OneTask t : tasks){
            if (!t.getIsDone()){
                active.add(t);
            }
        }
        return active;
    }

    public List<OneTask> getCompletedTasks(){
        List<OneTask> completed = new ArrayList<>();
        for (OneTask t1 : tasks){
            if(t1.getIsDone()){
                completed.add(t1);
            }
        }
        return completed;
    }
    public int size(){
        return tasks.size();
    }
}

