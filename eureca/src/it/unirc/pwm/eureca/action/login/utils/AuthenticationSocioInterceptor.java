package it.unirc.pwm.eureca.action.login.utils;

import java.util.Map;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import it.unirc.pwm.eureca.socio.model.Socio;



public class AuthenticationSocioInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;

	public void destroy() {
	}
	public void init() {
	}

	public String intercept( ActionInvocation actionInvocation ) throws Exception {


		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();

		Socio socio = (Socio) session.get( "socio" );

		if (socio==null) 
		{
			return Action.LOGIN;
		} 
		else
		{
			Action action = ( Action ) actionInvocation.getAction();


			if (action instanceof SocioAware) {
				((SocioAware)action).setSocio(socio); 
			}

			return actionInvocation.invoke();
		}
	}
}
