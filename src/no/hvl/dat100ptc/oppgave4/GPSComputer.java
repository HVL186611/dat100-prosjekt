package no.hvl.dat100ptc.oppgave4;

import java.util.*;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

import no.hvl.dat100ptc.TODO;

public class GPSComputer {
	
	private GPSPoint[] gpspoints;
	
	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();
	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}
	
	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	public double totalDistance() {

		double d = 0;
		
		for (int i = 1; i < this.gpspoints.length; i++) 
			d += GPSUtils.distance(this.gpspoints[i - 1], this.gpspoints[i]);
		
		return d;
	}

	public double totalElevation() {

		double elevation = this.gpspoints[0].getElevation();
		
		for (int i = 1; i < this.gpspoints.length; i++) {
			double e = this.gpspoints[i].getElevation();
			if (e > elevation) elevation = e;
		}
		
		return elevation;
	}

	public int totalTime() {

		// TODO
		throw new UnsupportedOperationException(TODO.method());
		
	}
		

	public double[] speeds() {

		double[] speeds = new double[gpspoints.length-1];
		
		
	}
	
	public double maxSpeed() {
		
		double maxspeed = 0;
		
		// TODO 
		throw new UnsupportedOperationException(TODO.method());
	
	}

	public double averageSpeed() {

		double total = Arrays.stream(speeds()).sum();
	}


	// conversion factor m/s to miles per hour (mps)
	public static final double MS = 2.23;

	public double kcal(double weight, int secs, double speed) {

		double kcal;

		double met = 0;		
		double mph = speed * MS / 2;
		if (mph < 10) met = 4;
		else if (mph < 12) met = 6;
		else if (mph < 14) met = 8;
		else if (mph < 16) met = 10;
		else if (mph < 20) met = 12;
		else met = 16;

		return met * weight * secs / (60 * 60);
	}

	public double totalKcal(double weight) {

		double totalkcal = 0;
		
		//double
		//for (int i = 1; i < gpspoints.length; i++) {
			
		//}
		
		return kcal(weight, totalTime(), averageSpeed());
		//Arrays.stream(this.gpspoints).mapToDouble(point -> kcal(weight, point.getTime(), point.))
	}
	
	private static double WEIGHT = 80.0;
	
	public void displayStatistics() {

		// TODO 
		throw new UnsupportedOperationException(TODO.method());
		
	}

}
