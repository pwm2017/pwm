package it.unirc.pwm.eureca.action.socio.validator;

import it.unirc.pwm.eureca.socio.dao.SocioDAOFactory;
import it.unirc.pwm.eureca.socio.dao.SocioDAOInterface;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class CheckUsernameValidator extends FieldValidatorSupport{
	
	private SocioDAOInterface dao = SocioDAOFactory.getDAO();
	
	
	@Override
	public void validate(Object arg0) throws ValidationException {
		String username = (String) this.getFieldValue(this.getFieldName(), arg0);

		if(dao.verificaUsername(username)==true){
			addFieldError(getFieldName(), arg0);
		}
		
	}

}
