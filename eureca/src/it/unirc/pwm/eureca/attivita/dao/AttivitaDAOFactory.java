package it.unirc.pwm.eureca.attivita.dao;


public class AttivitaDAOFactory {

    private static AttivitaDAOInterface dao = null;

    private AttivitaDAOFactory() {
    }

    public static AttivitaDAOInterface getDAO() {

        if (dao == null) {
            dao = new AttivitaDAOImplement();
        }
        return dao;
    }
}
