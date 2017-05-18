package org.wdh.hawk;

import com.toedter.calendar.JDateChooser;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class AdultDataDialog extends JDialog {
	private JPanel jPanel1;
	private JTextField lastNameTextField;
	private JButton newButton;
	private JPanel jPanel10;
	private JDateChooser dobDateChooser;
	private JTable adultsTable;
	private JScrollPane jScrollPane1;
	private JPanel jPanel9;
	private JButton delButton;
	private JPanel adultsBtnsPanel;
	private JPanel jPanel8;
	private JButton addButton;
	private JPanel jPanel7;
	private JComboBox genderComboBox;
	private JPanel jPanel6;
	private JPanel jPanel5;
	private JPanel jPanel4;
	private JTextField firstNameTextField;
	private JPanel jPanel3;
	private JPanel jPanel2;
	List<AdultInfo> entries;
	AdultsTableModel adultsTableModel;

	public static void main(String[] paramArrayOfString) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame localJFrame = new JFrame();
				AdultDataDialog localAdultDataDialog = new AdultDataDialog(localJFrame, null);
				localAdultDataDialog.setVisible(true);
				localAdultDataDialog.setSize(594, 392);
			}
		});
	}

	public AdultDataDialog(JFrame paramJFrame, List<AdultInfo> paramList) {
		super(paramJFrame);
		this.entries = paramList;
		initGUI();
	}

	private void initGUI() {
		try {
			GridBagLayout localGridBagLayout1 = new GridBagLayout();
			localGridBagLayout1.rowWeights = new double[]{0.1D};
			localGridBagLayout1.rowHeights = new int[]{7};
			localGridBagLayout1.columnWeights = new double[]{0.1D, 0.1D};
			localGridBagLayout1.columnWidths = new int[]{7, 7};
			localGridBagLayout1.columnWeights = new double[]{0.1D, 0.1D};
			localGridBagLayout1.rowWeights = new double[]{0.1D, 0.1D};
			localGridBagLayout1.rowHeights = new int[]{7, 7};
			getContentPane().setLayout(localGridBagLayout1);
			setPreferredSize(new Dimension(594, 352));
			this.jPanel1 = new JPanel();
			GridBagLayout localGridBagLayout2 = new GridBagLayout();
			localGridBagLayout2.columnWidths = new int[]{7};
			localGridBagLayout2.rowHeights = new int[]{7, 7, 7, 7, 7};
			localGridBagLayout2.columnWeights = new double[]{0.1D};
			localGridBagLayout2.rowWeights = new double[]{0.1D, 0.1D, 0.1D, 0.1D, 0.1D};
			getContentPane().add(this.jPanel1, new GridBagConstraints(0, 0, 1, 1, 25.0D, 0.0D, 10, 1, new Insets(10, 10, 0, 10), 0, 0));
			this.jPanel1.setLayout(localGridBagLayout2);
			this.jPanel1.setBorder(BorderFactory.createTitledBorder("Edit Adult"));
			this.jPanel1.setPreferredSize(new Dimension(175, 115));
			this.jPanel2 = new JPanel();
			GridBagLayout localGridBagLayout3 = new GridBagLayout();
			localGridBagLayout3.columnWidths = new int[]{7};
			localGridBagLayout3.rowHeights = new int[]{7};
			localGridBagLayout3.columnWeights = new double[]{0.1D};
			localGridBagLayout3.rowWeights = new double[]{0.1D};
			this.jPanel1.add(this.jPanel2, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 10, 2, new Insets(0, 0, 0, 0), 0, 0));
			this.jPanel2.setLayout(localGridBagLayout3);
			this.jPanel2.setBorder(BorderFactory.createTitledBorder("Last Name"));
			this.lastNameTextField = new JTextField();
			this.jPanel2.add(this.lastNameTextField, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 10, 2, new Insets(0, 0, 0, 0), 0, 0));
			this.jPanel3 = new JPanel();
			localGridBagLayout3 = new GridBagLayout();
			localGridBagLayout3.columnWidths = new int[]{7};
			localGridBagLayout3.rowHeights = new int[]{7};
			localGridBagLayout3.columnWeights = new double[]{0.1D};
			localGridBagLayout3.rowWeights = new double[]{0.1D};
			this.jPanel1.add(this.jPanel3, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 10, 2, new Insets(0, 0, 0, 0), 0, 0));
			this.jPanel3.setLayout(localGridBagLayout3);
			this.jPanel3.setBorder(BorderFactory.createTitledBorder("First Name"));
			this.firstNameTextField = new JTextField();
			this.jPanel3.add(this.firstNameTextField, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 10, 2, new Insets(0, 0, 0, 0), 0, 0));
			this.jPanel4 = new JPanel();
			localGridBagLayout3 = new GridBagLayout();
			localGridBagLayout3.columnWidths = new int[]{7, 7};
			localGridBagLayout3.rowHeights = new int[]{7};
			localGridBagLayout3.columnWeights = new double[]{0.1D, 0.1D};
			localGridBagLayout3.rowWeights = new double[]{0.1D};
			this.jPanel1.add(this.jPanel4, new GridBagConstraints(0, 2, 1, 1, 0.0D, 0.0D, 10, 1, new Insets(0, 0, 0, 0), 0, 0));
			this.jPanel4.setLayout(localGridBagLayout3);
			this.jPanel5 = new JPanel();
			GridBagLayout localGridBagLayout4 = new GridBagLayout();
			localGridBagLayout4.columnWidths = new int[]{7};
			localGridBagLayout4.rowHeights = new int[]{7};
			localGridBagLayout4.columnWeights = new double[]{0.1D};
			localGridBagLayout4.rowWeights = new double[]{0.1D};
			this.jPanel4.add(this.jPanel5, new GridBagConstraints(0, 0, 1, 1, 100.0D, 0.0D, 10, 1, new Insets(0, 0, 0, 0), 0, 0));
			this.jPanel5.setLayout(localGridBagLayout4);
			this.jPanel5.setBorder(BorderFactory.createTitledBorder("DOB"));
			this.jPanel5.setPreferredSize(new Dimension(200, 38));
			this.dobDateChooser = new JDateChooser();
			this.jPanel5.add(this.dobDateChooser, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 10, 2, new Insets(0, 0, 0, 0), 0, 0));
			this.jPanel6 = new JPanel();
			localGridBagLayout4 = new GridBagLayout();
			localGridBagLayout4.columnWidths = new int[]{7};
			localGridBagLayout4.rowHeights = new int[]{7};
			localGridBagLayout4.columnWeights = new double[]{0.1D};
			localGridBagLayout4.rowWeights = new double[]{0.1D};
			this.jPanel4.add(this.jPanel6, new GridBagConstraints(1, 0, 1, 1, 0.0D, 0.0D, 10, 1, new Insets(0, 0, 0, 0), 0, 0));
			this.jPanel6.setLayout(localGridBagLayout4);
			this.jPanel6.setBorder(BorderFactory.createTitledBorder("Gender"));
			DefaultComboBoxModel localDefaultComboBoxModel = new DefaultComboBoxModel(new String[]{"Male", "Female"});
			this.genderComboBox = new JComboBox();
			this.jPanel6.add(this.genderComboBox, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 10, 0, new Insets(0, 0, 0, 0), 0, 0));
			this.genderComboBox.setModel(localDefaultComboBoxModel);
			this.jPanel10 = new JPanel();
			localGridBagLayout3 = new GridBagLayout();
			this.jPanel1.add(this.jPanel10, new GridBagConstraints(0, 3, 1, 1, 0.0D, 0.0D, 10, 2, new Insets(5, 0, 0, 0), 0, 0));
			localGridBagLayout3.rowWeights = new double[]{0.1D};
			localGridBagLayout3.rowHeights = new int[]{7};
			localGridBagLayout3.columnWeights = new double[]{0.1D, 0.1D};
			localGridBagLayout3.columnWidths = new int[]{7, 7};
			this.jPanel10.setLayout(localGridBagLayout3);
			this.addButton = new JButton();
			this.jPanel10.add(this.addButton, new GridBagConstraints(1, 0, 1, 1, 0.0D, 0.0D, 10, 2, new Insets(0, 0, 0, 0), 0, 0));
			this.addButton.setText("Add");
			this.addButton.setPreferredSize(new Dimension(75, 30));
			this.addButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/Add.png")));
			this.addButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
					AdultDataDialog.this.addButtonActionPerformed(paramAnonymousActionEvent);
				}
			});
			this.newButton = new JButton();
			this.jPanel10.add(this.newButton, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 10, 2, new Insets(0, 0, 0, 0), 0, 0));
			this.newButton.setText("New");
			this.newButton.setPreferredSize(new Dimension(75, 30));
			this.newButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/New.png")));
			this.newButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
					AdultDataDialog.this.newButtonActionPerformed(paramAnonymousActionEvent);
				}
			});
			this.jPanel8 = new JPanel();
			this.jPanel1.add(this.jPanel8, new GridBagConstraints(0, 4, 1, 1, 0.0D, 100.0D, 10, 3, new Insets(0, 0, 0, 0), 0, 0));
			this.jPanel7 = new JPanel();
			localGridBagLayout2 = new GridBagLayout();
			localGridBagLayout2.columnWidths = new int[]{7};
			localGridBagLayout2.rowHeights = new int[]{7, 7};
			localGridBagLayout2.columnWeights = new double[]{0.1D};
			localGridBagLayout2.rowWeights = new double[]{0.1D, 0.1D};
			getContentPane().add(this.jPanel7, new GridBagConstraints(1, 0, 1, 1, 75.0D, 100.0D, 10, 1, new Insets(10, 0, 0, 10), 0, 0));
			this.jPanel7.setLayout(localGridBagLayout2);
			this.jPanel7.setBorder(BorderFactory.createTitledBorder("Adults"));
			this.adultsBtnsPanel = new JPanel();
			localGridBagLayout3 = new GridBagLayout();
			localGridBagLayout3.columnWidths = new int[]{7, 7, 7};
			localGridBagLayout3.rowHeights = new int[]{7};
			localGridBagLayout3.columnWeights = new double[]{0.1D, 0.1D, 0.1D};
			localGridBagLayout3.rowWeights = new double[]{0.1D};
			this.jPanel7.add(this.adultsBtnsPanel, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 15, 2, new Insets(0, 0, 0, 10), 0, 0));
			this.adultsBtnsPanel.setLayout(localGridBagLayout3);
			this.delButton = new JButton();
			this.adultsBtnsPanel.add(this.delButton, new GridBagConstraints(2, 0, 1, 1, 0.0D, 0.0D, 10, 0, new Insets(10, 0, 5, 0), 0, 0));
			this.delButton.setText("Delete");
			this.delButton.setPreferredSize(new Dimension(100, 30));
			this.delButton.setToolTipText("Delete Adult entry");
			this.delButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/Delete.png")));
			this.delButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
					AdultDataDialog.this.delButtonActionPerformed(paramAnonymousActionEvent);
				}
			});
			this.delButton.setEnabled(false);
			this.jPanel9 = new JPanel();
			this.adultsBtnsPanel.add(this.jPanel9, new GridBagConstraints(0, 0, 1, 1, 100.0D, 0.0D, 10, 2, new Insets(0, 0, 0, 0), 0, 0));
			this.jScrollPane1 = new JScrollPane();
			this.jPanel7.add(this.jScrollPane1, new GridBagConstraints(0, 0, 1, 1, 0.0D, 100.0D, 10, 1, new Insets(0, 0, 0, 0), 0, 0));
			this.adultsTableModel = new AdultsTableModel(this.entries);
			this.adultsTable = new JTable();
			this.jScrollPane1.setViewportView(this.adultsTable);
			this.adultsTable.setModel(this.adultsTableModel);
			this.adultsTable.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent paramAnonymousMouseEvent) {
					AdultDataDialog.this.adultsTableMouseClicked(paramAnonymousMouseEvent);
				}
			});
			setSize(594, 352);
		} catch (Exception localException) {
			localException.printStackTrace();
		}
	}

	public List<AdultInfo> getEntries() {
		return this.entries;
	}

	public void setEntries(List<AdultInfo> paramList) {
		this.entries = paramList;
	}

	private void addButtonActionPerformed(ActionEvent paramActionEvent) {
		AdultInfo localAdultInfo1 = new AdultInfo();
		if (scrape(localAdultInfo1)) {
			if (this.addButton.getText().equals("Edit")) {
				int i = this.adultsTable.getSelectedRow();
				AdultInfo localAdultInfo2 = this.adultsTableModel.getObjectAtRow(i);
				localAdultInfo2.setValues(localAdultInfo1);
				this.adultsTableModel.refresh();
				ListSelectionModel localListSelectionModel = this.adultsTable.getSelectionModel();
			} else {
				this.entries.add(localAdultInfo1);
				this.adultsTableModel.refresh();
			}
		}
		clear();
		this.addButton.setText("Add");
		this.delButton.setEnabled(false);
	}

	private boolean scrape(AdultInfo paramAdultInfo) {
		String str1 = this.lastNameTextField.getText();
		String str2 = this.firstNameTextField.getText();
		String str3 = (String) this.genderComboBox.getSelectedItem();
		if ((!checkString(str1)) || (!checkString(str2)) || (!checkString(str3))) {
			return false;
		}
		Date localDate = this.dobDateChooser.getDate();
		if (localDate == null) {
			return false;
		}
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat();
		localSimpleDateFormat.applyPattern("MM/dd/yyyy");
		String str4 = localSimpleDateFormat.format(localDate);
		paramAdultInfo.setLastName(str1);
		paramAdultInfo.setFirstName(str2);
		paramAdultInfo.setSex(str3);
		paramAdultInfo.setDob(str4);
		return true;
	}

	private boolean checkString(String paramString) {
		return (paramString != null) && (paramString.length() != 0);
	}

	private void populate(AdultInfo paramAdultInfo) {
		this.lastNameTextField.setText(paramAdultInfo.getLastName());
		this.firstNameTextField.setText(paramAdultInfo.getFirstName());
		Date localDate = null;
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat();
		localSimpleDateFormat.applyPattern("MM/dd/yyyy");
		try {
			localDate = localSimpleDateFormat.parse(paramAdultInfo.getDob());
			this.dobDateChooser.setDate(localDate);
		} catch (ParseException localParseException) {
			localParseException.printStackTrace();
		}
		if (paramAdultInfo.getSex().equals("Male")) {
			this.genderComboBox.setSelectedIndex(0);
		} else {
			this.genderComboBox.setSelectedIndex(1);
		}
	}

	private void clear() {
		this.lastNameTextField.setText("");
		this.firstNameTextField.setText("");
		this.genderComboBox.setSelectedIndex(0);
		this.dobDateChooser.setDate(new Date());
		this.delButton.setEnabled(false);
	}

	private void adultsTableMouseClicked(MouseEvent paramMouseEvent) {
		int i = this.adultsTable.getSelectedRow();
		AdultInfo localAdultInfo = this.adultsTableModel.getObjectAtRow(i);
		this.addButton.setText("Edit");
		this.delButton.setEnabled(true);
		populate(localAdultInfo);
	}

	private void newButtonActionPerformed(ActionEvent paramActionEvent) {
		this.adultsTableModel.refresh();
		this.addButton.setText("Add");
		clear();
	}

	private void delButtonActionPerformed(ActionEvent paramActionEvent) {
		int i = this.adultsTable.getSelectedRow();
		AdultInfo localAdultInfo = this.adultsTableModel.getObjectAtRow(i);
		this.entries.remove(localAdultInfo);
		this.adultsTableModel.refresh();
	}
}

/*
 * Location: C:\Program Files
 * (x86)\Hawk\Hawk.jar!\org\wdh\hawk\AdultDataDialog.class Java compiler
 * version: 7 (51.0) JD-Core Version: 0.7.1
 */