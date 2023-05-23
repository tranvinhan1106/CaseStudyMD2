package src.views;

import src.controllers.FuramaController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FuramaController furamaController = new FuramaController();
        furamaController.displayMainMenu();
    }
}
