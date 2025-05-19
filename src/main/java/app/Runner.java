package app;

import models.DrawMachine;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        DrawMachine drawMachine = new DrawMachine();
        drawMachine.countAndShowVotes();
    }
}
