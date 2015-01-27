package org.norc.beaconservice.bo;

import java.util.Random;

/**
 * Use this class to create an array of randomized beacon objects
 * @author stevenross
 *
 */
public abstract class BeaconFactory {
	
	public static Beacon[] getNewBeaconList() {
		
		Beacon[] beaconArr ={ new Beacon("1", "1407F", "Its in Steve's Cube!"),
						 new Beacon("2", "1407D", "Psstt..You may want to Check by Tina"),
						 new Beacon("3", "1407A", "I'm thinking Jorge's area for this one.  Just a gut feeling!")
						};
		
		return RandomizeArray(beaconArr);
	}
	
	
	private static Beacon[] RandomizeArray(Beacon[] array){
		Random rgen = new Random();  		
 
		for (int i=0; i<array.length; i++) {
		    int randomPosition = rgen.nextInt(array.length);
		    Beacon temp = array[i];
		    array[i] = array[randomPosition];
		    array[randomPosition] = temp;
		}
 
		return array;
	}

}