package org.wdh.hawk;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class AboutDialog extends JDialog {
	private JLabel hawkLabel1;
	private JLabel jLabel2;
	private JPanel jPanel1;
	private JLabel versionLabel;
	private JLabel jLabel1;
	private JButton okButton;

	public AboutDialog(JFrame paramJFrame) {
		super(paramJFrame);
		initGUI();
	}

	private void initGUI() {
		try {
			GridBagLayout localGridBagLayout1 = new GridBagLayout();
			localGridBagLayout1.rowWeights = new double[]{0.1D, 0.1D};
			localGridBagLayout1.rowHeights = new int[]{7, 7};
			localGridBagLayout1.columnWeights = new double[]{0.1D, 0.1D};
			localGridBagLayout1.columnWidths = new int[]{7, 7};
			localGridBagLayout1.columnWeights = new double[]{0.1D, 0.1D};
			localGridBagLayout1.rowWeights = new double[]{0.1D, 0.1D, 0.1D};
			localGridBagLayout1.rowHeights = new int[]{7, 7, 7};
			getContentPane().setLayout(localGridBagLayout1);
			setPreferredSize(new Dimension(600, 350));
			this.hawkLabel1 = new JLabel();
			getContentPane().add(this.hawkLabel1, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 11, 0, new Insets(0, 5, 0, 0), 0, 0));
			this.hawkLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/hawk.jpg")));
			this.hawkLabel1.setBorder(new LineBorder(new Color(0, 0, 0), 1, false));
			this.okButton = new JButton();
			getContentPane().add(this.okButton, new GridBagConstraints(1, 2, 1, 1, 0.0D, 0.0D, 14, 0, new Insets(10, 0, 10, 10), 0, 0));
			this.okButton.setText("OK");
			this.okButton.setSize(75, 30);
			this.okButton.setPreferredSize(new Dimension(75, 30));
			this.okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
					AboutDialog.this.okButtonActionPerformed(paramAnonymousActionEvent);
				}
			});
			this.jLabel2 = new JLabel();
			getContentPane().add(this.jLabel2, new GridBagConstraints(1, 1, 1, 1, 1.0D, 1.0D, 11, 2, new Insets(5, 10, 0, 10), 0, 0));
			this.jLabel2
					.setText("<html> Copyright © 2013 <a href=\"mailto:wdh61@swbell.net\">William D. Hayden</a>.<br>\r\n<br>\r\nThis program is free software: you can redistribute it and/or<br>\r\nmodify it under the terms of the GNU General Public License as<br>\r\npublished by the Free Software Foundation, either version 3 of the<br>\r\nLicense, or (at your option) any later version.<br>\r\n<br>\r\nThis program is distributed in the hope that it will be useful, but <br>\r\nWITHOUT ANY WARRANTY; without even the implied warranty of<br>\r\nMERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. <br>\r\nSee the GNU General Public License for more details.<br>\r\n<br>\r\nYou should have received a copy of the GNU General Public License<br>\r\nalong with this program.  If not, see <a href=http://www.gnu.org/licenses><i>http://www.gnu.org/licenses/<i></a>.");
			this.jPanel1 = new JPanel();
			GridBagLayout localGridBagLayout2 = new GridBagLayout();
			localGridBagLayout2.columnWidths = new int[]{7};
			localGridBagLayout2.rowHeights = new int[]{7, 7};
			localGridBagLayout2.columnWeights = new double[]{0.1D};
			localGridBagLayout2.rowWeights = new double[]{0.1D, 0.1D};
			getContentPane().add(this.jPanel1, new GridBagConstraints(1, 0, 1, 1, 0.0D, 0.0D, 10, 1, new Insets(0, 0, 0, 0), 0, 0));
			this.jPanel1.setLayout(localGridBagLayout2);
			this.jLabel1 = new JLabel();
			this.jPanel1.add(this.jLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 10, 2, new Insets(0, 0, 0, 0), 0, 0));
			this.jLabel1.setText("Hawk");
			this.jLabel1.setFont(new Font("Tahoma", 1, 16));
			this.jLabel1.setHorizontalAlignment(0);
			this.versionLabel = new JLabel();
			this.jPanel1.add(this.versionLabel, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 10, 2, new Insets(0, 0, 0, 0), 0, 0));
			this.versionLabel.setText("Version " + Version.getVersion());
			this.versionLabel.setHorizontalAlignment(0);
			this.versionLabel.setFont(new Font("Tahoma", 2, 9));
			setSize(625, 375);
		} catch (Exception localException) {
			localException.printStackTrace();
		}
	}

	private void okButtonActionPerformed(ActionEvent paramActionEvent) {
		setVisible(false);
	}
}

/*
 * Location: C:\Program Files
 * (x86)\Hawk\Hawk.jar!\org\wdh\hawk\AboutDialog.class Java compiler version: 7
 * (51.0) JD-Core Version: 0.7.1
 */