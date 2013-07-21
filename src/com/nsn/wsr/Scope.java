package com.nsn.wsr;

import java.util.Iterator;
import java.util.List;

/**
 * 
 * DB : Uses scope table for presentationNames and NE table for NE<->Scope mappings. 
 *
 */
public class Scope {
	private String id;
	private List<NE> nes;
	private String presentationName;

	public Scope(String aId) {
		this.setId(aId);
	}

	public Scope(String aId, String aName) {
		this.setId(aId);
		this.setPresentationName(aName);
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
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the nes
	 */
	public List<NE> getNEs() {
		return nes;
	}

	private void addScope(List<NE> newNEs) {
		Iterator<NE> nes = newNEs.iterator();
		while (nes.hasNext()) {
			nes.next().setScopeID(this.getId());
		}
	}

	/**
	 * @param nes
	 *            the nes to set
	 */
	public void setNEs(List<NE> newNEs) {
		addScope(newNEs);
		this.nes = newNEs;
	}

	/**
	 * @param nes
	 *            the nes to set
	 */
	public void addNEs(List<NE> nes) {
		addScope(nes);
		this.nes.addAll(nes);
	}

	/**
	 * @param nes
	 *            the nes to set
	 */
	public void removeNE(NE ne) {
		this.nes.remove(ne);
	}

	/**
	 * @param nes
	 *            the nes to set
	 */
	public void removeNEs(List<NE> nes) {
		this.nes.removeAll(nes);
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
	public void setPresentationName(String presentationName) {
		this.presentationName = presentationName;
	}

}
