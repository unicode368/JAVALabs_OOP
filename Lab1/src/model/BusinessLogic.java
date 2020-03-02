package model;

import controller.Controller;

public class BusinessLogic {

    private Entity[] list;
    private Entity[] result;
    private Controller request;

    public void execute(int option) {
        request = new Controller();
        request.askForData();
        if (option == 1) {
            result = task1();
        } else {
            result = task2();
        }
        request.sendResult(result);
    }

    private Entity[] task1() {
        int resultSize = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i].getSitsNumber()[0] > 0) {
                resultSize++;
            }
        }
       result = new Entity[resultSize];
       return result;
    }

    private Entity[] task2() {
        int n = 0;
        result = new Entity[n];
        return result;
    }

    public void setList(Entity[] list) {
        this.list = list;
    }
}
