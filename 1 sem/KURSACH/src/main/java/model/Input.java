package model;

import model.entity.Entity;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class Input {

    private Scanner input;

    public Input() {
        input = new Scanner(System.in);
    }

    public Entity[] getFile(String filepath) throws IOException {
        String[] lines = Files.readAllLines(new File(filepath).toPath()).toArray(new String[0]);
        Entity[] Trains = new Entity[lines.length];
        for(int i = 0; i < Trains.length; i++) {
            Trains[i] = new Entity(lines[i].split(","));
        }
        return Trains;
    }


    public String getUserInput() {
        return input.nextLine();
    }

}
