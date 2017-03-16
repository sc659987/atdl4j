
package org.atdl4j.ui.swing;

import org.atdl4j.ui.Atdl4jWidget;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * An interface for an algorithmic parameter which will be
 * rendered as an Swing Widget.
 */
public interface SwingWidget<E extends Comparable<?>> extends Atdl4jWidget<E> {
    public void createWidget(JPanel parent);

    public List<Component> getComponents();

    public List<Component> getComponentsExcludingLabel();

    public void addListener(SwingListener listener);

    public void removeListener(SwingListener listener);

    public List<? extends Component> getBrickComponents();


}