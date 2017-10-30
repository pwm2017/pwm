package it.unirc.pwm.eureca.evento.dao;


public class EventoDAOFactory {

	  private static EventoDAOInterface dao = null;
	  
	  private EventoDAOFactory(){
	  }
	  
	  public static EventoDAOInterface getDAO() {
		  
	    if ( dao == null ) {
	    	dao = new EventoDAOImplement();
	    }
	    return dao;
	  } 
}
