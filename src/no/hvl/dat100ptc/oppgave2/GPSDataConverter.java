package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {
	
	
	private static int TIME_STARTINDEX = 11; 

	public static int toSeconds(String timestr) {
		int hr = Integer.parseInt(timestr.substring(11,13));
		int min = Integer.parseInt(timestr.substring(14,16));
		int secs = Integer.parseInt(timestr.substring(17,19));
		int secondssum = (((hr*60)*60) + (min*60) + secs);
		
		return secondssum;
		
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		int consum = toSeconds(timeStr); //Skal ikke bli string.
		double latitude = Double.parseDouble(latitudeStr); //24-27 må bli parset som double.
		double longitude = Double.parseDouble(longitudeStr);
		double elevation = Double.parseDouble(elevationStr);
		GPSPoint gpspoint = new GPSPoint(consum, latitude, longitude, elevation); //Må lage et nytt objekt med dette som blir returnert.
		return gpspoint; //skal returnere sum + latitudetr + longitudeStr + elevationStr
		
	}
	
}
