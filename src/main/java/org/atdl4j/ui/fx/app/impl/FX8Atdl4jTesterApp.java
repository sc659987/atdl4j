package org.atdl4j.ui.fx.app.impl;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.atdl4j.config.Atdl4jConfiguration;
import org.atdl4j.config.Atdl4jOptions;
import org.atdl4j.ui.app.impl.AbstractAtdl4jTesterApp;
import org.atdl4j.ui.fx.config.FX8Atdl4jConfiguration;

/**
 * Created by sainik on 3/16/17.
 */
public class FX8Atdl4jTesterApp extends AbstractAtdl4jTesterApp {
    public final Logger logger = Logger.getLogger(FX8Atdl4jTesterApp.class);

    public static void main(String[] args) throws Exception {

        Atdl4jConfiguration config = new FX8Atdl4jConfiguration();
        FX8Atdl4jTesterApp fx8Atdl4jTesterApp = new FX8Atdl4jTesterApp();
        fx8Atdl4jTesterApp.mainLine(args, config);

    }

    public void mainLine(String[] args, Atdl4jConfiguration config) {

        final Scene scene = new Scene(new Pane(), 500, 500);
        Atdl4jOptions atdl4jOptions = new Atdl4jOptions();
        atdl4jOptions.setShowDateInputOnTimestampClockControl(true);
        init(args, config, atdl4jOptions, scene);

        getAtdl4jTesterPanel().buildAtdl4jTesterPanel(scene, getAtdl4jOptions());

        new Application() {
            @Override
            public void start(Stage primaryStage) throws Exception {
                primaryStage.setScene(scene);
                primaryStage.setTitle("Atdl4j FX8 Test Interface");
                primaryStage.setScene(scene);
                primaryStage.show();
            }
        }.launch(args);


    }


}
