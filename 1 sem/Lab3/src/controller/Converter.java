package controller;

import model.entity.Entity;

public class Converter {

    private Entity[] list;

    Converter(Entity[] list) {
        this.list = new Entity[list.length];
        this.list = list;
    }

    @Override
    public String toString() {
        StringBuilder result1 = new StringBuilder();
        int amount = list.length;
        if (amount == 0) {
            return "Поїздів, які відповідають даному запиту немає. ";
        }
        result1.append("\n").append(String.format("%s","-----------------------------------------------" +
                "--------------------------------------------------------------------------------" +
                "-----------------------------------------")).append("\n");
        for (int counter = 0; counter <= amount; counter = counter + 3) {
            if (amount - 1 - counter < 3) {
                result1.append(trainInfo(list, amount - counter, counter));
                result1.append("\n").append(String.format("%s","-----------------------------------------------" +
                        "--------------------------------------------------------------------------------" +
                        "-----------------------------------------"));
                break;
            } else {
                result1.append(trainInfo(list,3, counter)).append("\n");
                result1.append("\n").append(String.format("%s","-----------------------------------------------" +
                        "--------------------------------------------------------------------------------" +
                        "-----------------------------------------")).append("\n");
            }
        }
        return result1.toString();
    }

    public String trainInfo(Entity[] trains, int size, int start) {
        return getRow(trains, size, start, "TrainNumber") + "\n" +
                getRow(trains, size, start, "FinalDestination") + "\n" +
                getRow(trains, size, start, "DepartureTime") + "\n" +
                getRow(trains, size, start, "SitsNumber");
    }

    public String getRow(Entity[] trains, int size, int start, String kindOfInfo) {
        String row = "";
        switch (kindOfInfo) {
            case "TrainNumber" :
                for (int i = start; i < size + start; i++) {
                    row += String.format("%30s %25s","Номер: " + trains[i].getTrainNumber(), "|");
                }
                break;
            case "FinalDestination" :
                for (int i = start; i < size + start; i++) {
                    row += String.format("%30s %25s","Пункт призначення: " + trains[i].getFinalDestination(),
                            "|");
                }
                break;
            case "DepartureTime" :
                for (int i = start; i < size + start; i++) {
                    row += String.format("%30s %25s","Час відправлення: " + trains[i].getDepartureTime(),
                            "|");
                }
                break;
            case "SitsNumber" :
                for (int i = start; i < size + start; i++) {
                    row += String.format("%30s %25s","К-сть місць, серед яких: ",
                            "|");
                }
                row += "\n";
                for (int i = start; i < size + start; i++) {
                    row += String.format("%30s %25s","загальних: " + trains[i].getSitsNumber()[0],
                            "|");
                }
                row += "\n";
                for (int i = start; i < size + start; i++) {
                    row += String.format("%30s %25s","плацкарт: " + trains[i].getSitsNumber()[1],
                            "|");
                }
                row += "\n";
                for (int i = start; i < size + start; i++) {
                    row += String.format("%30s %25s","купе: " + trains[i].getSitsNumber()[2],
                            "|");
                }
                row += "\n";
                for (int i = start; i < size + start; i++) {
                    row += String.format("%30s %25s","СВ: " + trains[i].getSitsNumber()[3],
                            "|");
                }
                break;
        }
        return row;
    }

}
