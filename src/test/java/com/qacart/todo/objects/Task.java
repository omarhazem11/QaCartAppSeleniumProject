package com.qacart.todo.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {

    private boolean isCompleted;
    private String item;

    public Task(boolean isCompleted, String item){
        this.isCompleted = isCompleted;
        this.item = item;
    }


    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}