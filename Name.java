/**
 * A simple name class comprising a first name and a family name.
 * There is an option to produce a full name by combining these.
 * 
 * @author Luke
 */
public class Name {
	//Fields
	private String firstName;
	private String familyName;
	
	//Constructors
	public Name() {
		firstName = "";
		familyName = "";
	}
	
	//Methods
	public Name(String firstName, String familyName) {
		this.firstName = firstName;
		this.familyName = familyName;
	}

	/** @return the firstName */
	public String getFirstName() {
		return firstName;
	}

	/** @param firstName the firstName to set */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/** @return the familyName */
	public String getFamilyName() {
		return familyName;
	}

	/** @param familyName the familyName to set */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	/** @param FullName the combination of firstName and familyName */
	public String getFullName() {
		return firstName + " " + familyName;
	}
	
	@Override
	public String toString() {
		return "Name:[firstName= " + firstName + ", familyName= " + familyName + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		//test exceptional cases, i.e. obj is a Name, and not null
		if (obj == null || this.getClass() != obj.getClass())
			return false;
		
		Name other = (Name) obj; // cast to a Name object
		
		//compare first & family names using the String .equals()
		return this.familyName.equals(other.familyName)
				&& this.firstName.equals(other.firstName);
	}
}
