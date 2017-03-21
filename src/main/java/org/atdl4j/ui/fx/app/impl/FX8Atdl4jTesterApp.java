package org.atdl4j.ui.fx.app.impl;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.atdl4j.ui.app.Atdl4jTesterPanelListener;

import java.io.File;
import java.net.URL;


public class FX8Atdl4jTesterApp extends Application implements Atdl4jTesterPanelListener {

    public final Logger logger = Logger.getLogger(FX8Atdl4jTesterApp.class);
    //Atdl4jOptions atdl4jOptions = new Atdl4jOptions();
    private FileChooser fileChooser = new FileChooser();
    private Button selectAltdButton, buttonOK, buttonCancel;
    private Text selectedFilePath;

    {
        fileChooser.setTitle("Select Atdl file");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Xml file", "*.xml"));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(getTestBaseScene(primaryStage));
        primaryStage.setTitle("Atdl4j FX8 Test Interface");
        primaryStage.show();
    }

    private Scene getTestBaseScene(final Stage stage) {
        BorderPane borderLayout = new BorderPane();
        HBox hBoxTop = new HBox(50);
        hBoxTop.setAlignment(Pos.CENTER);
        hBoxTop.getStyleClass().add("hbox");
        hBoxTop.setId("hbox-custom");
        this.selectAltdButton = new Button();
        this.selectAltdButton.setText("Select ALDT file");
        this.selectAltdButton.setOnAction(event -> {
                    File file = fileChooser.showOpenDialog(stage);
                    if (file != null) {
                        this.selectedFilePath.setText(file.getAbsolutePath());
                    }
                }
        );

        hBoxTop.getChildren().add(selectAltdButton);

        this.selectedFilePath = new Text();
        this.selectedFilePath.setText("No file is Selected");
        hBoxTop.getChildren().add(this.selectedFilePath);
        borderLayout.setTop(hBoxTop);

        HBox hBoxDown = new HBox();
        this.buttonOK = new Button("Ok");
        this.buttonOK.setOnAction(event -> {
        });
        this.buttonCancel = new Button("Cancel");
        this.buttonCancel.setOnAction(event -> {
            Platform.exit();
        });
        hBoxDown.getChildren().addAll(this.buttonOK, this.buttonCancel);
        hBoxDown.setAlignment(Pos.CENTER);
        hBoxDown.getStyleClass().add("hbox");
        hBoxDown.setId("hbox-custom");
        borderLayout.setBottom(hBoxDown);
        Scene scene = new Scene(borderLayout, 500, 500);
        URL url = this.getClass().getResource("/fx8atdl4jtesterapp.css");
        scene.getStylesheets().add(url.toExternalForm());
        return scene;
    }

    @Override
    public void okButtonSelected() {

    }

    @Override
    public void cancelButtonSelected() {

    }

    public static void main(String[] args) throws Exception {

        //Atdl4jConfiguration config = new FX8Atdl4jConfiguration();
        //FX8Atdl4jTesterApp fx8Atdl4jTesterApp = new FX8Atdl4jTesterApp();
        launch(args);

    }


}
