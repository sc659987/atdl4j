package org.atdl4j.data.fix;

import org.atdl4j.fixatdl.core.*;

/**
 * Utility class.
 */
public abstract class Tag959Helper {

    public static int toInteger(ParameterT parameter) {
        if (parameter instanceof IntT) {
            return 1;
        } else if (parameter instanceof LengthT) {
            return 2;
        } else if (parameter instanceof NumInGroupT) {
            return 3;
        } else if (parameter instanceof SeqNumT) {
            return 4;
        } else if (parameter instanceof TagNumT) {
            return 5;
        } else if (parameter instanceof FloatT) {
            return 6;
        } else if (parameter instanceof QtyT) {
            return 7;
        } else if (parameter instanceof PriceT) {
            return 8;
        } else if (parameter instanceof PriceOffsetT) {
            return 9;
        } else if (parameter instanceof AmtT) {
            return 10;
        } else if (parameter instanceof PercentageT) {
            return 11;
        } else if (parameter instanceof CharT) {
            return 12;
        } else if (parameter instanceof BooleanT) {
            return 13;
        } else if (parameter instanceof StringT) {
            return 14;
        } else if (parameter instanceof MultipleCharValueT) {
            return 15;
        } else if (parameter instanceof CurrencyT) {
            return 16;
        } else if (parameter instanceof ExchangeT) {
            return 17;
        } else if (parameter instanceof MonthYearT) {
            return 18;
        } else if (parameter instanceof UTCTimestampT) {
            return 19;
        } else if (parameter instanceof UTCTimeOnlyT) {
            return 20;
        } else if (parameter instanceof LocalMktDateT) {
            return 21;
        } else if (parameter instanceof UTCDateOnlyT) {
            return 22;
        } else if (parameter instanceof DataT) {
            return 23;
        } else if (parameter instanceof MultipleStringValueT) {
            return 24;
        } else if (parameter instanceof CountryT) {
            return 25;
        } else if (parameter instanceof LanguageT) {
            return 26;
        } else if (parameter instanceof TZTimeOnlyT) {
            return 27;
        } else if (parameter instanceof TZTimestampT) {
            return 28;
        } else if (parameter instanceof TenorT) {
            return 29;
        }
        throw new IllegalArgumentException("Unsupported Parameter type: " + (parameter == null ? "null" : parameter.getClass()));
    }
}
