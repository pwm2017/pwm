package it.unirc.pwm.eureca.Attivitą.DAO;


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
