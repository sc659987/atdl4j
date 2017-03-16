package org.atdl4j.ui.swing.app.impl;

import org.apache.log4j.Logger;
import org.atdl4j.config.Atdl4jOptions;
import org.atdl4j.fixatdl.core.StrategyT;
import org.atdl4j.ui.Atdl4jWidget;
import org.atdl4j.ui.StrategiesUI;
import org.atdl4j.ui.StrategyUI;
import org.atdl4j.ui.app.StrategySelectionEvent;
import org.atdl4j.ui.app.impl.AbstractAtdl4jCompositePanel;

import javax.swing.*;
import java.awt.*;

/**
 * Represents the Swing-specific strategy selection and display GUI component.
 * <p>
 * Creation date: (Feb 28, 2010 6:26:02 PM)
 *
 * @author Scott Atwell
 * @version 1.0, Feb 28, 2010
 */
public class SwingAtdl4jCompositePanel
        extends AbstractAtdl4jCompositePanel {
    public final Logger logger = Logger.getLogger(SwingAtdl4jCompositePanel.class);
    private Window parentComposite;
    private JPanel strPanel;
    private JPanel strategySelectionPanel;
    private JPanel panel;

    public Object buildAtdl4jCompositePanel(Object aParentOrShell, Atdl4jOptions aAtdl4jOptions) {
        return buildAtdl4jCompositePanel((Window) aParentOrShell, aAtdl4jOptions);
    }

    public JPanel buildAtdl4jCompositePanel(Window aParentComposite, Atdl4jOptions aAtdl4jOptions) {
        parentComposite = aParentComposite;

        panel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // -- Delegate back to AbstractAtdl4jCompositePanel --
        init(aParentComposite, aAtdl4jOptions);

        strategySelectionPanel = new JPanel();
        strategySelectionPanel.add((JPanel) getStrategySelectionPanel().buildStrategySelectionPanel(getParentOrShell(), getAtdl4jOptions()));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(strategySelectionPanel, gbc);


        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridy = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        strPanel = (JPanel) getStrategiesUI().buildStrategiesPanel(getParentOrShell(), getAtdl4jOptions(), getAtdl4jUserMessageHandler());
        panel.add(strPanel, gbc);


        JPanel descrPanel = (JPanel) getStrategyDescriptionPanel().buildStrategyDescriptionPanel(getParentOrShell(), getAtdl4jOptions());
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        descrPanel.setPreferredSize(new Dimension((int) strPanel.getPreferredSize().getWidth(), 120)); // FIXME ugly magic number
        panel.add(descrPanel, gbc);
        descrPanel.setVisible(false);  // hide until there is data to populate it with


        // Empty filling component
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        panel.add(new JPanel(), gbc);

        return panel;
    }

    public void setVisibleStrategySectionPanel(boolean aVisible) {
        if (strategySelectionPanel != null) {
            strategySelectionPanel.setVisible(aVisible);
        }
    }

    protected void packLayout() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                if (strPanel != null) {
                    strPanel.revalidate();
                    strPanel.repaint();
                }
                if (parentComposite != null) {
                    // parentComposite.pack();
                }
            }
        });
    }

    /* (non-Javadoc)
     * @see org.atdl4j.ui.app.impl.AbstractAtdl4jCompositePanel#setVisibleOkCancelButtonSection(boolean)
     */
    @Override
    public void setVisibleOkCancelButtonSection(boolean aVisible) {

    }

    /* (non-Javadoc)
     * @see org.atdl4j.ui.app.StrategySelectionPanelListener#strategySelected(org.atdl4j.fixatdl.core.StrategyT, int)
     */
    @Override
    public void strategySelected(StrategyT aStrategy) {
        setSelectedStrategy(aStrategy);
        setSelectedStrategyValidated(false);
        getStrategyDescriptionPanel().loadStrategyDescriptionVisible(aStrategy);
        getStrategiesUI().adjustLayoutForSelectedStrategy(aStrategy);
        getStrategyDescriptionPanel().loadStrategyDescriptionText(aStrategy);
        // -- Notify StrategyEventListener (eg Atdl4jTesterPanel), aSelectedViaLoadFixMsg=false --
        fireStrategyEventListenerStrategySelected(aStrategy, false);
        packLayout();
    }

    @Override
    public void beforeStrategyIsSelected(StrategySelectionEvent event) {
        fireStrategyEventListenerBeforeStrategySelected();
    }

    @Override
    public void setEditable(boolean b) {
        setEnabled(b);
    }

    public void setEnabled(boolean enable) {
        setStrategySelectionEnabled(enable);
        StrategiesUI strategiesUI = getStrategiesUI();
        StrategyT selectedStrategy = getSelectedStrategy();
        if (selectedStrategy != null) {

            StrategyUI ui = strategiesUI.getStrategyUI(selectedStrategy, false);
            if (ui != null) {
                for (Atdl4jWidget<?> widget : ui.getAtdl4jWidgetMap().values()) {
                    widget.setEnabled(enable);
                }
            }
        }
    }

    public void setStrategySelectionEnabled(boolean enable) {
        ((SwingStrategySelectionPanel) getStrategySelectionPanel()).setEnabled(enable);
    }
}
