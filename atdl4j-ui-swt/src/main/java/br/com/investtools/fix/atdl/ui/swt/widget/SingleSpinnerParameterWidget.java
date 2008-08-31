package br.com.investtools.fix.atdl.ui.swt.widget;

import java.math.BigDecimal;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Widget;

import br.com.investtools.fix.atdl.core.xmlbeans.ParameterT;
import br.com.investtools.fix.atdl.ui.swt.ParameterWidget;

/**
 * Widget for a spinner based parameters. The value is always represented by a
 * BigDecimal.
 * 
 */
public class SingleSpinnerParameterWidget implements
		ParameterWidget<BigDecimal> {

	private ParameterT parameter;

	private Spinner spinner;

	@Override
	public Widget createWidget(Composite parent, ParameterT parameter, int style) {
		this.parameter = parameter;

		// label
		Label l = new Label(parent, SWT.NONE);
		l.setText(getLabelText(parameter));

		// spinner
		Spinner spinner = new Spinner(parent, style | SWT.BORDER);
		spinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		this.spinner = spinner;

		// tooltips
		String tooltip = parameter.getTooltip();
		spinner.setToolTipText(tooltip);
		l.setToolTipText(tooltip);

		return parent;
	}

	public static String getLabelText(ParameterT parameter) {
		if (parameter.getUiRep() != null) {
			return parameter.getUiRep();
		}
		return parameter.getName();
	}

	public BigDecimal getValue() {
		return new BigDecimal(spinner.getSelection());
	}

	@Override
	public String getFIXValue() {
		if (parameter.getFixTag() != null) {
			return Integer.toString(parameter.getFixTag().intValue()) + "="
					+ getValue().toString();
		} else {
			String name = parameter.getName();
			String type = Integer.toString(parameter.getType());
			String value = getValue().toString();
			char delimiter = '\001';
			return "958=" + name + delimiter + "959=" + type + delimiter
					+ "960=" + value;
		}
	}

	@Override
	public BigDecimal convertValue(String value) {
		return new BigDecimal(value);
	}

	@Override
	public ParameterT getParameter() {
		return parameter;
	}

}