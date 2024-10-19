/**
 * 
 */
package rh.home.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;

import rh.home.data.MabEntry;
import rh.home.services.IMabServices;

/**
 * component used to display entry list.
 * @author Vincent ROSSIGNOL
 * @since ui version 0.0.1
 * @version 0.0.1
 */
public class MabEntryList extends JList<MabEntry> {

	/**
	 * version UID for serialization.
	 */
	private static final long serialVersionUID = 3890230822619335940L;
	
	/**
	 * current entry list.
	 */
	private List<MabEntry> entries = new ArrayList<MabEntry>();
	
	/**
	 * associated services.
	 */
	private final IMabServices services;
	

	/**
	 * constructor.
	 */
	public MabEntryList( IMabServices services ) {
		
		super();
		
		assert services != null : "invalid services: null isn't allowed.";
		this.services = services;
		
	}
	
	/**
	 * get current entry list.
	 * @return a valid {@link List} of {@link MabEntry} instances.
	 */
	protected List<MabEntry> getEntries() {
		return this.entries;
	}
	
	/**
	 * retrieves the entry corresponding to a given index.
	 * @param index an integer value.
	 * @return a valid {@link MabEntry} or <code>null</code> if no entry corresponds the index.
	 */
	public MabEntry getEntry( int index ) {
		
		if ( index < 0 || index > this.getEntries().size() ) {
			return null;
		}
		
		return this.getEntries().get(index);
	}
	
	/**
	 * retrieves and returns the currently selected entry. 
	 * @return a valid {@link MabEntry} instance or <code>null</code> if no entry is selected.
	 */
	public MabEntry getSelectedEntry() {
		int index = this.getSelectedIndex();
		return this.getEntry(index);
	}
	
	/**
	 * associated services.
	 * @return a valid {@link IMabServices} instance.
	 */
	protected final IMabServices getServices() {
		return this.services;
	}
	
	/**
	 * refreshes the entry list.
	 */
	public void refresh() {
		
		/* just to help the GC */
		this.getEntries().clear();
	
		/* new entries */
		this.entries = this.getServices().getEntryService().entries();
		
		/* setting list model */
		this.setModel( this.getNewModel());
		
	}
	
	/**
	 * builds and returns a new list model corresponding to the current entry list.
	 * @return a valid {@link ListModel} of {@link MabEntry} instances.
	 */
	private ListModel<MabEntry> getNewModel() {
		
		DefaultListModel<MabEntry> result = new DefaultListModel<>();
		
		for ( MabEntry current : this.getEntries() ) {
			result.addElement(current);
		}
		
		return result;
		
	}

	

}
