package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int antall) {
		this.gpspoints = new GPSPoint[antall];
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		if (antall >= gpspoints.length) return false;
		
		this.gpspoints[antall] = gpspoint;
		this.antall++;
		
		return true;
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		if (antall >= gpspoints.length) return false;
		
		this.gpspoints[antall] = GPSDataConverter.convert(time, latitude, longitude, elevation);
		this.antall++;
		return true;
	}

	public void print() {
		System.out.println("====== GPS Data - START ======");
		for (int i = 0; i < gpspoints.length; i++) System.out.print(gpspoints[i].toString());
		System.out.println("====== GPS Data - SLUTT ======");
	}
}
