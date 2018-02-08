package it.unirc.pwm.eureca.utils;

public class Costant {
	//public static String URL_GAZZETTA = "http://xml2.temporeale.gazzettaobjects.it/optatrsport/";
	
	public static Integer SIZE_LIST =10;
	
	
	static int dot1 = System.getProperty("catalina.base").indexOf(".");
	public static String rootPath=System.getProperty("catalina.base").substring(0, dot1);
	
	public static String PATH_IMMAGINI_PROFILO =rootPath+ "Fantapjam/WebContent/webapp/img/immaginiUtente";
	public static String PATH_IMMAGINI_GIOCATORE = rootPath+ "Fantapjam/WebContent/webapp/img/immaginiGiocatore";
	public static String PATH_IMMAGINI_SQUADRE = rootPath+ "Fantapjam/WebContent/webapp/img/immaginiSquadre";
	
	
	public static String RELATIVE_PATH_IMMAGINI_SQUADRE ="/Fantapjam/webapp/img/immaginiSquadre";
	public static String RELATIVE_PATH_IMMAGINI_GIOCATORE ="/Fantapjam/webapp/img/immaginiGiocatore";
	public static String RELATIVE_PATH_IMMAGINI_UTENTE ="/Fantapjam/webapp/img/immaginiUtente";
	
	
	public static String SUPER_USER = "administrator";
}
