package br.com.investtools.fix.atdl.ui.swt;

import org.apache.xmlbeans.XmlException;

import br.com.investtools.fix.atdl.core.xmlbeans.ParameterT;

public interface ParameterUIFactory {

	public ParameterUI<?> create(ParameterT parameter) throws XmlException;

}
