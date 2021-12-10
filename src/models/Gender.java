package models;

public enum Gender {
	MALE("Hombre"), FEMALE("Mujer");

	private String name;

	private Gender(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}