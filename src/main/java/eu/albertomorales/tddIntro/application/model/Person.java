package eu.albertomorales.tddIntro.application.model;

public interface Person {

	/**
	 * @return Person first name
	 */
	public abstract String getFirstName();

	/**
	 * @return Person ID
	 */
	public abstract Integer getId();

	/**
	 * @return Person last name
	 */
	public abstract String getLastName();

}