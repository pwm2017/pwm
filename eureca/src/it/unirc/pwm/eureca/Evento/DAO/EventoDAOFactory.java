package it.unirc.pwm.eureca.Evento.DAO;


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
