package it.unirc.pwm.eureca.utils;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import it.unirc.pwm.eureca.socio.model.Indirizzo;

public class IndirizzoConverter  extends StrutsTypeConverter
{

	@Override
	public Object convertFromString(Map arg0, String[] values, Class indirizzo) 
	{   
		Indirizzo i=new Indirizzo(Integer.parseInt(values[0]),values[1],values[2],values[3]);
		return i;
	}

	@Override
	public String convertToString(Map arg0, Object value) {
		Indirizzo env  = (Indirizzo) value;
	      return env == null ? null : env.getCap()+env.getCitta()+env.getCivico()+env.getVia();
	}
	
}
