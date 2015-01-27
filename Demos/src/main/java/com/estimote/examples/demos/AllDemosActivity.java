package com.estimote.examples.demos;

import org.norc.beaconservice.bo.Player;
import org.norc.beaconservice.service.HttpRestService;
import org.norc.beaconservice.service.PlayerRegistrationService;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.loopj.android.http.*;

/**
 * Shows all available demos.
 *
 * @author wiktor@estimote.com (Wiktor Gworek)
 * @author champagne-randy
 */
public class AllDemosActivity extends Activity {
	
	private static final String FIRST_NAME_KEY = "firstName";
	
	private boolean isRegistered = false;
	private EditText firstName = null;
	private Player player = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.all_demos);	
		    
		findViewById(R.id.notify_demo_button).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!isRegistered) {
					/*	
					 * registration section implemented with service
					 * 	using AsyncHttp client instead
					 * 
					firstName = (EditText) findViewById(R.id.firstName);
					Intent registrationIntent = new Intent(getApplicationContext(), PlayerRegistrationService.class);
					registrationIntent.putExtra(FIRST_NAME_KEY, firstName.toString());
					startService(registrationIntent);
					*/
					
					player = doRegistration();
				}
				
				if (isRegistered){
					// TODO: start monitoring for Beacon once the service is done
					// TODO: implement an hourglass or spinning circle to let user know that we are waiting for data
					Intent intent = new Intent(AllDemosActivity.this, ListBeaconsActivity.class);
					intent.putExtra(ListBeaconsActivity.EXTRAS_TARGET_ACTIVITY, NotifyDemoActivity.class.getName());
					startActivity(intent);
				} else {
					// TODO: alert the user that the registration failed
					// probably due to lack of connectivity
					// they should push registration button again
				}
			}
		});	
	}
	
	
	/*
	 * registration section implemented with AsyncHttp client
	 */
	// TODO: fetch player object from service
	// TODO: set isRegistered to false
	private Player doRegistration() {
		HttpRestService httpClient = new HttpRestService( getString(R.string.beacon_service_endpoint) );
		
		// TODO: complete this method
		return new Player(null);
	}
	
}

/*
findViewById(R.id.distance_demo_button).setOnClickListener(new View.OnClickListener() {
  @Override
  public void onClick(View v) {
    Intent intent = new Intent(AllDemosActivity.this, ListBeaconsActivity.class);
    intent.putExtra(ListBeaconsActivity.EXTRAS_TARGET_ACTIVITY, DistanceBeaconActivity.class.getName());
    startActivity(intent);
  }
});
*/

/*
findViewById(R.id.characteristics_demo_button).setOnClickListener(new View.OnClickListener() {
  @Override
  public void onClick(View v) {
    Intent intent = new Intent(AllDemosActivity.this, ListBeaconsActivity.class);
    intent.putExtra(ListBeaconsActivity.EXTRAS_TARGET_ACTIVITY, CharacteristicsDemoActivity.class.getName());
    startActivity(intent);
  }
});
*/