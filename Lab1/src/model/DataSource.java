package model;

public class DataSource {
    public Entity[] generateArray(int n) {
        Entity[] data = new Entity[n];
        for (int i = 0; i < data.length; i++) {
            data[i] = new Entity();
        }
        return data;
    }
}
