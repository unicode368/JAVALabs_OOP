package model;

import controller.Controller;

public class BusinessLogic {

    Entity[] list;
    Entity[] result;
    Controller request;

    public Entity[] execute(int option) {
        if (option == 1) {
            return task1();
        } else {
            return task2();
        }

    }

    public Entity[] task1() {
        int n = 0;
       result = new Entity[n];
       return result;
    }

    public Entity[] task2() {
        int n = 0;
        result = new Entity[n];
        return result;
    }

    public void setList(Entity[] list) {
        this.list = list;
    }
}
