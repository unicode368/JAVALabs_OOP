package controller;

import model.Entity;

public class OutputStream {

    private Entity[] list;

    OutputStream() {

    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            result.append(trainInfo(list[i]));
        }
        return result.toString();
    }

    public String trainInfo(Entity train) {
        return "\nНомер: " + train.getTrainNumber() +
                "\nПункт призначення: " + train.getTrainNumber() +
                "\nЧас відправлення: " + train.getDepartureTime() +
                "\nК-сть місць, серед яких:" +
                 "\n    загальних: " + train.getSitsNumber()[0] +
                 "\n    плацкарт: " + train.getSitsNumber()[1] +
                 "\n    купе: " + train.getSitsNumber()[2] +
                 "\n    СВ: " + train.getSitsNumber()[3] + "\n";

    }

    public void setList(Entity[] list) {
        this.list = list;
    }
}
