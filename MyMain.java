package com.aryan.TemperatureConverter;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyMain extends Application {

    private Controller controller = new Controller();

    public static void main (String[] args){
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init");
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        System.out.println("Start");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();

        controller = loader.getController();

        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0, menuBar);

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter");
        primaryStage.show();
    }

    private MenuBar createMenu(){

        //File menu
        Menu fileMenu = new Menu("File");

        MenuItem newMenuItem = new MenuItem("New");
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem quitMenuItem  = new MenuItem("Quit");

        fileMenu.getItems().addAll(newMenuItem, separatorMenuItem ,quitMenuItem);

        newMenuItem.setOnAction(actionEvent -> {newMenuOption();});

        quitMenuItem.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);
        });

        //Help menu
        Menu helpMenu = new Menu("Help");

        MenuItem aboutMenuItem = new MenuItem("About App");
        MenuItem aboutDeveloperMenuIteam = new MenuItem("About Developer");
        helpMenu.getItems().addAll(aboutMenuItem, aboutDeveloperMenuIteam);

        aboutMenuItem.setOnAction(actionEvent ->{aboutApp();});
        aboutDeveloperMenuIteam.setOnAction(actionEvent -> {aboutDeveloper();});

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        return menuBar;
    }

    private void newMenuOption() {
        controller.tempTextField.setText(null);
    }

    private void aboutDeveloper() {
        Alert alertAboutBox = new Alert(Alert.AlertType.INFORMATION);
        alertAboutBox.setTitle("About Developer");
        alertAboutBox.setHeaderText("Aryan Sahu");
        alertAboutBox.setContentText("I love to play around with code and create games. Connect 4 is one of them. In free time I like to spend time with nears and dears.");
        alertAboutBox.show();
        alertAboutBox.getDialogPane().setMinHeight(400);
    }

    public static void aboutApp(){
        Alert alertAboutBox = new Alert(Alert.AlertType.INFORMATION);
        alertAboutBox.setTitle("Help");
        alertAboutBox.setHeaderText("How to use?");
        alertAboutBox.setContentText("Just write a temperature on given box and choose the option in which you want to convert. ");
        alertAboutBox.show();
        alertAboutBox.getDialogPane().setMinHeight(400);
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Stop");
        super.stop();
    }
}