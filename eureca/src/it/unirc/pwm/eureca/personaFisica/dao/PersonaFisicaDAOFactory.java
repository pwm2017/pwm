package it.unirc.pwm.eureca.personaFisica.dao;


public class PersonaFisicaDAOFactory {

	  private static PersonaFisicaDAOInterface dao = null;
	  
	  private PersonaFisicaDAOFactory(){
	  }
	  
	  public static PersonaFisicaDAOInterface getDAO() {
		  
	    if ( dao == null ) {
	    	dao = new PersonaFisicaDAOImplement();
	    }
	    return dao;
	  } 
}
