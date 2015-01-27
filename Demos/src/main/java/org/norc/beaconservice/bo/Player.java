package org.norc.beaconservice.bo;

/**
 * This class represents a player.
 * @author stevenross
 *
 */
public class Player {
	
	private String id;
	private String name;
	private Beacon[] beacons;
	private Boolean gameOver = false;
	
	public Player(String name){
		this.name = name;
		this.beacons = BeaconFactory.getNewBeaconList();
	}
	
	public String getId(){
		return this.id;
	}
	
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets the beacon the user is currently assigned to find
	 * @return Beacon 
	 */
	public Beacon getNextBeacon(){
		Beacon beacon;
		for(int i=0; i<=beacons.length; i++){
			if(i ==  beacons.length){
				setGameOver(true);
				return null;
			}
			beacon = beacons[i];
			if(!beacon.getFound()){
				return beacon;
			}
		}
		return null;
	}

	public Boolean getGameOver() {
		return gameOver;
	}

	public void setGameOver(Boolean gameOver) {
		this.gameOver = gameOver;
	}
	
	/**
	 * Sets a beacon's status to found. 
	 * @param bID
	 * @return Beacon (the next iBeacon to find)
	 */
	public Beacon setBeaconFound(String bID){
		Beacon b = getNextBeacon();
		if(b.getId().equals(bID)){
			b.setFound(true);
		}	
		return getNextBeacon();
	}

}
