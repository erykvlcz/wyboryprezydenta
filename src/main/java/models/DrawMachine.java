package models;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DrawMachine {
    private final static String TXTFILE = "votes.txt";
    private List<String> potencjalniKandydaci = List.of("Mentzen", "Braun", "Nawrocki", "Trzaskowski", "Seneszyn", "Zandberg");
    public DrawMachine() {
    }

    public void countAndShowVotes(){
        Map<String, Integer> candidatesCounter = new HashMap<>();
        try (
                BufferedReader br = new BufferedReader(new FileReader(TXTFILE));
                ){
            String line = null;
            while ((line = br.readLine()) != null){
                if(!candidatesCounter.containsKey(line)){
                    candidatesCounter.put(line, 1);
                }else {
                    candidatesCounter.replace(line, candidatesCounter.get(line) + 1);
                }
            }
        } catch (FileNotFoundException ef) {
            ef.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        showSortedMap(candidatesCounter);
    }

    private void showSortedMap(Map<String, Integer> mapBeforeSort){
        Optional<Map.Entry<String, Integer>> bValue = mapBeforeSort.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

        bValue.ifPresent(entry ->
                System.out.println("Największa wartość: " + entry.getKey() + " = " + entry.getValue())
        );
    }


    private void addVotesToTxt(){
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(TXTFILE));
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
