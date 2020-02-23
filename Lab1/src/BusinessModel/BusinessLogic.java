package BusinessModel;

public class BusinessLogic {

    Entity[] list;

    public Entity[] execute(int option) {
        if (option == 1) {
            return task1();
        } else {
            return task2();
        }
        
    }

    public Entity[] task1() {
        int n = 0;
       Entity[] result = new Entity[n];
       return result;
    }

    public Entity[] task2() {

    }
}
