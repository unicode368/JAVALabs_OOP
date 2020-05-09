package model;

import model.entity.Entity;

public class DataSource {

    private final String[] FINAL_DESTINATION = {"Київ", "Чернігів", "Одеса", "Суми", "Харків", "Черкаси",
    "Дніпро", "Київ", "Львів", "Луцьк", "Шостка", "Кривий Ріг", "Кам'янське"};

<<<<<<< Updated upstream
    public Entity[] generateArray(int n) {
        Entity[] data = new Entity[n];
=======
<<<<<<<< Updated upstream:Lab2/src/model/DataSource.java
    public Entity[] generateArray() {
        Entity[] data = new Entity[RandomSelect.size()];
========
    public Entity[] generateArray(int n) {
        Entity[] data = new Entity[n];
>>>>>>>> Stashed changes:Lab1/src/model/DataSource.java
>>>>>>> Stashed changes
        for (int i = 0; i < data.length; i++) {
            data[i] = new Entity(RandomSelect.selectCity(FINAL_DESTINATION),
                    RandomSelect.selectTrainNumber(),
                    RandomSelect.selectTime(),
                    RandomSelect.selectNumberOfPlaces()
                    );
        }
        return data;
    }
}
