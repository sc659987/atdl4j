package org.atdl4j.ui.fx.config;

import org.atdl4j.config.AbstractAtdl4jConfiguration;

/**
 * Created by sainik on 3/16/17.
 */
public class FX8Atdl4jConfiguration extends AbstractAtdl4jConfiguration {

    private static String PACKAGE_PATH_ORG_ATDL4J_UI_FX = "org.atdl4j.ui.fx.";

    public FX8Atdl4jConfiguration() {
        super();
    }

    protected String getDefaultClassNameStrategiesUI() {
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "impl.FX8StrategiesUI";
    }

    protected String getDefaultClassNameStrategyUI() {
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "impl.FX8StrategyUI";
    }

    protected String getDefaultClassNameFixatdlFileSelectionPanel() {
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "app.impl.FX8FixatdlFileSelectionPanel";
    }

    protected String getDefaultClassNameFixMsgLoadPanel() {
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "app.impl.FX8FixMsgLoadPanel";
    }

    protected String getDefaultClassNameStrategySelectionPanel() {
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "app.impl.FX8StrategySelectionPanel";
    }

    protected String getDefaultClassNameStrategyDescriptionPanel() {
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "app.impl.FX8StrategyDescriptionPanel";
    }

    protected String getDefaultClassNameAtdl4jTesterPanel() {
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "app.impl.FX8Atdl4jTesterPanel";
    }

    protected String getDefaultClassNameAtdl4jInputAndFilterDataSelectionPanel() {
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "app.impl.FX8Atdl4jInputAndFilterDataSelectionPanel";
    }

    protected String getDefaultClassNameAtdl4jInputAndFilterDataPanel() {
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "app.impl.FX8Atdl4jInputAndFilterDataPanel";
    }

    protected String getDefaultClassNameAtdl4jCompositePanel() {
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "app.impl.FX8Atdl4jCompositePanel";
    }

    protected String getDefaultClassNameAtdl4jUserMessageHandler() {
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "app.impl.FX8Atdl4jUserMessageHandler";
    }

    protected String getDefaultClassNameAtdl4jWidgetForCheckBoxListT() {
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "widget.FX8CheckBoxListWidget";
    }

    protected String getDefaultClassNameAtdl4jWidgetForCheckBoxT() {
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "widget.FX8ButtonWidget";
    }

    protected String getDefaultClassNameAtdl4jWidgetForClockT() {
//		return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "widget.FX8ClockWidget";
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "widget.FX8JideClockWidget";
    }

    protected String getDefaultClassNameAtdl4jWidgetForDoubleSpinnerT() {
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "widget.FX8SpinnerWidget";
    }

    protected String getDefaultClassNameAtdl4jWidgetForDropDownListT() {
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "widget.FX8DropDownListWidget";
    }

    protected String getDefaultClassNameAtdl4jWidgetForEditableDropDownListT() {
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "widget.FX8DropDownListWidget";
    }

    protected String getDefaultClassNameAtdl4jWidgetForHiddenFieldT() {
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "widget.FX8HiddenFieldWidget";
    }

    protected String getDefaultClassNameAtdl4jWidgetForLabelT() {
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "widget.FX8LabelWidget";
    }

    protected String getDefaultClassNameAtdl4jWidgetForMultiSelectListT() {
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "widget.FX8ListBoxWidget";
    }

    protected String getDefaultClassNameAtdl4jWidgetForRadioButtonListT() {
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "widget.FX8RadioButtonListWidget";
    }

    protected String getDefaultClassNameAtdl4jWidgetForRadioButtonT() {
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "widget.FX8ButtonWidget";
    }

    protected String getDefaultClassNameAtdl4jWidgetForSingleSelectListT() {
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "widget.FX8ListBoxWidget";
    }

    protected String getDefaultClassNameAtdl4jWidgetForSingleSpinnerT() {
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "widget.FX8SpinnerWidget";
    }

    protected String getDefaultClassNameAtdl4jWidgetForSliderT() {
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "widget.FX8SliderWidget";
    }

    protected String getDefaultClassNameAtdl4jWidgetForTextFieldT() {
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "widget.FX8TextFieldWidget";
    }

    protected String getDefaultClassNameStrategyPanelHelper() {
        return PACKAGE_PATH_ORG_ATDL4J_UI_FX + "impl.FX8StrategyPanelHelper";
    }
}
