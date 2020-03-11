package model;

import model.entity.Entity;

public class DataSource {

    private final String[] finalDestination = {"Київ", "Чернігів", "Одеса", "Суми", "Харків", "Черкаси",
    "Дніпро", "Київ", "Львів", "Луцьк", "Шостка", "Кривий Ріг", "Кам'янське"};

    public Entity[] generateArray(int n) {
        Entity[] data = new Entity[n];
        for (int i = 0; i < data.length; i++) {
            data[i] = new Entity(RandomSelect.selectCity(finalDestination),
                    RandomSelect.selectTrainNumber(),
                    RandomSelect.selectTime(),
                    RandomSelect.selectNumberOfPlaces()
                    );
        }
        return data;
    }
}
