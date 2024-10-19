/**
 * 
 */
package rh.home.data;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * entries in My Address Book.
 * @author Vincent ROSSIGNOL
 * @version 0.0.1
 * @since core version 0.0.1
 */
@Entity
@Table(name = "entries")
public class MabEntry {

	/**
	 * associated address.
	 */
	@Column( name = "address", length = 256, columnDefinition = "VARCHAR(256)", nullable = true)
	private String address;
	
	/**
	 * associated display
	 */
	@Column(name = "display", length = 64, columnDefinition = "VARCHAR(64)", nullable = false)
	private String display;
	
	/**
	 * associated email
	 */
	@Column( name = "email", length = 320, columnDefinition = "VARCHAR(320)", nullable = true )
	private String email;
	
	/**
	 * associated first name.
	 */
	@Column(name = "firstName", length = 32, columnDefinition = "VARCHAR(32)", nullable = true )
	private String firstName;
	
	/**
	 * entry ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	/**
	 * associated name
	 */
	@Column( name = "name", length = 64, columnDefinition = "VARCHAR(64)", nullable = true )
	private String name;
	
	/**
	 * default constructor.
	 */
	public MabEntry() {
		super();
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}

		if (!(o instanceof MabEntry)) {
			return false;
		}

		MabEntry entry = (MabEntry) o;
		return Objects.equals(this.getId(), entry.getId()) 
				&& Objects.equals(this.getDisplay(), entry.getDisplay())
				&& Objects.equals(this.getFirstName(), entry.getFirstName() ) 
				&& Objects.equals(this.getName(), entry.getName() );
	}

	/**
	 * associated address.
	 * @return a valid {@link String} instance.
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * associated display.
	 * @return a valid {@link String} instance or <code>null</code> if no display has been set yet.
	 */
	public String getDisplay() {
		return this.display;
	}
	
	/**
	 * associated email.
	 * @return a valid {@link String} instance or <code>null</code> if no email has been set.
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * associated first name
	 * @return a valid {@link String} instance or <code>null</code> if no first name has been set yet. 
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * entry ID 
	 * @return a long value.
	 */
	public long getId() {
		return this.id;
	}
	
	/**
	 * associated name.
	 * @return a valid {@link String} instance or <code>null</code> if no name has been set yet.
	 */
	public String getName() {
		return this.name;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash( this.getId(), this.getDisplay(), this.getFirstName(), this.getName() );
	}
	
	/**
	 * sets / remove associated associated address.
	 * @param value a nullable {@link String} instance.
	 */
	public void setAddress( String value ) {
		this.address = value;
	}
	
	/**
	 * sets / remove associated display.
	 * @param value a nullable {@link String} instance.
	 */
	public void setDisplay( String value ) {
		this.display = value;
	}
	
	/**
	 * sets / remove associated email.
	 * @param value a nullable {@link String} instance.
	 */
	public void setEmail( String value ) {
		this.email = value;
	}
	
	/**
	 * sets associated first name.
	 * @param value a nullable {@link String} value.
	 */
	public void setFirstName( String value ) {
		this.firstName = value;
	}
	
	/**
	 * sets associated name.
	 * @param value a nullable {@link String} instance.
	 */
	public void setName( String value ) {
		this.name = value;
	}
	
	public String toString() {
		
		if ( this.getDisplay() == null ) {
			return super.toString();
		}
		
		return this.getDisplay();
	}
	
}
