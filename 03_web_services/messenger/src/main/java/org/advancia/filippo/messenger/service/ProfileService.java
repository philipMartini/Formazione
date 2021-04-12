package org.advancia.filippo.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.advancia.filippo.messenger.database.Database;
import org.advancia.filippo.messenger.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles;
	
	
	public ProfileService() {
		this.profiles = Database.getProfiles();
		
	}
	
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(this.profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return this.profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(this.profiles.size() + 1);
		this.profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty())
			return null;
		
		this.profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) { return this.profiles.remove(profileName); }

}
