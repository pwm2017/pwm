package it.unirc.pwm.eureca.socio.dao;


public class SocioDAOFactory {

	  private static SocioDAOInterface dao = null;
	  
	  private SocioDAOFactory(){
	  }
	  
	  public static SocioDAOInterface getDAO() {
		  
	    if ( dao == null ) {
	    	dao = new SocioDAOImplement();
	    }
	    return dao;
	  } 
}
