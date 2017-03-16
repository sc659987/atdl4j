package org.atdl4j.ui.swing.app.impl;

import org.apache.log4j.Logger;
import org.atdl4j.config.Atdl4jOptions;
import org.atdl4j.config.StrategyFilterInputData;
import org.atdl4j.data.Atdl4jConstants;
import org.atdl4j.ui.app.impl.AbstractAtdl4jInputAndFilterDataPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Represents the Swing-specific Atdl4jOptions and InputAndFilterData GUI component.
 *
 * @author Scott Atwell
 * @version 1.0, Mar 1, 2010
 */
public class SwingAtdl4jInputAndFilterDataPanel
        extends AbstractAtdl4jInputAndFilterDataPanel {
    public final Logger logger = Logger.getLogger(SwingAtdl4jInputAndFilterDataPanel.class);

    private JDialog parentDialog;

    private JComboBox<String> strategyFilterFixMsgTypeCombo;
    private JCheckBox checkboxInputCxlReplaceMode;
    private JComboBox<String> strategyFilterRegionCombo;
    private JComboBox<String> strategyFilterCountryCombo;
    private JComboBox<String> strategyFilterMICCodeCombo;
    private JComboBox<String> strategyFilterSecurityTypeCombo;

    private JComboBox<String> fixFieldOrdTypeCombo;
    private JComboBox<String> fixFieldSideCombo;
    private JComboBox<String> fixFieldOrderQtyCombo;
    private JComboBox<String> fixFieldPriceCombo;
    private JComboBox<String> fixFieldHandlInstCombo;
    private JComboBox<String> fixFieldExecCombo;
    private JComboBox<String> fixFieldTimeInForceCombo;
    private JComboBox<String> fixFieldClOrdLinkIDCombo;


    /* (non-Javadoc)
     * @see org.atdl4j.ui.app.Atdl4jInputAndFilterDataPanel#buildAtdl4jInputAndFilterDataPanel(java.lang.Object, org.atdl4j.config.Atdl4jOptions)
     */
    @Override
    public Object buildAtdl4jInputAndFilterDataPanel(Object aParentOrShell, Atdl4jOptions aAtdl4jOptions) {
        return buildAtdl4jInputAndFilterDataPanel((JDialog) aParentOrShell, aAtdl4jOptions);
    }

    public JDialog buildAtdl4jInputAndFilterDataPanel(JDialog aParentOrShell, Atdl4jOptions aAtdl4jOptions) {
        parentDialog = (JDialog) aParentOrShell;

        // -- Delegate back to AbstractAtdl4jInputAndFilterDataPanel --
        init(aParentOrShell, aAtdl4jOptions);

        // -- Build the Swing.JPanel from Atdl4jCompositePanel --
        buildCoreAtdl4jSettingsPanel(aParentOrShell);

        return parentDialog;
    }

    protected JPanel buildCoreAtdl4jSettingsPanel(JDialog aParentOrShell) {
        JPanel tempPanel = new JPanel(new BorderLayout());

        tempPanel.add(buildStrategyFilterPanel(), BorderLayout.NORTH);
        tempPanel.add(buildStandardFixFieldsPanel(), BorderLayout.CENTER);

        aParentOrShell.add(tempPanel);

        return tempPanel;
    }

    protected JPanel buildStrategyFilterPanel() {
        JPanel strategyFilterPanel = new JPanel();
        strategyFilterPanel.setLayout(new BoxLayout(strategyFilterPanel, BoxLayout.Y_AXIS));
        strategyFilterPanel.setBorder(BorderFactory.createTitledBorder(STRATEGY_FILTER_PANEL_NAME));

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("FixMsgType:"));
        strategyFilterFixMsgTypeCombo = new JComboBox<String>(prepareContantsForGUI(Atdl4jConstants.STRATEGY_FILTER_FIX_MSG_TYPES));
        strategyFilterFixMsgTypeCombo.setMaximumRowCount(DEFAULT_DROP_DOWN_VISIBLE_ITEM_COUNT);
        panel1.add(strategyFilterFixMsgTypeCombo);

        checkboxInputCxlReplaceMode = new JCheckBox("Cxl Replace Mode");
        panel1.add(checkboxInputCxlReplaceMode);

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Region:"));
        strategyFilterRegionCombo = new JComboBox<String>(prepareContantsForGUI(Atdl4jConstants.STRATEGY_FILTER_REGIONS));
        strategyFilterRegionCombo.setMaximumRowCount(DEFAULT_DROP_DOWN_VISIBLE_ITEM_COUNT);
        panel2.add(strategyFilterRegionCombo);

        panel2.add(new JLabel("Country:"));
        strategyFilterCountryCombo = new JComboBox<String>(DEFAULT_STRATEGY_FILTER_COUNTRY_SUBSET_LIST);
        strategyFilterCountryCombo.setEditable(true);
        strategyFilterCountryCombo.setMaximumRowCount(DEFAULT_DROP_DOWN_VISIBLE_ITEM_COUNT);
        panel2.add(strategyFilterCountryCombo);

        panel2.add(new JLabel("MIC Code:"));
        strategyFilterMICCodeCombo = new JComboBox<String>(DEFAULT_STRATEGY_FILTER_MIC_CODE_SUBSET_LIST);
        strategyFilterMICCodeCombo.setEditable(true);
        strategyFilterMICCodeCombo.setMaximumRowCount(DEFAULT_DROP_DOWN_VISIBLE_ITEM_COUNT);
        panel2.add(strategyFilterMICCodeCombo);

        panel2.add(new JLabel("Security Type:"));
        strategyFilterSecurityTypeCombo = new JComboBox<String>(prepareContantsForGUI(Atdl4jConstants.STRATEGY_FILTER_SECURITY_TYPES));
        strategyFilterSecurityTypeCombo.setEditable(true);
        strategyFilterSecurityTypeCombo.setMaximumRowCount(DEFAULT_DROP_DOWN_VISIBLE_ITEM_COUNT);
        panel2.add(strategyFilterSecurityTypeCombo);

        strategyFilterPanel.add(panel1);
        strategyFilterPanel.add(panel2);

        return strategyFilterPanel;
    }

    protected JPanel buildStandardFixFieldsPanel() {
        JPanel standardFixFieldsPanel = new JPanel(new GridLayout(8, 2));
        standardFixFieldsPanel.setBorder(BorderFactory.createTitledBorder(STANDARD_FIX_FIELDS_PANEL_NAME));

        standardFixFieldsPanel.add(new JLabel("OrdType:"));
        fixFieldOrdTypeCombo = new JComboBox<String>(DEFAULT_FIX_FIELD_ORD_TYPE_SUBSET_LIST);
        fixFieldOrdTypeCombo.setEditable(true);
        fixFieldOrdTypeCombo.setMaximumRowCount(DEFAULT_DROP_DOWN_VISIBLE_ITEM_COUNT);
        standardFixFieldsPanel.add(fixFieldOrdTypeCombo);

        standardFixFieldsPanel.add(new JLabel("Side:"));
        fixFieldSideCombo = new JComboBox<String>(DEFAULT_FIX_FIELD_SIDE_SUBSET_LIST);
        fixFieldSideCombo.setEditable(true);
        fixFieldSideCombo.setMaximumRowCount(DEFAULT_DROP_DOWN_VISIBLE_ITEM_COUNT);
        standardFixFieldsPanel.add(fixFieldSideCombo);

        standardFixFieldsPanel.add(new JLabel("OrderQty:"));
        fixFieldOrderQtyCombo = new JComboBox<String>(DEFAULT_FIX_FIELD_ORDER_QTY_SUBSET_LIST);
        fixFieldOrderQtyCombo.setEditable(true);
        fixFieldOrderQtyCombo.setMaximumRowCount(DEFAULT_DROP_DOWN_VISIBLE_ITEM_COUNT);
        standardFixFieldsPanel.add(fixFieldOrderQtyCombo);

        standardFixFieldsPanel.add(new JLabel("Price:"));
        fixFieldPriceCombo = new JComboBox<String>(DEFAULT_FIX_FIELD_PRICE_SUBSET_LIST);
        fixFieldPriceCombo.setEditable(true);
        fixFieldPriceCombo.setMaximumRowCount(DEFAULT_DROP_DOWN_VISIBLE_ITEM_COUNT);
        standardFixFieldsPanel.add(fixFieldPriceCombo);

        standardFixFieldsPanel.add(new JLabel("HandlInst:"));
        fixFieldHandlInstCombo = new JComboBox<String>(DEFAULT_FIX_FIELD_HANDL_INST_SUBSET_LIST);
        fixFieldHandlInstCombo.setEditable(true);
        fixFieldHandlInstCombo.setMaximumRowCount(DEFAULT_DROP_DOWN_VISIBLE_ITEM_COUNT);
        standardFixFieldsPanel.add(fixFieldHandlInstCombo);

        standardFixFieldsPanel.add(new JLabel("ExecInst:"));
        fixFieldExecCombo = new JComboBox<String>(DEFAULT_FIX_FIELD_EXEC_INST_SUBSET_LIST);
        fixFieldExecCombo.setEditable(true);
        fixFieldExecCombo.setMaximumRowCount(DEFAULT_DROP_DOWN_VISIBLE_ITEM_COUNT);
        standardFixFieldsPanel.add(fixFieldExecCombo);

        standardFixFieldsPanel.add(new JLabel("TimeInForce:"));
        fixFieldTimeInForceCombo = new JComboBox<String>(DEFAULT_FIX_FIELD_TIME_IN_FORCE_SUBSET_LIST);
        fixFieldTimeInForceCombo.setEditable(true);
        fixFieldTimeInForceCombo.setMaximumRowCount(DEFAULT_DROP_DOWN_VISIBLE_ITEM_COUNT);
        standardFixFieldsPanel.add(fixFieldTimeInForceCombo);

        standardFixFieldsPanel.add(new JLabel("ClOrdLinkID:"));
        fixFieldClOrdLinkIDCombo = new JComboBox<String>(DEFAULT_FIX_FIELD_CL_ORD_LINK_ID_SUBSET_LIST);
        fixFieldClOrdLinkIDCombo.setEditable(true);
        fixFieldClOrdLinkIDCombo.setMaximumRowCount(DEFAULT_DROP_DOWN_VISIBLE_ITEM_COUNT);
        standardFixFieldsPanel.add(fixFieldClOrdLinkIDCombo);

        return standardFixFieldsPanel;
    }

    /* (non-Javadoc)
     * @see org.atdl4j.ui.app.Atdl4jInputAndFilterDataPanel#extractAtdl4jOptionsFromScreen()
     */
    @Override
    public boolean extractAtdl4jOptionsFromScreen() {
        StrategyFilterInputData tempStrategyFilterInputData = new StrategyFilterInputData();

        tempStrategyFilterInputData.setFixMsgType(getDropDownItemSelected(strategyFilterFixMsgTypeCombo));
        tempStrategyFilterInputData.setRegion_name(getDropDownItemSelected(strategyFilterRegionCombo));
        tempStrategyFilterInputData.setCountry_CountryCode(getDropDownItemSelected(strategyFilterCountryCombo));
        if ((tempStrategyFilterInputData.getCountry_CountryCode() != null) &&
                (tempStrategyFilterInputData.getRegion_name() == null)) {
            throw new IllegalArgumentException("Region is required when Country is specified.");
        }

        tempStrategyFilterInputData.setMarket_MICCode(getDropDownItemSelected(strategyFilterMICCodeCombo));
        tempStrategyFilterInputData.setSecurityType_name(getDropDownItemSelected(strategyFilterSecurityTypeCombo));

        // -- Set the StrategyFilterInputData we just built --
        getAtdl4jOptions().getInputAndFilterData().setStrategyFilterInputData(tempStrategyFilterInputData);

        getAtdl4jOptions().getInputAndFilterData().setInputCxlReplaceMode(checkboxInputCxlReplaceMode.isSelected());

        addFixFieldToInputAndFilterData(FIX_FIELD_NAME_ORD_TYPE, fixFieldOrdTypeCombo);
        addFixFieldToInputAndFilterData(FIX_FIELD_NAME_SIDE, fixFieldSideCombo);
        addFixFieldToInputAndFilterData(FIX_FIELD_NAME_ORDER_QTY, fixFieldOrderQtyCombo);
        addFixFieldToInputAndFilterData(FIX_FIELD_NAME_PRICE, fixFieldPriceCombo);
        addFixFieldToInputAndFilterData(FIX_FIELD_NAME_HANDL_INST, fixFieldHandlInstCombo);
        addFixFieldToInputAndFilterData(FIX_FIELD_NAME_EXEC_INST, fixFieldExecCombo);
        addFixFieldToInputAndFilterData(FIX_FIELD_NAME_TIME_IN_FORCE, fixFieldTimeInForceCombo);
        addFixFieldToInputAndFilterData(FIX_FIELD_NAME_CL_ORD_LINK_ID, fixFieldClOrdLinkIDCombo);

        return true;
    }

    /* (non-Javadoc)
     * @see org.atdl4j.ui.app.Atdl4jInputAndFilterDataPanel#loadScreenWithAtdl4jOptions()
     */
    @Override
    public boolean loadScreenWithAtdl4jOptions() {

        if (getAtdl4jOptions().getInputAndFilterData() != null) {
            StrategyFilterInputData tempStrategyFilterInputData = null;
            if ((getAtdl4jOptions().getInputAndFilterData().getStrategyFilterInputDataList() != null) &&
                    (getAtdl4jOptions().getInputAndFilterData().getStrategyFilterInputDataList().size() > 0)) {
                tempStrategyFilterInputData = getAtdl4jOptions().getInputAndFilterData().getStrategyFilterInputDataList().get(0);
            }

            String tempFixMsgType = null;
            String tempRegion_name = null;
            String tempCountry_CountryCode = null;
            String tempMarket_MICCode = null;
            String tempSecurityType_name = null;

            if (tempStrategyFilterInputData != null) {
                tempFixMsgType = tempStrategyFilterInputData.getFixMsgType();
                tempRegion_name = tempStrategyFilterInputData.getRegion_name();
                tempCountry_CountryCode = tempStrategyFilterInputData.getCountry_CountryCode();
                tempMarket_MICCode = tempStrategyFilterInputData.getMarket_MICCode();
                tempSecurityType_name = tempStrategyFilterInputData.getSecurityType_name();
            }

            selectDropDownItem(strategyFilterFixMsgTypeCombo, tempFixMsgType);
            selectDropDownItem(strategyFilterRegionCombo, tempRegion_name);
            selectDropDownItem(strategyFilterCountryCombo, tempCountry_CountryCode);
            selectDropDownItem(strategyFilterMICCodeCombo, tempMarket_MICCode);
            selectDropDownItem(strategyFilterSecurityTypeCombo, tempSecurityType_name);

            setCheckboxValue(checkboxInputCxlReplaceMode, getAtdl4jOptions().getInputAndFilterData().getInputCxlReplaceMode(), Boolean.FALSE);

            selectDropDownItem(fixFieldOrdTypeCombo, getAtdl4jOptions().getInputAndFilterData().getInputHiddenFieldValue(FIX_FIELD_NAME_ORD_TYPE));
            selectDropDownItem(fixFieldSideCombo, getAtdl4jOptions().getInputAndFilterData().getInputHiddenFieldValue(FIX_FIELD_NAME_SIDE));
            selectDropDownItem(fixFieldOrderQtyCombo, getAtdl4jOptions().getInputAndFilterData().getInputHiddenFieldValue(FIX_FIELD_NAME_ORDER_QTY));
            selectDropDownItem(fixFieldPriceCombo, getAtdl4jOptions().getInputAndFilterData().getInputHiddenFieldValue(FIX_FIELD_NAME_PRICE));
            selectDropDownItem(fixFieldHandlInstCombo, getAtdl4jOptions().getInputAndFilterData().getInputHiddenFieldValue(FIX_FIELD_NAME_HANDL_INST));
            selectDropDownItem(fixFieldExecCombo, getAtdl4jOptions().getInputAndFilterData().getInputHiddenFieldValue(FIX_FIELD_NAME_EXEC_INST));
            selectDropDownItem(fixFieldTimeInForceCombo, getAtdl4jOptions().getInputAndFilterData().getInputHiddenFieldValue(FIX_FIELD_NAME_TIME_IN_FORCE));
            selectDropDownItem(fixFieldClOrdLinkIDCombo, getAtdl4jOptions().getInputAndFilterData().getInputHiddenFieldValue(FIX_FIELD_NAME_CL_ORD_LINK_ID));
            return true;
        } else {
            return false;
        }
    }

    public static void setCheckboxValue(JCheckBox aCheckbox, Boolean aValue, boolean aStateIfNull) {
        if (aValue == null) {
            aCheckbox.setSelected(aStateIfNull);
        } else {
            aCheckbox.setSelected(aValue);
        }
    }

    public static String getDropDownItemSelected(JComboBox<String> aDropDown) {
        String tempText = (String) aDropDown.getSelectedItem();
        if ("".equals(tempText)) {
            return null;
        } else {
            return tempText;
        }
    }

    public static void selectDropDownItem(JComboBox<String> aDropDown, String aItem) {
        if (aItem != null) {
            aDropDown.setSelectedItem(aItem);
        } else {
            aDropDown.setSelectedIndex(-1);
        }
    }

    protected void addFixFieldToInputAndFilterData(String aFieldName, JComboBox<String> aDropDown) {
        String tempFieldValue = getDropDownItemSelected(aDropDown);
        if (tempFieldValue != null) {
            // -- Add/update it --
            getAtdl4jOptions().getInputAndFilterData().setInputHiddenFieldNameValuePair(aFieldName, tempFieldValue);
        } else {
            if ((getAtdl4jOptions() != null) &&
                    (getAtdl4jOptions().getInputAndFilterData() != null) &&
                    (getAtdl4jOptions().getInputAndFilterData().getInputHiddenFieldNameValueMap() != null)) {
                // -- Attempt to remove it if it exists --
                getAtdl4jOptions().getInputAndFilterData().getInputHiddenFieldNameValueMap().remove(aFieldName);
            }
        }
    }

    private String[] prepareContantsForGUI(String[] constants) {
        if (constants.length == 0) {
            return constants;
        }
        String[] val = new String[constants.length + 1];
        val[0] = "";

        for (int i = 0; i < constants.length; i++) {
            val[i + 1] = constants[i];
        }
        return val;
    }

}
