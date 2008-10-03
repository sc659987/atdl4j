package br.com.investtools.fix.atdl.ui.swt.widget;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.xmlbeans.XmlException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Widget;

import br.com.investtools.fix.atdl.core.xmlbeans.ParameterT;
import br.com.investtools.fix.atdl.core.xmlbeans.UTCTimeStampT;
import br.com.investtools.fix.atdl.ui.swt.ParameterUI;
import br.com.investtools.fix.atdl.ui.swt.util.ParameterListenerWrapper;
import br.com.investtools.fix.atdl.ui.swt.util.WidgetHelper;

public class UTCTimeStampClockParameterWidget implements ParameterUI<Date> {

	private ParameterT parameter;

	private DateTime dateClock;

	private DateTime timeClock;

	private Label label;

	private String localMktTz;

	@Override
	public Widget createWidget(Composite parent, ParameterT parameter, int style) {
		this.parameter = parameter;

		// label
		Label l = new Label(parent, SWT.NONE);
		this.label = l;
		l.setText(WidgetHelper.getLabelText(parameter));

		Composite c = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout(2, true);
		gridLayout.horizontalSpacing = 2;
		gridLayout.verticalSpacing = 0;
		gridLayout.marginLeft = gridLayout.marginRight = 0;
		gridLayout.marginTop = gridLayout.marginBottom = 0;
		gridLayout.marginWidth = gridLayout.marginHeight = 0;
		c.setLayout(gridLayout);
		c.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		// date clock
		DateTime dateClock = new DateTime(c, style | SWT.BORDER | SWT.DATE
				| SWT.MEDIUM);
		dateClock
				.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		this.dateClock = dateClock;

		// time clock
		DateTime timeClock = new DateTime(c, style | SWT.BORDER | SWT.TIME
				| SWT.MEDIUM);
		timeClock
				.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		this.timeClock = timeClock;

		// tooltip
		String tooltip = parameter.getTooltip();
		dateClock.setToolTipText(tooltip);
		timeClock.setToolTipText(tooltip);
		l.setToolTipText(tooltip);

		UTCTimeStampT utcTimeStamp = (UTCTimeStampT) parameter;

		if (utcTimeStamp.isSetLocalMktTz())
			localMktTz = utcTimeStamp.getLocalMktTz();

		// init value
		if (utcTimeStamp.isSetInitValue()) {
			Calendar initValue = utcTimeStamp.getInitValue();
			if (localMktTz != null)
				initValue.setTimeZone(getTimeZone(localMktTz));
			timeClock.setHours(initValue.get(Calendar.HOUR_OF_DAY));
			timeClock.setMinutes(initValue.get(Calendar.MINUTE));
			timeClock.setSeconds(initValue.get(Calendar.SECOND));
		}

		return parent;
	}

	public Date getValue() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, dateClock.getYear());
		c.set(Calendar.MONTH, dateClock.getMonth());
		c.set(Calendar.DAY_OF_MONTH, dateClock.getDay());
		c.set(Calendar.HOUR_OF_DAY, timeClock.getHours());
		c.set(Calendar.MINUTE, timeClock.getMinutes());
		c.set(Calendar.SECOND, timeClock.getSeconds());
		if (localMktTz != null)
			c.setTimeZone(getTimeZone(localMktTz));
		c.clear(Calendar.MILLISECOND);
		return c.getTime();
	}

	@Override
	public void setValue(Date value) {
		Calendar c = Calendar.getInstance();
		c.setTime(value);
		dateClock.setDay(c.get(Calendar.DAY_OF_MONTH));
		dateClock.setMonth(c.get(Calendar.MONTH));
		dateClock.setYear(c.get(Calendar.YEAR));
		timeClock.setHours(c.get(Calendar.HOUR_OF_DAY));
		timeClock.setMinutes(c.get(Calendar.MINUTE));
		timeClock.setSeconds(c.get(Calendar.SECOND));
	}

	private static TimeZone getTimeZone(String localMktTz) {
		return TimeZone.getTimeZone(localMktTz);
	}

	@Override
	public String getFIXValue() {

		Date date = this.getValue();
		DateFormat fixUTCTimeStampFormat = new SimpleDateFormat(
				"yyyyMMdd-HH:mm:ss");
		String value = fixUTCTimeStampFormat.format(date);

		if (parameter.getFixTag() != null) {
			return Integer.toString(parameter.getFixTag().intValue()) + "="
					+ value;
		} else {

			String name = parameter.getName();
			String type = Integer.toString(parameter.getType());
			char delimiter = '\001';
			return "958=" + name + delimiter + "959=" + type + delimiter
					+ "960=" + value;
		}
	}

	@Override
	public Date convertValue(String value) throws XmlException {
		// TODO reset timezone here?
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HH:mm:ss");
		try {
			return dateFormat.parse(value);
		} catch (ParseException e) {
			throw new XmlException("Unable to parse \"" + value
					+ "\" with format \"yyyyMMdd-HH:mm:ss\"");
		}

	}

	@Override
	public ParameterT getParameter() {
		return parameter;
	}

	@Override
	public void generateStateRuleListener(Listener listener) {
		dateClock.addListener(SWT.Selection, listener);
		timeClock.addListener(SWT.Selection, listener);
	}

	@Override
	public List<Control> getControls() {
		List<Control> widgets = new ArrayList<Control>();
		widgets.add(label);
		widgets.add(dateClock);
		widgets.add(timeClock);
		return widgets;
	}

	@Override
	public void addListener(Listener listener) {
		ParameterListenerWrapper wrapper = new ParameterListenerWrapper(this,
				listener);
		dateClock.addListener(SWT.Selection, wrapper);
		timeClock.addListener(SWT.Selection, wrapper);
	}

	@Override
	public void removeListener(Listener listener) {
		dateClock.removeListener(SWT.Selection, listener);
		timeClock.removeListener(SWT.Selection, listener);
	}

}
