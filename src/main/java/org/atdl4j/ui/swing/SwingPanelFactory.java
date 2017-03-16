package org.atdl4j.ui.swing;

import org.atdl4j.fixatdl.core.ParameterT;
import org.atdl4j.fixatdl.layout.StrategyPanelT;

import java.awt.*;
import java.util.Map;

public interface SwingPanelFactory {
    public Map<String, SwingWidget<?>> createStrategyPanelAndWidgets(Container parent,
                                                                     StrategyPanelT panel, Map<String, ParameterT> parameters);

}