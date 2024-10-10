package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	
	private static int TIME_STARTINDEX = 11; 

	public static int toSeconds(String timestr) {
		int hr = Integer.parseInt(timestr.substring(12,13));
		int min = Integer.parseInt(timestr.substring(14,16));
		int secs = Integer.parseInt(timestr.substring(17,19));
		int secondssum = (((hr*60)*60) + (min*60) + secs);
		
		return secondssum;
		
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		GPSPoint gpspoint;

		// TODO 
		throw new UnsupportedOperationException(TODO.method());
		
	}
	
}
