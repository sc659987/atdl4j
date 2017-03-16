package org.atdl4j.ui.swing.widget;

import org.atdl4j.ui.impl.ControlHelper;
import org.atdl4j.ui.swing.SwingListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SwingTextFieldWidget
        extends AbstractSwingWidget<String> {
    private JFormattedTextField textField;
    private JLabel label;
    private JPanel wrapper;

    public void createWidget(JPanel parent) {
        // tooltip
        String tooltip = control.getTooltip();

        // label
        if (control.getLabel() != null) {
            label = new JLabel();
            label.setName(getName() + "/label");
            label.setText(control.getLabel());
            if (tooltip != null) label.setToolTipText(tooltip);
        }

        // textField
        textField = new JFormattedTextField();
        textField.setName(getName() + "/text");

        // init value
        if (ControlHelper.getInitValue(control, getAtdl4jOptions()) != null)
            textField.setText((String) ControlHelper.getInitValue(control, getAtdl4jOptions()));

        // tooltip
        if (tooltip != null) textField.setToolTipText(tooltip);

        if (label != null) {
            wrapper = new JPanel(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 0;
            c.gridwidth = 1;
            c.weightx = 1.0;
            c.weighty = 1.0;
            c.insets = new Insets(0, 0, 0, 0);
            wrapper.add(label, c);
            c.gridx = 1;
            c.gridy = 0;
            c.insets = new Insets(0, 0, 0, 0);
            wrapper.add(textField, c);
            parent.add(wrapper);
        } else {
            parent.add(textField);
        }

        textField.setPreferredSize(new Dimension(100, textField.getPreferredSize().height));
        textField.revalidate();
    }


    public void setVisible(boolean visible) {
        if (wrapper != null)
            wrapper.setVisible(visible);
        else
            super.setVisible(visible);
    }

    public String getControlValueRaw() {
        String value = textField.getText();

        if ("".equals(value)) {
            return null;
        } else {
            return value;
        }
    }

    public void setValue(String value) {
        textField.setText((value == null) ? "" : value.toString());
    }

    public List<Component> getComponents() {
        List<Component> widgets = new ArrayList<Component>();
        if (label != null) widgets.add(label);
        widgets.add(textField);
        return widgets;
    }

    public List<Component> getComponentsExcludingLabel() {
        List<Component> widgets = new ArrayList<Component>();
        widgets.add(textField);
        return widgets;
    }

    public void addListener(SwingListener listener) {
        textField.getDocument().addDocumentListener(listener);
    }

    public void removeListener(SwingListener listener) {
        textField.getDocument().removeDocumentListener(listener);
    }

    /**
     * Overridden -- makes the textField appear non-editable vs. the default of disabled.
     */
    public void processConstValueHasBeenSet() {
        textField.setEditable(false);
    }

    /*
     *
     */
    protected void processNullValueIndicatorChange(Boolean aOldNullValueInd, Boolean aNewNullValueInd) {
        if (Boolean.FALSE.equals(aNewNullValueInd)) {
            textField.setText("");
        }
    }

    /* (non-Javadoc)
     * @see org.atdl4j.ui.ControlUI#reinit()
     */
    @Override
    public void processReinit(Object aControlInitValue) {
        if ((textField != null)) {
            textField.setText((aControlInitValue != null) ? (String) aControlInitValue : "");
        }
    }


    @Override
    public List<? extends Component> createBrickComponents() {

        List<Component> components = new ArrayList<Component>();

        // tooltip
        String tooltip = control.getTooltip();

        // label
        if (control.getLabel() != null) {
            label = new JLabel();
            label.setName(getName() + "/label");
            label.setText(control.getLabel());
            if (tooltip != null) label.setToolTipText(tooltip);
        }

        // textField
        textField = new JFormattedTextField();
        textField.setName(getName() + "/text");

        // init value
        if (ControlHelper.getInitValue(control, getAtdl4jOptions()) != null)
            textField.setText((String) ControlHelper.getInitValue(control, getAtdl4jOptions()));

        // tooltip
        if (tooltip != null) textField.setToolTipText(tooltip);

        if (label != null) {
            components.add(label);
        }
        components.add(textField);

        textField.setPreferredSize(new Dimension(100, textField.getPreferredSize().height));

        return components;
    }
}