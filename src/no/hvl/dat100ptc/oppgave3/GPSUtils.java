package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.TODO;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {
		double min;
		min = da[0];
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		return min;
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double[] latitudes = new double[gpspoints.length];
		for (int i = 0; i < gpspoints.length; i++) {
			latitudes[i] = gpspoints[i].getLatitude(); //Tar ut latitude i fra gpspoints
		}
		return latitudes;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		
		double[] longitudes = new double[gpspoints.length];
		for (int i = 0; i < gpspoints.length; i++) {
			longitudes[i] = gpspoints[i].getLongitude(); //Tar ut latitude i fra gpspoints
		}
		return longitudes;

	}

	private static final int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double lat1, long1, lat2, long2;

		lat1 = gpspoint1.getLatitude();
		long1 = gpspoint1.getLongitude();
		lat2 = gpspoint2.getLatitude();
		long2 = gpspoint2.getLongitude();
		
		lat1 = Math.toRadians(lat1);
		long1 = Math.toRadians(long1);
		lat2 = Math.toRadians(lat2);
		long2 = Math.toRadians(long2);
		
		//double distance = Math.sqrt(Math.pow(lat2 - lat1, 2) + Math.pow(long2 - long1, 2))*R;
		double distance = Math.acos(sin(lat1)*sin(lat2)+cos(lat1)*cos(lat2)*cos(long2-long1))*R;
		return distance;
	}
	
	private static double compute_a(double phi1, double phi2, double deltaphi, double deltadelta) {
	
		throw new UnsupportedOperationException(TODO.method());
		
		// TODO 

	}

	private static double compute_c(double a) {

		
		throw new UnsupportedOperationException(TODO.method());
		
		
		// TODO 

	}

	
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;
		
		int dt = gpspoint2.getTime() - gpspoint1.getTime();
		double d = distance(gpspoint1, gpspoint2);
		
		return d / dt;
	}
	
	private static String _formatTime(int i) {
		String s = "00" + i;
		return s.substring(s.length() - 2, s.length());
	}
	
	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";
		
		int s = secs % 60;
		int m = (secs / 60) % 60;
		int h = secs / 3600;
		
		String hs = "" + h;
		if (hs.length() == 1) hs = "0" + h;
		
		timestr = "  " + hs + TIMESEP + _formatTime(m) + TIMESEP + _formatTime(s);
		
		return timestr;
	}
	
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {
		
		String strinn = String.format("%.2f",d); //2 er mengde av desimal du vil runde det ned til og gjør det også om til en streng.
		String str = ("      "+ strinn.replace(",", "."));
		return str;

		
		
		// TODO
		
	}
}
