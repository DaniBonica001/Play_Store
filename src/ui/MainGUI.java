package ui;

import controller.StoreController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Store;

public class MainGUI extends Application {

    private final StoreController storeController;
    private Store store;

    public MainGUI() {
        store = new Store();
        storeController = new StoreController(store);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scenes/main.fxml"));
        fxmlLoader.setController(storeController);
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Play Store");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
