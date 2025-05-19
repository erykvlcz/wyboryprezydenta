package models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class DrawMachine {
    private List<String> potencjalniKandydaci = List.of("Mentzen", "Braun", "Nawrocki", "Trzaskowski", "Seneszyn", "Zandberg");
    public DrawMachine() {
    }

    public void addVotesToTxt(){
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter("votes.txt"));
                ){
            int x = 0;
            while (x<1000){
                bw.write(drawRandomCandidate(potencjalniKandydaci));
                bw.newLine();
                x++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String drawRandomCandidate(List<String> candidates){
        Random random = new Random();
        return candidates.get(random.nextInt(candidates.size()));
    }

}
