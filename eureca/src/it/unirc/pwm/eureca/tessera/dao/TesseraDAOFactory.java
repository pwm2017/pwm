package it.unirc.pwm.eureca.tessera.dao;


public class TesseraDAOFactory {

	  private static TesseraDAOInterface dao = null;
	  
	  private TesseraDAOFactory(){
	  }
	  
	  public static TesseraDAOInterface getDAO() {
		  
	    if ( dao == null ) {
	    	dao = new TesseraDAOImplement();
	    }
	    return dao;
	  } 
}
