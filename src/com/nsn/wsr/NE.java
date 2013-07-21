package com.nsn.wsr;

/**
 * 
 * Corresponding schema in DB:
 * <code> String createTable = "CREATE TABLE nedata (id varchar(80), type varchar(80), parentid varchar(80), latitude varchar(10), longitude varchar(10), swversion varchar(80), technology varchar(80), presentationName varchar(80))"</code>
 * ;
 */
public class NE {
	private String id;
	private String type; // BTS/BSC
	private String parentID = "";
	private String scopeID = "";
	private String latitude = "";
	private String longitude = "";
	private String swVersion = "";
	private String technology = "";
	private String presentationName = "";

	public static final String idCol = "id";
	public static final String typeCol = "type"; // BTS/BSC
	public static final String parentIDCol = "parentid";
	public static final String scopeIDCol = "scopeid";
	public static final String latitudeCol = "latitude";
	public static final String longitudeCol = "longitude";
	public static final String swVersionCol = "swversion";
	public static final String technologyCol = "technology";
	public static final String presentationNameCol = "presentationname";
	public static final String createTableQuery = "CREATE TABLE nedata ("
			+ idCol + " varchar(80), " + typeCol + " varchar(80), "
			+ parentIDCol + " varchar(80), " + latitudeCol + " varchar(10), "
			+ longitudeCol + " varchar(10), " + swVersionCol + " varchar(80), "
			+ technologyCol + " varchar(80), " + presentationNameCol
			+ " varchar(80))";

	public NE(String aId) {
		this.setId(aId);
	}

	public NE(String aId, String aType) /* throws Exception */{
		/*
		 * if(null == aId){ throw new Exception("neID cant be empty."); }
		 */
		this.setId(aId);
		this.setType(aType);
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	private void setId(String aId) {
		this.id = aId;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String aType) {
		this.type = aType;
	}

	/**
	 * @return the parentID
	 */
	public String getParentID() {
		return parentID;
	}

	/**
	 * @param parentID
	 *            the parentID to set
	 */
	public void setParentID(String aParentID) {
		this.parentID = aParentID;
	}

	/**
	 * @return the scopeID
	 */
	public String getScopeID() {
		return scopeID;
	}

	/**
	 * @param scopeID
	 *            the scopeID to set
	 */
	public void setScopeID(String aScopeID) {
		this.scopeID = aScopeID;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(String aLatitude) {
		latitude = aLatitude;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(String aLongitude) {
		longitude = aLongitude;
	}

	/**
	 * @return the swVersion
	 */
	public String getSwVersion() {
		return swVersion;
	}

	/**
	 * @param swVersion
	 *            the swVersion to set
	 */
	public void setSwVersion(String aSwVersion) {
		this.swVersion = aSwVersion;
	}

	/**
	 * @param swVersion
	 *            the swVersion to set
	 */
	public Boolean upgradeSwVersion(String newSwVersion) {
		if (!checkNewSwVersion(newSwVersion)) {
			return false;
		}
		this.swVersion = newSwVersion;
		return true;
	}

	/**
	 * @return the technology
	 */
	public String getTechnology() {
		return technology;
	}

	/**
	 * @param technology
	 *            the technology to set
	 */
	public void setTechnology(String aTechnology) {
		this.technology = aTechnology;
	}

	/**
	 * @return the presentationName
	 */
	public String getPresentationName() {
		return presentationName;
	}

	/**
	 * @param presentationName
	 *            the presentationName to set
	 */
	public void setPresentationName(String aPresentationName) {
		this.presentationName = aPresentationName;
	}

	/**
	 * Checks if the new version is greater than the version already exists.
	 * 
	 * @param newVersion
	 * @return
	 */
	private Boolean checkNewSwVersion(String newVersion) {
		String oldVersion = this.getSwVersion();

		while (!oldVersion.equals("") && !newVersion.equals("")) {
			Integer oldIndex = oldVersion.indexOf('.');
			Integer newIndex = newVersion.indexOf('.');

			String oldValue = (oldIndex == -1) ? oldVersion : oldVersion
					.substring(0, oldIndex);
			String newValue = (newIndex == -1) ? newVersion : newVersion
					.substring(0, newIndex);

			if (Integer.parseInt(newValue) > Integer.parseInt(oldValue)) {
				return Boolean.TRUE;
			} else if (Integer.parseInt(oldValue) > Integer.parseInt(newValue)) {
				return Boolean.FALSE;
			}

			oldVersion = (oldIndex == -1) ? "" : oldVersion
					.substring(oldIndex + 1);
			newVersion = (newIndex == -1) ? "" : newVersion
					.substring(newIndex + 1);
		}

		return (!oldVersion.equals("") && newVersion.equals("")) ? Boolean.FALSE
				: Boolean.TRUE;
	}

	public void consoleLogNE() {
		System.out.println(idCol + " : " + this.id);
		System.out.println(typeCol + " : " + this.type);
		System.out.println(parentIDCol + " : " + this.parentID);
		System.out.println(latitudeCol + " : " + this.latitude);
		System.out.println(longitudeCol + " : " + this.longitude);
		System.out.println(swVersionCol + " : " + this.swVersion);
		System.out.println(technologyCol + " : " + this.technology);
		System.out.println(presentationNameCol + " : " + this.presentationName);
		System.out.println(":--------------------------------:");
		System.out.println();
	}
}
