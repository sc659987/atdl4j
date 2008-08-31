package br.com.investtools.fix.atdl.ui.swt.widget;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Widget;

import br.com.investtools.fix.atdl.core.xmlbeans.EnumPairT;
import br.com.investtools.fix.atdl.core.xmlbeans.ParameterT;
import br.com.investtools.fix.atdl.ui.swt.ParameterWidget;

public class ComboBoxParameterWidget implements ParameterWidget<String> {

	private ParameterT parameter;

	private Combo comboBox;

	private boolean editable;

	public ComboBoxParameterWidget(boolean editable) {
		this.editable = editable;
	}

	public ComboBoxParameterWidget() {
		this(false);
	}

	@Override
	public Widget createWidget(Composite parent, ParameterT parameter, int style) {
		this.parameter = parameter;

		// label
		Label l = new Label(parent, SWT.NONE);
		l.setText(getLabelText(parameter));

		// comboBox
		style = style | SWT.BORDER;
		if (!editable) {
			style |= SWT.READ_ONLY;
		}
		Combo comboBox = new Combo(parent, style);
		comboBox.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		this.comboBox = comboBox;

		// comboBox itens

		EnumPairT[] enumPairArray = parameter.getEnumPairArray();
		for (EnumPairT enumPair : enumPairArray) {
			comboBox.add(enumPair.getUiRep());
		}

		// tooltip
		String tooltip = parameter.getTooltip();
		comboBox.setToolTipText(tooltip);
		l.setToolTipText(tooltip);

		return parent;
	}

	public String getLabelText(ParameterT parameter) {
		if (parameter.getUiRep() != null) {
			return parameter.getUiRep();
		}
		return parameter.getName();
	}

	public String getValue() {
		// TODO: verificar
		int selection = comboBox.getSelectionIndex();

		if (selection > 0) {
			EnumPairT e = parameter.getEnumPairArray(selection);
			return e.getWireValue();
		} else
			// XXX no item selected
			return "";
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

	@Override
	public String convertValue(String value) {
		return value;
	}

	@Override
	public ParameterT getParameter() {
		return parameter;
	}

}