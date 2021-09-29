package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import model.Client;
import model.Game;
import model.Store;
import java.util.ArrayList;
import java.util.Optional;

public class StoreController {

    @FXML
    private VBox vbox;

    @FXML
    private Label lblInfo;

    @FXML
    private Label lblCashiers;

    @FXML
    private Label lblShelves;

    @FXML
    private Label lblInfoShelves;

    @FXML
    private Label lblClients;

    @FXML
    private Label lblInfoClients;

    @FXML
    private Button btnToStep2;

    @FXML
    private Button btnToStep3;

    @FXML
    private Button btnToStep4;

    @FXML
    private Button btnNextShelve;

    @FXML
    private TextField txtCashiers;

    @FXML
    private TextField txtShelves;

    @FXML
    private TextField txtClients;

    @FXML
    private TextArea txtShelvesInfo;

    @FXML
    private TextArea txtClientsInfo;

    @FXML
    private TextField txtShelfID;

    @FXML
    private TextField txtGamesAmount;

    private Store store;

    public StoreController(Store store) {
        this.store = store;
    }

    private int shelvesToCreate;
    private int shelvesCreated = 0;

    @FXML
    void toStep2(ActionEvent event) {

        if(!txtCashiers.getText().isEmpty() && !txtShelves.getText().isEmpty()) {
            int cashiersAmount = Integer.parseInt(txtCashiers.getText());
            shelvesToCreate = Integer.parseInt(txtShelves.getText());

            store.createCashier(cashiersAmount);

            vbox.getChildren().remove(lblCashiers);
            vbox.getChildren().remove(txtCashiers);
            vbox.getChildren().remove(lblShelves);
            vbox.getChildren().remove(txtShelves);
            vbox.getChildren().remove(btnToStep2);

            lblInfo.setText("Please, enter the information for the Shelve (" + (shelvesCreated+1) + "/" + shelvesToCreate + ")");

            txtShelvesInfo.setDisable(false);
            btnNextShelve.setDisable(false);
            txtShelfID.setDisable(false);
            txtGamesAmount.setDisable(false);
            lblInfoShelves.setDisable(false);

        }

    }

    @FXML
    void nextShelve(ActionEvent event) {
        if(shelvesCreated==shelvesToCreate-1) {
            btnNextShelve.setDisable(true);
            btnToStep3.setDisable(false);
        }
        if (shelvesCreated<shelvesToCreate) {
            createShelve();
        }
    }

    public void disableStep1() {
        lblInfo.setDisable(true);
        txtShelfID.setDisable(true);
        txtGamesAmount.setDisable(true);
        lblInfoShelves.setDisable(true);
        txtShelvesInfo.setDisable(true);
        btnToStep3.setDisable(true);
    }

    @FXML
    void toStep4() {
        createClients();
        for(int i=0;i<store.getClients().size();i++) {
            store.getClients().get(i).setTime(i+1);
            store.getClients().get(i).setEntryPosition(i+1);
        }

        for(Client client : store.getClients()) {

            ButtonType insertion = new ButtonType("Insertion Sort", ButtonBar.ButtonData.OK_DONE);
            ButtonType bubble = new ButtonType("Bubble Sort", ButtonBar.ButtonData.CANCEL_CLOSE);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Please choose how do you want to sort your games.", insertion, bubble);
            alert.setTitle("Sorting Method");
            alert.setHeaderText("Client with ID: " + client.getCode());
            Optional<ButtonType> choice = alert.showAndWait();

            int method;

            if(choice.isPresent() && choice.get() == insertion) {
                method = 1;
            } else {
                method = 2;
            }

            String message = store.orderGames(client.getCode(), method);
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setContentText(message);
            alert2.showAndWait();
        }

        store.updateTimeOfClients();
        store.decreaseAmountOfEachGame();
        store.sortClientsByTime();

        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setHeaderText("Line before paying");
        infoAlert.setContentText(store.getClients().toString());
        infoAlert.showAndWait();

        store.paymentProcess();
        store.sortClientsByTime();

        infoAlert.setHeaderText("Leaving Order");
        infoAlert.setContentText(store.fromArrayListToMyQueue());
        infoAlert.showAndWait();
    }



    @FXML
    void toStep3() {
        disableStep1();
        lblClients.setDisable(false);
        txtClients.setDisable(false);
        lblInfoClients.setDisable(false);
        txtClientsInfo.setDisable(false);
        btnToStep4.setDisable(false);
    }

    public void createShelve() {

        String shelfID = txtShelfID.getText();
        int gameAmount = Integer.parseInt(txtGamesAmount.getText());
        String[] gamesInfoList = txtShelvesInfo.getText().split("\n");
        ArrayList<Game> gamesList = new ArrayList<>();

        if(gamesInfoList.length == gameAmount && !txtShelvesInfo.getText().isEmpty()) {

            for(String gameInfo : gamesInfoList) {
                String[] gameParts = gameInfo.split(" ");
                Game game = new Game(shelfID, Integer.parseInt(gameParts[0]), Integer.parseInt(gameParts[1]), Integer.parseInt(gameParts[2]));
                gamesList.add(game);
            }

            Game[] finalGameList = new Game[gamesList.size()];
            gamesList.toArray(finalGameList);

            store.createShelves(shelfID + " " + gameAmount, finalGameList);
            shelvesCreated++;

            if(shelvesCreated!=shelvesToCreate) {
                prepareForNextShelve();
            }

        } else if (gamesInfoList.length > gameAmount){
            System.err.println("Error: Amount of games introduced exceeds the shelf game amount.");
        } else {
            System.err.println("Error: Games info missing.");
        }
    }

    private void prepareForNextShelve() {

        lblInfo.setText("Please, enter the information for the Shelve (" + (shelvesCreated+1) + "/" + shelvesToCreate + ")");
        txtShelfID.setText("");
        txtGamesAmount.setText("");
        txtShelvesInfo.setText("");

    }

    public void createClients() {

        int clientsAmount = Integer.parseInt(txtClients.getText());
        String[] clientsInfoList = txtClientsInfo.getText().split("\n");
        ArrayList<Client> clientsList = new ArrayList<>();

        if(clientsInfoList.length == clientsAmount && !txtClientsInfo.getText().isEmpty()) {

            for(String clientInfo : clientsInfoList) {
                String[] clientParts = clientInfo.split(" ");
                Client client = new Client(clientParts[0]);
                store.getClients().add(client);
                client.createGames(clientParts);
            }

        } else if (clientsInfoList.length > clientsAmount){
            System.err.println("Error: Amount of clients introduced exceeds the client amount.");
        } else {
            System.err.println("Error: Clients info missing.");
        }
    }


}
