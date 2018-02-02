package it.unirc.pwm.eureca.action.support;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xml.internal.utils.LocaleUtility;

public class CambiaLingua extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	private Map<String,Object> session; 
	private String lang;
	
	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}
	public void setSession(Map<String, Object> session) {
		this.session=session;
		// TODO Auto-generated method stub
		
	}
	
	public String execute() throws Exception{
		if(lang.equals("EN"))
		session.put("WW_TRANS_I18N_LOCALE", LocaleUtility.langToLocale("en"));
		else if(lang.equals("IT"))
		session.put("WW_TRANS_I18N_LOCALE", LocaleUtility.langToLocale("it"));
		return SUCCESS;
	}




}
