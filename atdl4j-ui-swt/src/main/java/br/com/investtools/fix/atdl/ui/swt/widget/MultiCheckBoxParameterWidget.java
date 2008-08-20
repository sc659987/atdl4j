package br.com.investtools.fix.atdl.ui.swt.widget;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Widget;

import br.com.investtools.fix.atdl.core.xmlbeans.EnumPairT;
import br.com.investtools.fix.atdl.core.xmlbeans.ParameterT;
import br.com.investtools.fix.atdl.ui.swt.ParameterWidget;

public class MultiCheckBoxParameterWidget implements ParameterWidget {

	private ParameterT parameter;

	private List<Button> multiCheckBox = new ArrayList<Button>();

	@Override
	public Widget createWidget(Composite parent, ParameterT parameter, int style) {
		this.parameter = parameter;

		Composite c = new Composite(parent, SWT.NONE);
		c.setLayout(new FillLayout());

		// label
		Label l = new Label(c, SWT.NONE);
		l.setText(getLabelText(parameter));

		// tooltip
		String tooltip = parameter.getTooltip();
		l.setToolTipText(tooltip);

		// checkBoxes
		EnumPairT[] enumPairArray = parameter.getEnumPairArray();
		for (EnumPairT enumPair : enumPairArray) {
			Button checkBox = new Button(c, style | SWT.CHECK);
			checkBox.setText(enumPair.getUiRep());
			checkBox.setToolTipText(tooltip);
			multiCheckBox.add(checkBox);
		}

		return c;
	}

	public String getLabelText(ParameterT parameter) {
		if (parameter.getUiRep() != null) {
			return parameter.getUiRep();
		}
		return parameter.getName();
	}

	private String getValue() {

		String value = "";
		for (int i = 0; i < this.multiCheckBox.size(); i++) {
			Button b = multiCheckBox.get(i);
			if (b.getSelection()) {
				if ("".equals(value))
					value += parameter.getEnumPairArray(i).getWireValue();
				else
					value += " " + parameter.getEnumPairArray(i).getWireValue();
			}
		}
		return value;

	}

	@Override
	public String getFIXValue() {
		if (parameter.getFixTag() != null) {
			return Integer.toString(parameter.getFixTag().intValue()) + "="
					+ getValue();
		} else {
			String name = parameter.getName();
			String type = Integer.toString(parameter.getType());
			String value = getValue();
			char delimiter = '\001';
			return "958=" + name + delimiter + "959=" + type + delimiter
					+ "960=" + value;
		}
	}

}
