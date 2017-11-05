package it.unirc.pwm.eureca.svolge.dao;


public class SvolgeDAOFactory 
{

	  private static SvolgeDAOInterface dao = null;
	  
	  private SvolgeDAOFactory(){
	  }
	  
	  public static SvolgeDAOInterface getDAO() {
		  
	    if ( dao == null ) {
	    	dao = new SvolgeDAOImplement();
	    }
	    return dao;
	  } 
}
