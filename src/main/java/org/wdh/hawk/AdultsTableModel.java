package org.wdh.hawk;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AdultsTableModel extends AbstractTableModel {
	List<AdultInfo> entries;

	public AdultsTableModel(List<AdultInfo> paramList) {
		this.entries = paramList;
	}

	public int getColumnCount() {
		return 4;
	}

	public int getRowCount() {
		return this.entries.size();
	}

	public Object getValueAt(int paramInt1, int paramInt2) {
		AdultInfo localAdultInfo = (AdultInfo) this.entries.get(paramInt1);
		switch (paramInt2) {
			case 0 :
				return localAdultInfo.getLastName();
			case 1 :
				return localAdultInfo.getFirstName();
			case 2 :
				return localAdultInfo.getDob();
			case 3 :
				return localAdultInfo.getSex();
		}
		return null;
	}

	public String getColumnName(int paramInt) {
		switch (paramInt) {
			case 0 :
				return "Last Name";
			case 1 :
				return "First Name";
			case 2 :
				return "DOB";
			case 3 :
				return "Gender";
		}
		return null;
	}

	public void refresh() {
		fireTableDataChanged();
	}

	public AdultInfo getObjectAtRow(int paramInt) {
		return (AdultInfo) this.entries.get(paramInt);
	}
}

/*
 * Location: C:\Program Files
 * (x86)\Hawk\Hawk.jar!\org\wdh\hawk\AdultsTableModel.class Java compiler
 * version: 7 (51.0) JD-Core Version: 0.7.1
 */