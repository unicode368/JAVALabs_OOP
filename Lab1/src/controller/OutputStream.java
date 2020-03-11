package controller;

import model.entity.Entity;

public class OutputStream {

    private Entity[] list;

    OutputStream(Entity[] list) {
        this.list = new Entity[list.length];
        this.list = list;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (list.length == 0) {
            return "Поїздів, які відповідають даному запиту немає. ";
        }
        for (Entity aList : list) {
            result.append(trainInfo(aList));
        }
        return result.toString();
    }

    public String trainInfo(Entity train) {
        return "\nНомер: " + train.getTrainNumber() +
                "\nПункт призначення: " + train.getFinalDestination() +
                "\nЧас відправлення: " + train.getDepartureTime() +
                "\nК-сть місць, серед яких:" +
                 "\n    загальних: " + train.getSitsNumber()[0] +
                 "\n    плацкарт: " + train.getSitsNumber()[1] +
                 "\n    купе: " + train.getSitsNumber()[2] +
                 "\n    СВ: " + train.getSitsNumber()[3] + "\n";
    }

}
