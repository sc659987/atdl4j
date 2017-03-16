package org.atdl4j.ui.app;

import org.atdl4j.config.Atdl4jOptions;
import org.atdl4j.data.exception.Atdl4jClassLoadException;
import org.atdl4j.data.exception.FIXatdlFormatException;
import org.atdl4j.data.exception.ValidationException;
import org.atdl4j.fixatdl.core.StrategiesT;
import org.atdl4j.fixatdl.core.StrategyT;
import org.atdl4j.ui.StrategiesUI;
import org.atdl4j.ui.impl.SelectedStrategyDetails;

import java.util.List;

/**
 * Represents the core strategy selection and display GUI component.
 * <p>
 * <p>
 * [as of March 4, 2010 @author Scott Atwell] "SWTApplication" refactoring - rename, overhaul, and layered
 * <p>
 * Interfaces:
 * -----------
 * - org.atdl4j.ui.app.Atdl4jTesterPanel
 * - org.atdl4j.ui.app.Atdl4jInputAndFilterDataSelectionPanel
 * - org.atdl4j.ui.app.Atdl4jInputAndFilterDataPanel
 * - org.atdl4j.ui.app.FixMsgLoadPanel
 * - org.atdl4j.ui.app.Atdl4jCompositePanel
 * - org.atdl4j.ui.app.FixatdlFileSelectionPanel
 * - org.atdl4j.ui.app.StrategySelectionPanel
 * - org.atdl4j.ui.app.StrategyDescriptionPanel
 * - org.atdl4j.ui.app.StrategiesPanel
 * <p>
 * Non-UI-specific abstract base implementation:
 * ---------------------------------------------
 * - org.atdl4j.ui.app.AbstractAtdl4jTesterApp
 * - org.atdl4j.ui.app.AbstractAtdl4jTesterPanel
 * - org.atdl4j.ui.app.AbstractAtdl4jInputAndFilterDataSelectionPanel
 * - org.atdl4j.ui.app.AbstractAtdl4jInputAndFilterDataPanel
 * - org.atdl4j.ui.app.AbstractFixMsgLoadPanel
 * - org.atdl4j.ui.app.AbstractAtdl4jCompositePanel
 * - org.atdl4j.ui.app.AbstractFixatdlFileSelectionPanel
 * - org.atdl4j.ui.app.AbstractStrategySelectionPanel
 * - org.atdl4j.ui.app.AbstractStrategyDescriptionPanel
 * - org.atdl4j.ui.app.AbstractStrategiesUI
 * <p>
 * SWT-specific implementation:
 * ----------------------------
 * - org.atdl4j.ui.swt.app.SWTAtdl4jTesterApp
 * - org.atdl4j.ui.swt.app.SWTAtdl4jTesterPanel
 * - org.atdl4j.ui.swt.app.SWTAtdl4jInputAndFilterDataSelectionPanel
 * - org.atdl4j.ui.swt.app.SWTAtdl4jInputAndFilterDataPanel
 * - org.atdl4j.ui.swt.app.SWTFixMsgLoadPanel
 * - org.atdl4j.ui.swt.app.SWTAtdl4jCompositePanel
 * - org.atdl4j.ui.swt.app.SWTFixatdlFileSelectionPanel
 * - org.atdl4j.ui.swt.app.SWTStrategySelectionPanel
 * - org.atdl4j.ui.swt.app.SWTStrategyDescriptionPanel
 * - org.atdl4j.ui.swt.app.SWTStrategiesPanel
 * <p>
 * Listeners:
 * ----------
 * - org.atdl4j.ui.app.Atdl4jInputAndFilterDataPanelListener
 * - org.atdl4j.ui.app.FixMsgLoadPanelListener
 * - org.atdl4j.ui.app.FixatdlFileSelectionPanelListener
 * - org.atdl4j.ui.app.StrategySelectionPanelListener
 * - org.atdl4j.ui.app.StrategiesUIListener
 * <p>
 * Pop-up message handler:
 * -----------------------
 * - org.atdl4j.ui.app.Atdl4jUserMessageHandler
 * - org.atdl4j.ui.app.AbstractAtdl4jUserMessageHandler
 * - org.atdl4j.ui.swt.app.SWTAtdl4jUserMessageHandler
 * <p>
 * Config:
 * -------
 * - org.atdl4j.config.Atdl4jOptions
 * - org.atdl4j.config.AbstractAtdl4jOptions
 * - org.atdl4j.ui.swt.config.SWTAtdl4jOptions
 * - org.atdl4j.config.InputAndFilterData
 *
 * @author Scott Atwell
 * @version 1.0, Feb 28, 2010
 */
public interface Atdl4jCompositePanel {

    Object buildAtdl4jCompositePanel(Object aParentOrShell, Atdl4jOptions aAtdl4jOptions);

    Atdl4jOptions getAtdl4jOptions();

    /*
     * Parses the FIXatdl file aFilename into StrategiesT storing the result via Atdl4jOptions().setStrategies().
     */
    void parseFixatdlFile(String aFilename) throws FIXatdlFormatException;

    /**
     * Can be invoked/re-invoked at anytime provided that parseFixatdlFile() has successfully parsed the
     * FIXatdl file contents into Atdl4jOptions().setStrategies().  Re-generates the display.
     *
     * @throws Atdl4jClassLoadException
     * @throws FIXatdlFormatException
     */
    void loadScreenWithFilteredStrategies() throws FIXatdlFormatException;

    boolean loadFixMessage(String aFixMessage);

    boolean loadScreenWithFilteredStrategiesAndLoadFixMessage(String aFixMessage);

    boolean loadScreenWithFilteredStrategiesAndLoadFixMessage(String aFixMessage, String aInputSelectStrategyName) throws FIXatdlFormatException;

    /*
     * @return StrategyT (non-null only if passes all validation)
     */
    StrategyT validateStrategy() throws ValidationException;

    void setVisibleOkCancelButtonSection(boolean aVisible);

    void addListener(Atdl4jCompositePanelListener aAtdl4jCompositePanelListener);

    void removeListener(Atdl4jCompositePanelListener aAtdl4jCompositePanelListener);

    StrategiesT getStrategies();

    void setStrategies(StrategiesT strategies);

    List<StrategyT> getStrategiesFilteredStrategyList();

    StrategyT getSelectedStrategy();

    void setSelectedStrategy(StrategyT selectedStrategy);

    boolean isSelectedStrategyValidated();

    void setSelectedStrategyValidated(boolean aSelectedStrategyValidated);

    StrategiesUI getStrategiesUI();

    Atdl4jUserMessageHandler getAtdl4jUserMessageHandler();

    void initAtdl4jUserMessageHandler(Object parentOrShell);

    void setStrategyEventListener(StrategyEventListener aStrategyEventListener);

    SelectedStrategyDetails getSelectedStrategyDetails(boolean aPerformValidationFlag)
            throws ValidationException;

    void setEditable(boolean editable);


}
