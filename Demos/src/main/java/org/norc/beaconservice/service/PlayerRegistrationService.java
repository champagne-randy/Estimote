package org.norc.beaconservice.service;

import android.app.IntentService;
import android.content.Intent;

/**
 * 	This class is used by the main activity to register a player against the 
 * 	beaconservice server
 * 
 *	@author: champagne-randy
 *	
 *	http://developer.android.com/guide/components/services.html
 */
public class PlayerRegistrationService extends IntentService {

	public PlayerRegistrationService() {
		super("PlayerRegistrationService");
	}
	
	
	/**
	* This method makes a rest call to beaconservice and initialize Player object
	*
	*/
	@Override
	protected void onHandleIntent(Intent registrationIntent) {
		
	}
	  
	  
	/**
	*	TODO: how to send data back to the activity after getting the player object?
	*/
}
