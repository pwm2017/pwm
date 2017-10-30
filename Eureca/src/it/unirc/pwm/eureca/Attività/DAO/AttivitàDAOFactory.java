package it.unirc.pwm.eureca.Attivit‡.DAO;


public class Attivit‡DAOFactory {

	  private static Attivit‡DAOInterface dao = null;
	  
	  private Attivit‡DAOFactory(){
	  }
	  
	  public static Attivit‡DAOInterface getDAO() {
		  
	    if ( dao == null ) {
	    	dao = new Attivit‡DAOImplement();
	    }
	    return dao;
	  } 
}
