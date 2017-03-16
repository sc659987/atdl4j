package org.atdl4j.ui.swing;

import org.atdl4j.fixatdl.core.ParameterT;
import org.atdl4j.fixatdl.layout.ControlT;

import java.awt.*;

public interface SwingWidgetFactory {
    public SwingWidget<?> createWidget(Container parent, ControlT control, ParameterT parameter);
}