package org.atdl4j.data;

import org.atdl4j.data.converter.*;
import org.atdl4j.fixatdl.core.*;
import org.atdl4j.fixatdl.layout.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.math.BigInteger;

/*
 * NumericT subclasses
 import org.atdl4j.fixatdl.core.AmtT;
 import org.atdl4j.fixatdl.core.FloatT;
 import org.atdl4j.fixatdl.core.PercentageT;
 import org.atdl4j.fixatdl.core.PriceT;
 import org.atdl4j.fixatdl.core.PriceOffsetT;
 import org.atdl4j.fixatdl.core.QtyT;
 */

/**
 * Factory that creates the appropriate ParameterTypeConveter depending on the parameter
 * or creates the appropriate ControlTypeConveter depending upon the control type.
 * <p>
 * Note that all UI widgets in ATDL are strongly typed.
 */
public class TypeConverterFactory {

    /*
     * Create adapter based on ParameterT
     */
    public ParameterTypeConverter<?> createParameterTypeConverter(ParameterT parameter) {
        if (parameter instanceof StringT || parameter instanceof CharT || parameter instanceof MultipleCharValueT
                || parameter instanceof MultipleStringValueT || parameter instanceof CurrencyT || parameter instanceof ExchangeT
                || parameter instanceof DataT) {
            return new StringConverter(parameter);
        } else if (parameter instanceof NumericT) {
            return new DecimalConverter(parameter); // Float field
        } else if (parameter instanceof IntT || parameter instanceof NumInGroupT || parameter instanceof SeqNumT || parameter instanceof TagNumT
                || parameter instanceof LengthT) {
            return new IntegerConverter(parameter); // Integer field
        } else if (parameter instanceof BooleanT) {
            return new BooleanConverter((BooleanT) parameter);
        } else if (parameter instanceof MonthYearT || parameter instanceof UTCTimestampT || parameter instanceof UTCTimeOnlyT
                || parameter instanceof LocalMktDateT || parameter instanceof UTCDateOnlyT) {
            return new DateTimeConverter(parameter);
        } else {
            throw new IllegalArgumentException("Unsupported ParameterT type: " + parameter.getClass().getName());
        }
    }

    /*
     * Create adapter based on ControlT (native type for each control)
     */
    public ControlTypeConverter<?> createControlTypeConverter(ControlT control, ParameterTypeConverter<?> aParameterTypeConverter) {
        if (control instanceof TextFieldT || control instanceof SingleSelectListT || control instanceof MultiSelectListT
                || control instanceof CheckBoxListT || control instanceof DropDownListT || control instanceof EditableDropDownListT
                || control instanceof RadioButtonListT || control instanceof HiddenFieldT || control instanceof LabelT) {
            return new StringConverter(aParameterTypeConverter);
        } else if (control instanceof SliderT) {
            return new StringConverter(aParameterTypeConverter);
        } else if (control instanceof SingleSpinnerT || control instanceof DoubleSpinnerT) {
            return new DecimalConverter(aParameterTypeConverter);
        } else if (control instanceof CheckBoxT || control instanceof RadioButtonT) {
            return new BooleanConverter(aParameterTypeConverter);
        } else if (control instanceof ClockT) {
            return new DateTimeConverter(aParameterTypeConverter);
        } else {
            throw new IllegalArgumentException("Unsupported ControlT type: " + control.getClass().getName());
        }
    }


    /*
     * Returns an Object that is an instanceof the Parameter's base data type
     * (eg String, BigDecimal, DateTime, etc)
     */
    // 3/12/2010 Scott Atwell added
    public Class<?> getParameterDatatype(ParameterT aParameter) {
        if (aParameter instanceof StringT || aParameter instanceof CharT
                || aParameter instanceof MultipleCharValueT
                || aParameter instanceof MultipleStringValueT
                || aParameter instanceof CurrencyT
                || aParameter instanceof ExchangeT
                || aParameter instanceof DataT) {
            return String.class;
        } else if (aParameter instanceof NumericT) {
            return BigDecimal.class; // Float field
        } else if (aParameter instanceof IntT
                || aParameter instanceof NumInGroupT
                || aParameter instanceof SeqNumT
                || aParameter instanceof TagNumT
                || aParameter instanceof LengthT) {
            return BigInteger.class; // Integer field
        } else if (aParameter instanceof BooleanT) {
            return Boolean.class;
        } else if (aParameter instanceof MonthYearT) {
            return String.class;
        } else if (aParameter instanceof UTCTimestampT
                || aParameter instanceof UTCTimeOnlyT
                || aParameter instanceof LocalMktDateT
                || aParameter instanceof UTCDateOnlyT) {
            return XMLGregorianCalendar.class;
        } else {
            throw new IllegalArgumentException("Unsupported ParameterT type: "
                    + aParameter.getClass().getName());
        }
    }
}
