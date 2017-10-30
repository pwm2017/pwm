package it.unirc.pwm.eureca.PersonaFisica.DAO;


public class AttivitąDAOFactory {

	  private static AttivitąDAOInterface dao = null;
	  
	  private AttivitąDAOFactory(){
	  }
	  
	  public static AttivitąDAOInterface getDAO() {
		  
	    if ( dao == null ) {
	    	dao = new AttivitąDAOImplement();
	    }
	    return dao;
	  } 
}
