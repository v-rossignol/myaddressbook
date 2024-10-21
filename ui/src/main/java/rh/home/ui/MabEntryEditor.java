/**
 * 
 */
package rh.home.ui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import org.apache.logging.log4j.util.Strings;

import rh.home.data.MabEntry;

/**
 * dialog used to create / modify My Address Book entries.
 * @author Vincent ROSSIGNOL 
 * @since ui version 0.0.1
 * @version 0.0.1
 */
public class MabEntryEditor {

	/**
	 * edited entry.
	 */
	private final MabEntry entry;
	
	/**
	 * associated {@link JPanel}.
	 */
	private JPanel panel = null;
	
	/**
	 * text area used for address.
	 */
	private JTextArea tfAddress = null;
	
	/**
	 * text field used for display.
	 */
	private JTextField tfDisplay = null; 
	
	/**
	 * text field used for email.
	 */
	private JTextField tfEmail = null;
	
	/**
	 * text field used for first name.
	 */
	private JTextField tfFirstName = null;
	
	/**
	 * text field used for name.
	 */
	private JTextField tfLastName = null; 
	
	/**
	 * default constructor.
	 */
	public MabEntryEditor() {
		this( new MabEntry() );
	}
	
	/**
	 * constructor.
	 * @param entry a valid {@link MabEntry} instance.
	 */
	public MabEntryEditor( MabEntry entry ) {
		super();
		this.entry = entry;
	} 
	
	/**
	 * associated entry.
	 * @return a valid {@link MabEntry} instance.
	 */
	public MabEntry getEntry() {
		return this.entry;
	}
	
	/**
	 * associated {@link JPanel}
	 * @return a valid {@link JPanel} instance.
	 */
	protected JPanel getFieldPanel() {
		if ( this.panel == null ) {
			this.panel = new JPanel( new GridLayout( 0, 1 ) );
		}
		return this.panel;
	}
	
	/**
	 * text area used for address.
	 * @return a valid {@link JTextField} instance.
	 */
	public JTextArea getTextAreaAddress() {
		if ( this.tfAddress == null ) {
			this.tfAddress = new JTextArea( 3, 128 );
		}
		return this.tfAddress;
	}
	
	/**
	 * text field used for display.
	 * @return a valid {@link JTextField} instance.
	 */
	public JTextField getTextFieldDisplay() {
		if ( this.tfDisplay == null ) {
			this.tfDisplay = new JTextField( 64 );
		}
		return this.tfDisplay;
	}
	
	/**
	 * text field used for email.
	 * @return a valid {@link JTextField} instance.
	 */
	public JTextField getTextFieldEmail() {
		if ( this.tfEmail == null ) {
			this.tfEmail = new JTextField( 128 );
		}
		return this.tfEmail;
	}
	
	/**
	 * test field used for first name.
	 * @return a valid {@link JTextField} instance. 
	 */
	public JTextField getTextFieldFirstName() {
		if ( this.tfFirstName == null ) {
			this.tfFirstName = new JTextField( 32 );
		}
		return this.tfFirstName;
	}
	
	/**
	 * test field used for name.
	 * @return a valid {@link JTextField} instance. 
	 */
	public JTextField getTextFieldLastName() {
		if ( this.tfLastName == null ) {
			this.tfLastName = new JTextField( 32 );
		}
		return this.tfLastName;
	}
	
	/**
	 * displays the current dialog (modal)
	 * @return button clicked by user ({@link JOptionPane#OK_OPTION} or {@link JOptionPane#CANCEL_OPTION})
	 */
	public int show() {
		
		this.getFieldPanel().add( new JLabel( "First name") );
		this.getFieldPanel().add( this.getTextFieldFirstName() );
		if ( this.getEntry().getFirstName() != null ) {
			this.getTextFieldFirstName().setText( this.getEntry().getFirstName() );
		}
		
		this.getFieldPanel().add( new JLabel( "Last name" ) );
		this.getFieldPanel().add( this.getTextFieldLastName() );
		if ( this.getEntry().getName() != null ) {
			this.getTextFieldLastName().setText( this.getEntry().getName() );
		}
		
		this.getFieldPanel().add( new JLabel( "Email") );
		this.getFieldPanel().add( this.getTextFieldEmail() );
		if ( this.getTextFieldEmail() != null ) {
			this.getTextFieldEmail().setText( this.getEntry().getEmail() );
		}
		
		this.getFieldPanel().add( new JLabel( "Address") );
		this.getFieldPanel().add( this.getTextAreaAddress() );
		if ( this.getTextAreaAddress() != null ) {
			this.getTextAreaAddress().setText( this.getEntry().getAddress() );
		}
		
		this.getFieldPanel().add( new JLabel( "Display") );
		this.getFieldPanel().add( this.getTextFieldDisplay() );
		if ( this.getTextFieldDisplay() != null ) {
			this.getTextFieldDisplay().setText( this.getEntry().getDisplay() );
		}
		
		int result = JOptionPane.showConfirmDialog( null, this.getFieldPanel(), "Entry", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE );
		
		if ( result == JOptionPane.OK_OPTION ) {
			this.getEntry().setFirstName( getText( this.getTextFieldFirstName() ) );
			this.getEntry().setName( getText( this.getTextFieldLastName() ) );
			this.getEntry().setDisplay( getText( this.getTextFieldDisplay() ) );
			this.getEntry().setEmail( getText( this.getTextFieldEmail() ) );
			this.getEntry().setAddress( getText( this.getTextAreaAddress() ) );
		}
		
		return result;
	}

	/**
	 * gets the text from a text component.
	 * @param component a valid {@link JTextComponent} instance.
	 * @return a valid {@link Strings} instance or <code>null</code> if the text is empty. 
	 */
	protected static String getText( JTextComponent component ) {
		
		if ( component == null ) {
			return null;
		}
		
		if ( Strings.isBlank( component.getText() ) ) {
			return null;
		}
		
		return component.getText();
	}
	
}
