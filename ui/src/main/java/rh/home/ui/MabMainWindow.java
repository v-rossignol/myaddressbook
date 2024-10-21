/**
 * 
 */
package rh.home.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rh.home.configuration.MabConfiguration;
import rh.home.data.MabEntry;
import rh.home.services.IMabServices;
import rh.home.services.impl.MabServices;

/**
 * main window for My Address Book application.
 * 
 * @author Vincent ROSSIGNOL
 * @since ui version 0.0.1
 * @version 0.0.1
 */
@Component
public class MabMainWindow extends JFrame {

	/**
	 * default frame size (height and width) in pixel.
	 */
	public static final int FRAME_SIZE = 400;

	/**
	 * version UID for serialization.
	 */
	private static final long serialVersionUID = 189760929313520636L;

	/**
	 * button used to add an entry.
	 */
	private JButton btnAdd = null;

	/**
	 * button used to delete an entry.
	 */
	private JButton btnDelete = null;

	/**
	 * associated control panel.
	 */
	private JPanel controls = null;

	/**
	 * associated entry list.
	 */
	private MabEntryList entries = null;

	/**
	 * associated services.
	 */
	@Autowired
	private MabServices services;

	/**
	 * constructor.
	 */
	public MabMainWindow() {
		super(MabConfiguration.getInstance().getApplicationName());
	}

	/**
	 * button used to add an entry.
	 * 
	 * @return a valid {@link JButton} instance.
	 */
	protected JButton getAddButton() {
		if (this.btnAdd == null) {

			this.btnAdd = new JButton("+");
			this.btnAdd.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					onAddButtonClicked();
				}
			});
		}
		return this.btnAdd;
	}

	/**
	 * associated control panel.
	 * 
	 * @return a valid {@link JPanel} instance.
	 */
	protected JPanel getControlPanel() {

		if (this.controls == null) {

			this.controls = new JPanel();

			this.controls.add(this.getAddButton());
			this.controls.add(this.getDeleteButton());

		}

		return this.controls;
	}

	/**
	 * button used to delete an entry.
	 * 
	 * @return a valid JButton instance.
	 */
	protected JButton getDeleteButton() {
		if (this.btnDelete == null) {
			this.btnDelete = new JButton("-");
			this.btnDelete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					onDeleteButtonClicked();
				}
			});
		}
		return this.btnDelete;
	}

	/**
	 * associated entry list.
	 * 
	 * @return a valid {@link MabEntryList} instance.
	 */
	protected MabEntryList getEntryList() {
		if (this.entries == null) {
			this.entries = new MabEntryList(this.getServices());
			this.entries.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2) {
						onEntryListDoubleClicked(e);
					}

				}
			});
		}
		return this.entries;
	}

	/**
	 * associated services.
	 * 
	 * @return a valid {@link IMabServices} instance.
	 */
	protected IMabServices getServices() {
		return this.services;
	}

	/**
	 * method call when user clicks on "Add" button.
	 */
	private void onAddButtonClicked() {
		MabEntryEditor editor = new MabEntryEditor();
		if (editor.show() == JOptionPane.OK_OPTION) {
			this.getServices().getEntryService().create(editor.getEntry());
			this.getEntryList().refresh();
		}
	}

	/**
	 * method to be called when user clicks on "Delete" button.
	 */
	private void onDeleteButtonClicked() {
		MabEntry entry = this.getEntryList().getSelectedEntry();
		if (entry != null) {
			this.getServices().getEntryService().delete(entry);
			this.getEntryList().refresh();
		}

	}

	/**
	 * method called when used double click in the entry list.
	 * 
	 * @param event a valid {@link MouseEvent} instance.
	 */
	private synchronized void onEntryListDoubleClicked(MouseEvent event) {
		int index = this.getEntryList().locationToIndex(event.getPoint());

		MabEntry entry = this.getEntryList().getEntry(index);

		if (entry != null) {

			MabEntryEditor editor = new MabEntryEditor(entry);
			if (editor.show() == JOptionPane.OK_OPTION) {
				this.getServices().getEntryService().create(editor.getEntry());
				this.getEntryList().refresh();
			}

		}
	}

	/**
	 * configures and displays current frame.
	 */
	public void refresh() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FRAME_SIZE, FRAME_SIZE);

		/* adding Components to the frame */
		this.getContentPane().add(BorderLayout.SOUTH, this.getControlPanel());
		this.getContentPane().add(BorderLayout.CENTER, this.getEntryList());

		/* displaying entries */
		this.getEntryList().refresh();
		
	}

}
