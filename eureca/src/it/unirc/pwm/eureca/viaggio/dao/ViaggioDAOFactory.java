package it.unirc.pwm.eureca.viaggio.dao;


public class ViaggioDAOFactory {

	  private static ViaggioDAOInterface dao = null;
	  
	  private ViaggioDAOFactory(){
	  }
	  
	  public static ViaggioDAOInterface getDAO() {
		  
	    if ( dao == null ) {
	    	dao = new ViaggioDAOImplement();
	    }
	    return dao;
	  } 
}
