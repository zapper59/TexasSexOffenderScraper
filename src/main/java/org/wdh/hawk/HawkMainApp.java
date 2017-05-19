package org.wdh.hawk;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class HawkMainApp extends JFrame {
	TXSexualOffender check;
	private List<AdultInfo> entries = null;
	boolean print = true;
	private JMenuItem helpMenuItem;
	private JMenu jMenu5;
	private JPanel jPanel3;
	private JScrollPane resultsScrollPane;
	private JPanel jPanel2;
	private JButton loadCsvButton;
	private JPanel jPanel1;
	private JScrollPane buttonsScrollPane;
	private JMenuItem aboutMenuItem;
	private JSeparator jSeparator3;
	private JMenu jMenu4;
	private JMenuItem exitMenuItem;
	private JSeparator jSeparator2;
	private JMenuItem saveMenuItem;
	private JTree resultsTree;
	private JPanel jPanel6;
	private JLabel fileLabel;
	private JLabel logoLabel;
	private JPanel jPanel5;
	private JPanel jPanel4;
	private JMenuItem openFileMenuItem;
	private JMenuItem newFileMenuItem;
	private JMenu jMenu3;
	private JMenuBar jMenuBar1;
	DefaultMutableTreeNode root;
	private JCheckBoxMenuItem printCheckBoxMenuItem;
	private JCheckBoxMenuItem onlyCheckNewEntriesCheckBoxMenuItem;
	private JButton startChecks;
	private JButton exportTsvButton;
	private JButton adultEditButton;
	private boolean onlyCheckNewEntries;

	public static void main(String[] paramArrayOfString) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				HawkMainApp localHawkMainApp = new HawkMainApp();
				localHawkMainApp.setLocationRelativeTo(null);
				localHawkMainApp.setVisible(true);
			}
		});
	}

	public HawkMainApp() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Exception localException) {
			localException.printStackTrace();
		}
		this.onlyCheckNewEntries = true;
		initGUI();
	}

	private void initGUI() {
		try {
			JFileChooser localJFileChooser = new JFileChooser();
			this.entries = new ArrayList();
			setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/hawk_icon_32x32.jpg")).getImage());
			GridBagLayout localGridBagLayout1 = new GridBagLayout();
			setTitle("Hawk - Texas Sexual Offender Database Automated Search");
			localGridBagLayout1.rowWeights = new double[]{0.1D};
			localGridBagLayout1.rowHeights = new int[]{7};
			localGridBagLayout1.columnWeights = new double[]{0.1D};
			localGridBagLayout1.columnWidths = new int[]{7};
			getContentPane().setLayout(localGridBagLayout1);
			this.jPanel2 = new JPanel();
			GridBagLayout localGridBagLayout2 = new GridBagLayout();
			getContentPane().add(this.jPanel2, new GridBagConstraints(0, 0, 1, 1, 100.0D, 100.0D, 10, 1, new Insets(0, 0, 0, 0), 0, 0));
			localGridBagLayout2.rowWeights = new double[]{0.1D};
			localGridBagLayout2.rowHeights = new int[]{7};
			localGridBagLayout2.columnWeights = new double[]{0.1D, 0.1D};
			localGridBagLayout2.columnWidths = new int[]{7, 7};
			this.jPanel2.setLayout(localGridBagLayout2);
			this.resultsScrollPane = new JScrollPane();
			this.jPanel2.add(this.resultsScrollPane,
					new GridBagConstraints(1, 0, 1, 1, 100.0D, 100.0D, 10, 1, new Insets(0, 0, 0, 0), 0, 0));
			this.jPanel4 = new JPanel();
			GridBagLayout localGridBagLayout3 = new GridBagLayout();
			localGridBagLayout3.columnWidths = new int[]{7};
			localGridBagLayout3.rowHeights = new int[]{7, 7};
			localGridBagLayout3.columnWeights = new double[]{0.1D};
			localGridBagLayout3.rowWeights = new double[]{0.1D, 0.1D};
			this.resultsScrollPane.setViewportView(this.jPanel4);
			this.jPanel4.setLayout(localGridBagLayout3);
			this.jPanel5 = new JPanel();
			GridBagLayout localGridBagLayout4 = new GridBagLayout();
			localGridBagLayout4.columnWidths = new int[]{7, 7};
			localGridBagLayout4.rowHeights = new int[]{7, 7};
			localGridBagLayout4.columnWeights = new double[]{0.1D, 0.1D};
			localGridBagLayout4.rowWeights = new double[]{0.1D, 0.1D};
			this.jPanel4.add(this.jPanel5, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 10, 1, new Insets(0, 0, 0, 0), 0, 0));
			this.jPanel5.setLayout(localGridBagLayout4);
			this.logoLabel = new JLabel();
			this.jPanel5.add(this.logoLabel, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 11, 0, new Insets(0, 0, 0, 0), 0, 0));
			this.logoLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/hawk_icon_64x64.jpg")));
			this.logoLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent paramAnonymousMouseEvent) {
					HawkMainApp.this.logoLabelMouseClicked(paramAnonymousMouseEvent);
				}
			});
			this.fileLabel = new JLabel();
			this.jPanel5.add(this.fileLabel, new GridBagConstraints(1, 0, 1, 1, 100.0D, 0.0D, 11, 2, new Insets(10, 5, 0, 0), 0, 0));
			this.fileLabel.setFont(new Font("Tahoma", 1, 14));
			this.fileLabel.setVerticalAlignment(1);
			this.fileLabel.setVerticalTextPosition(1);
			this.root = new DefaultMutableTreeNode("Results");
			DefaultTreeCellRenderer localDefaultTreeCellRenderer = new DefaultTreeCellRenderer();
			localDefaultTreeCellRenderer.setBackgroundNonSelectionColor(new Color(238, 238, 238));
			this.resultsTree = new JTree(this.root);
			this.jPanel5.add(this.resultsTree, new GridBagConstraints(1, 1, 1, 1, 0.0D, 0.0D, 10, 1, new Insets(0, 0, 0, 0), 0, 0));
			this.resultsTree.setBackground(new Color(238, 238, 238));
			this.resultsTree.setFont(new Font("Tahoma", 0, 14));
			this.resultsTree.setCellRenderer(localDefaultTreeCellRenderer);
			this.resultsTree.setVisible(false);
			this.jPanel6 = new JPanel();
			this.jPanel4.add(this.jPanel6, new GridBagConstraints(0, 1, 1, 1, 0.0D, 100.0D, 10, 0, new Insets(0, 0, 0, 0), 0, 0));
			this.buttonsScrollPane = new JScrollPane();
			this.jPanel2
					.add(this.buttonsScrollPane, new GridBagConstraints(0, 0, 1, 1, 50.0D, 100.0D, 10, 1, new Insets(0, 0, 0, 0), 0, 0));
			this.buttonsScrollPane.setPreferredSize(new Dimension(175, 250));
			this.buttonsScrollPane.setHorizontalScrollBarPolicy(31);
			this.jPanel1 = new JPanel();
			localGridBagLayout3 = new GridBagLayout();
			localGridBagLayout3.columnWidths = new int[]{7};
			localGridBagLayout3.rowHeights = new int[]{7, 7, 7, 7, 7};
			localGridBagLayout3.columnWeights = new double[]{0.1D};
			localGridBagLayout3.rowWeights = new double[]{0.1D, 0.1D, 0.1D, 0.1D, 0.1D};
			this.buttonsScrollPane.setViewportView(this.jPanel1);
			this.jPanel1.setLayout(localGridBagLayout3);
			this.jPanel1.setPreferredSize(new Dimension(175, 229));
			this.jPanel1.setSize(100, 245);
			this.loadCsvButton = new JButton();
			this.jPanel1.add(this.loadCsvButton, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 10, 2, new Insets(10, 10, 0, 10), 0, 0));
			this.loadCsvButton.setText("Load TSV File");
			this.loadCsvButton.setPreferredSize(new Dimension(150, 40));
			this.loadCsvButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/CsvImport.png")));
			this.loadCsvButton.setHorizontalAlignment(2);
			this.loadCsvButton.setFont(new Font("Tahoma", 1, 12));
			this.loadCsvButton.setIconTextGap(10);
			this.loadCsvButton.setFocusPainted(false);
			this.loadCsvButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
					HawkMainApp.this.loadCsvButtonActionPerformed(paramAnonymousActionEvent);
				}
			});
			this.jPanel3 = new JPanel();
			this.jPanel1.add(this.jPanel3, new GridBagConstraints(0, 4, 1, 1, 0.0D, 100.0D, 10, 1, new Insets(0, 0, 0, 0), 0, 0));
			this.adultEditButton = new JButton();
			this.jPanel1.add(this.adultEditButton, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 10, 2, new Insets(5, 10, 0, 10), 0, 0));
			this.adultEditButton.setText("Edit Adults");
			this.adultEditButton.setPreferredSize(new Dimension(150, 40));
			this.adultEditButton.setFont(new Font("Tahoma", 1, 12));
			this.adultEditButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/AdultEdit.png")));
			this.adultEditButton.setHorizontalAlignment(2);
			this.adultEditButton.setIconTextGap(10);
			this.adultEditButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
					HawkMainApp.this.adultEditButtonActionPerformed(paramAnonymousActionEvent);
				}
			});
			this.exportTsvButton = new JButton();
			this.jPanel1.add(this.exportTsvButton, new GridBagConstraints(0, 2, 1, 1, 0.0D, 0.0D, 10, 2, new Insets(5, 10, 0, 10), 0, 0));
			this.exportTsvButton.setText("Export TSV");
			this.exportTsvButton.setPreferredSize(new Dimension(150, 40));
			this.exportTsvButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/export.png")));
			this.exportTsvButton.setHorizontalAlignment(2);
			this.exportTsvButton.setIconTextGap(10);
			this.exportTsvButton.setFont(new Font("Tahoma", 1, 12));
			this.exportTsvButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
					HawkMainApp.this.exportTsvButtonActionPerformed(paramAnonymousActionEvent);
				}
			});
			this.startChecks = new JButton();
			this.jPanel1.add(this.startChecks, new GridBagConstraints(0, 3, 1, 1, 0.0D, 0.0D, 10, 2, new Insets(5, 10, 0, 10), 0, 0));
			this.startChecks.setText("Start");
			this.startChecks.setOpaque(false);
			this.startChecks.setPreferredSize(new Dimension(150, 40));
			this.startChecks.setHorizontalAlignment(2);
			this.startChecks.setIconTextGap(10);
			this.startChecks.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/people.png")));
			this.startChecks.setFont(new Font("Tahoma", 1, 12));
			this.startChecks.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
					HawkMainApp.this.startChecksActionPerformed(paramAnonymousActionEvent);
				}
			});
			setSize(554, 300);
			this.jMenuBar1 = new JMenuBar();
			setJMenuBar(this.jMenuBar1);
			this.jMenu3 = new JMenu();
			this.jMenuBar1.add(this.jMenu3);
			this.jMenu3.setText("File");
			this.newFileMenuItem = new JMenuItem();
			this.jMenu3.add(this.newFileMenuItem);
			this.newFileMenuItem.setText("New");
			this.openFileMenuItem = new JMenuItem();
			this.jMenu3.add(this.openFileMenuItem);
			this.openFileMenuItem.setText("Open");
			this.openFileMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
					HawkMainApp.this.openFileMenuItemActionPerformed(paramAnonymousActionEvent);
				}
			});
			this.saveMenuItem = new JMenuItem();
			this.jMenu3.add(this.saveMenuItem);
			this.saveMenuItem.setText("Save");
			this.saveMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
					HawkMainApp.this.saveMenuItemActionPerformed(paramAnonymousActionEvent);
				}
			});
			this.jSeparator2 = new JSeparator();
			this.jMenu3.add(this.jSeparator2);
			this.exitMenuItem = new JMenuItem();
			this.jMenu3.add(this.exitMenuItem);
			this.exitMenuItem.setText("Exit");
			this.exitMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
					HawkMainApp.this.exitMenuItemActionPerformed(paramAnonymousActionEvent);
				}
			});
			this.jMenu4 = new JMenu();
			this.jMenuBar1.add(this.jMenu4);
			this.jMenu4.setText("Edit");
			this.onlyCheckNewEntriesCheckBoxMenuItem = new JCheckBoxMenuItem();
			this.jMenu4.add(this.onlyCheckNewEntriesCheckBoxMenuItem);
			this.onlyCheckNewEntriesCheckBoxMenuItem.setText("Only check new entries");
			this.onlyCheckNewEntriesCheckBoxMenuItem.setBounds(123, 39, 133, 19);
			this.onlyCheckNewEntriesCheckBoxMenuItem.setSelected(true);
			this.onlyCheckNewEntriesCheckBoxMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
					HawkMainApp.this.onlyCheckNewEntriesCheckBoxMenuItemActionPerformed(paramAnonymousActionEvent);
				}
			});
			this.printCheckBoxMenuItem = new JCheckBoxMenuItem();
			this.jMenu4.add(this.printCheckBoxMenuItem);
			this.printCheckBoxMenuItem.setText("Print");
			this.printCheckBoxMenuItem.setSelected(true);
			this.printCheckBoxMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
					HawkMainApp.this.printCheckBoxMenuItemActionPerformed(paramAnonymousActionEvent);
				}
			});
			this.jMenu5 = new JMenu();
			this.jMenuBar1.add(this.jMenu5);
			this.jMenu5.setText("Help");
			this.helpMenuItem = new JMenuItem();
			this.jMenu5.add(this.helpMenuItem);
			this.helpMenuItem.setText("Help");
			this.jSeparator3 = new JSeparator();
			this.jMenu5.add(this.jSeparator3);
			this.aboutMenuItem = new JMenuItem();
			this.jMenu5.add(this.aboutMenuItem);
			this.aboutMenuItem.setText("About Hawk");
			this.aboutMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
					HawkMainApp.this.aboutMenuItemActionPerformed(paramAnonymousActionEvent);
				}
			});
		} catch (Exception localException) {
			localException.printStackTrace();
		}
	}

	private void aboutMenuItemActionPerformed(ActionEvent paramActionEvent) {
		AboutDialog localAboutDialog = new AboutDialog(this);
		localAboutDialog.setModal(true);
		localAboutDialog.setVisible(true);
		localAboutDialog.dispose();
		localAboutDialog = null;
	}

	@Override
	protected void processWindowEvent(WindowEvent paramWindowEvent) {
		super.processWindowEvent(paramWindowEvent);
		if (paramWindowEvent.getID() == 201) {
			System.exit(0);
		}
	}

	private void exitMenuItemActionPerformed(ActionEvent paramActionEvent) {
		System.exit(0);
	}

	private void loadCsvButtonActionPerformed(ActionEvent paramActionEvent) {
		loadCsvFile();
	}

	public void loadCsvFile() {
		JFileChooser localJFileChooser = new JFileChooser();
		FileNameExtensionFilter localFileNameExtensionFilter1 = new FileNameExtensionFilter("tsv files", new String[]{"tsv"});
		localJFileChooser.addChoosableFileFilter(localFileNameExtensionFilter1);
		FileNameExtensionFilter localFileNameExtensionFilter2 = new FileNameExtensionFilter("csv files", new String[]{"csv"});
		localJFileChooser.addChoosableFileFilter(localFileNameExtensionFilter2);
		localJFileChooser.setFileFilter(localFileNameExtensionFilter1);
		int i = localJFileChooser.showDialog(null, "Open file");
		Object localObject = new ArrayList();
		if (i == 0) {
			File localFile = localJFileChooser.getSelectedFile();
			FileFilter localFileNameExtensionFilter3 = localJFileChooser.getFileFilter();
			this.fileLabel.setText(localJFileChooser.getSelectedFile().getName());
			try {
				CSVReader localCSVReader = null;
				if (localFileNameExtensionFilter3 == localFileNameExtensionFilter1 || localJFileChooser.getSelectedFile().getPath().endsWith("tsv")) {
					localCSVReader = new CSVReader(new FileReader(localJFileChooser.getSelectedFile().getPath()), '\t');
				} else {
					localCSVReader = new CSVReader(new FileReader(localJFileChooser.getSelectedFile().getPath()), ',');
				}
				localObject = localCSVReader.readAll();
				for (String[]a:(Iterable<String[]>)localObject) {
					System.out.println(Arrays.toString(a));
					this.entries.add(new AdultInfo(a));
				}
			} catch (FileNotFoundException localFileNotFoundException) {
				localFileNotFoundException.printStackTrace();
			} catch (IOException localIOException) {
				localIOException.printStackTrace();
			}
		}
	}

	private void logoLabelMouseClicked(MouseEvent paramMouseEvent) {
		runChecks();
	}

	public void runChecks() {
		if ((this.entries != null) && (this.entries.size() > 0)) {
			this.check = new TXSexualOffender(this.entries, this.onlyCheckNewEntries, this.print);
			try {
				setState(1);
				this.check.setUp();
				this.check.testTXSexualOffender();
				this.check.tearDown();
				int i = 0;
				int j = 0;
				int k = 0;
				for (int m = 0; m < this.entries.size(); m++) {
					if (this.entries.get(m).getCheckResult() == 1) {
						i++;
					} else if (this.entries.get(m).getCheckResult() == 2) {
						j++;
					} else {
						k++;
					}
				}
				DefaultMutableTreeNode localDefaultMutableTreeNode1 = new DefaultMutableTreeNode(i + " Adults checked OK");
				DefaultMutableTreeNode localDefaultMutableTreeNode2 = new DefaultMutableTreeNode(j + " Adults with DPS records");
				DefaultMutableTreeNode localDefaultMutableTreeNode3 = new DefaultMutableTreeNode(k + " Adults previously checked");
				this.root.add(localDefaultMutableTreeNode1);
				this.root.add(localDefaultMutableTreeNode2);
				this.root.add(localDefaultMutableTreeNode3);
				for (int n = 0; n < this.entries.size(); n++) {
					DefaultMutableTreeNode localDefaultMutableTreeNode4;
					if (this.entries.get(n).isCheckDone()) {
						if (this.entries.get(n).getCheckResult() == 1) {
							localDefaultMutableTreeNode4 = new DefaultMutableTreeNode(this.entries.get(n).toString());
							localDefaultMutableTreeNode1.add(localDefaultMutableTreeNode4);
						} else if (this.entries.get(n).getCheckResult() == 2) {
							localDefaultMutableTreeNode4 = new DefaultMutableTreeNode(this.entries.get(n).toString());
							localDefaultMutableTreeNode2.add(localDefaultMutableTreeNode4);
						}
					} else {
						localDefaultMutableTreeNode4 = new DefaultMutableTreeNode(this.entries.get(n).toString());
						localDefaultMutableTreeNode3.add(localDefaultMutableTreeNode4);
					}
				}
				this.resultsTree.expandRow(1);
				this.resultsTree.expandRow(0);
				this.resultsTree.setVisible(true);
				setState(0);
				repaint();
			} catch (Exception localException) {
				localException.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null,"Please add entries to search for.","No entries found",JOptionPane.WARNING_MESSAGE);
		}
	}

	private void adultEditButtonActionPerformed(ActionEvent paramActionEvent) {
		AdultDataDialog localAdultDataDialog = new AdultDataDialog(this, this.entries);
		localAdultDataDialog.setModal(true);
		localAdultDataDialog.setVisible(true);
		localAdultDataDialog.dispose();
		localAdultDataDialog = null;
	}

	private void exportTsvButtonActionPerformed(ActionEvent paramActionEvent) {
		exportCsv();
	}

	public void exportCsv() {
		JFileChooser localJFileChooser = new JFileChooser();
		FileNameExtensionFilter localFileNameExtensionFilter1 = new FileNameExtensionFilter("csv files", new String[]{"csv"});
		localJFileChooser.addChoosableFileFilter(localFileNameExtensionFilter1);
		localFileNameExtensionFilter1 = new FileNameExtensionFilter("tsv files", new String[]{"tsv"});
		localJFileChooser.addChoosableFileFilter(localFileNameExtensionFilter1);
		localJFileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
		int i = localJFileChooser.showDialog(null, "Save file");
		FileWriter localFileWriter = null;
		FileFilter localFileNameExtensionFilter2 = localJFileChooser.getFileFilter();
		String str = null;
		CSVWriter localCSVWriter = null;
		try {
			if (localFileNameExtensionFilter2 == localFileNameExtensionFilter1 || localJFileChooser.getSelectedFile().getPath().endsWith("tsv")) {
				str = localJFileChooser.getSelectedFile().getPath();
				if (!str.endsWith("tsv")) {
					str = new String(str + ".tsv");
				}
				localFileWriter = new FileWriter(str);
				localCSVWriter = new CSVWriter(localFileWriter, '\t', '\000');
			} else {
				str = localJFileChooser.getSelectedFile().getPath();
				if (!str.endsWith("csv")) {
					str = new String(str + ".csv");
				}
				localFileWriter = new FileWriter(str);
				localCSVWriter = new CSVWriter(localFileWriter, ',', '\000');
			}
			List localList = AdultInfoHelper.toStringArray(this.entries);
			localCSVWriter.writeAll(localList);
			localFileWriter.close();
		} catch (IOException localIOException) {
			localIOException.printStackTrace();
			JOptionPane.showMessageDialog(null,"An error occurred writing to file.","ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}

	private void startChecksActionPerformed(ActionEvent paramActionEvent) {
		runChecks();
	}

	private void openFileMenuItemActionPerformed(ActionEvent paramActionEvent) {
		loadCsvFile();
	}

	private void saveMenuItemActionPerformed(ActionEvent paramActionEvent) {
		exportCsv();
	}

	private void onlyCheckNewEntriesCheckBoxMenuItemActionPerformed(ActionEvent paramActionEvent) {
		this.onlyCheckNewEntries = this.onlyCheckNewEntriesCheckBoxMenuItem.isSelected();
	}

	private void printCheckBoxMenuItemActionPerformed(ActionEvent paramActionEvent) {
		this.print = this.printCheckBoxMenuItem.isSelected();
	}
}

/*
 * Location: C:\Program Files
 * (x86)\Hawk\Hawk.jar!\org\wdh\hawk\HawkMainApp.class Java compiler version: 7
 * (51.0) JD-Core Version: 0.7.1
 */