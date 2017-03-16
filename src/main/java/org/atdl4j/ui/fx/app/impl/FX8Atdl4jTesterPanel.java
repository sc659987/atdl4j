package org.atdl4j.ui.fx.app.impl;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import org.apache.log4j.Logger;
import org.atdl4j.config.Atdl4jOptions;
import org.atdl4j.ui.app.StrategySelectionEvent;
import org.atdl4j.ui.app.impl.AbstractAtdl4jTesterPanel;


/**
 * Created by sainik on 3/16/17.
 */
public class FX8Atdl4jTesterPanel extends AbstractAtdl4jTesterPanel {

    public final Logger logger = Logger.getLogger(FX8Atdl4jTesterPanel.class);

    private Scene parentComposite;

    private HBox inputAndFilterDataAndLoadMessageBox;
    private HBox selectFile;

    private HBox validateBox;
    private HBox okCancelBox;



    @Override
    public Object buildAtdl4jTesterPanel(Object aParentOrShell, Atdl4jOptions aAtdl4jOptions) {
        if (!(aParentOrShell instanceof Scene))
            // TODO decide whether to throw exception or return null
            return null;
        this.parentComposite = (Scene) aParentOrShell;
        // TODO init the screen.
        init(this.parentComposite, aAtdl4jOptions);
        return null;
    }


    @Override
    public void closePanel() {

    }

    @Override
    public void setVisibleOkCancelButtonSection(boolean aVisible) {

    }

    @Override
    public void beforeStrategyIsSelected(StrategySelectionEvent event) {

    }

    @Override
    protected Object createValidateOutputSection() {
        return null;
    }

    @Override
    protected void setValidateOutputText(String aText) {

    }

    @Override
    public void setVisibleValidateOutputSection(boolean aVisible) {

    }

    @Override
    public void setVisibleFileSelectionSection(boolean aVisible) {

    }

    @Override
    public void setVisibleTestingInputSection(boolean aVisible) {

    }
}
