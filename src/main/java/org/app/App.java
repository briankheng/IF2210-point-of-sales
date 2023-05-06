package org.app;

import org.app.DataStore.DataStore;
import org.app.GUI.MainGUI;

public class App {
    DataStore dataStore;

    public App() {
        dataStore = new DataStore();
        dataStore.load();

        new MainGUI();
    }

    public static void main(String[] args) {
        new App();
    }
}
