package org.wdh.hawk;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class AdultInfo {
	String lastName;
	String firstName;
	String dob;
	String sex;
	int checkResult;
	boolean checkDone;
	public static final int CHECK_NOT_DONE = 0;
	public static final int CHECK_DONE = 1;
	public static final int CHECK_OK = 1;
	public static final int CHECK_BAD = 2;

	public AdultInfo() {
	}

	public AdultInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {
		this.lastName = removeSpaces(paramString1);
		this.firstName = removeSpaces(paramString2);
		this.dob = paramString3;
		this.sex = paramString4;
		this.checkResult = paramInt;
		this.checkDone = false;
	}


	public AdultInfo(String[] paramArrayOfString) {
		if (paramArrayOfString.length < 3) {
			System.out.println("Length: "+paramArrayOfString.length + " " + Arrays.toString(paramArrayOfString));
			JOptionPane.showMessageDialog(null,"Each row must have at least 3 entries: last_name first_name dob and optionally gender.\nPlease close and re-open the program.","Invalid TSV",JOptionPane.WARNING_MESSAGE);
			return;
		}
		this.lastName = removeSpaces(paramArrayOfString[0]);
		this.firstName = removeSpaces(paramArrayOfString[1]);
		this.dob = paramArrayOfString[2];
		if (paramArrayOfString.length > 3){
			this.sex = paramArrayOfString[3];
		} else {
			this.sex = null;
		}
		this.checkResult = 0;
		if (paramArrayOfString.length > 4) {
			this.checkResult = Integer.parseInt(paramArrayOfString[4]);
		}
		this.checkDone = false;
	}

	public void setValues(AdultInfo paramAdultInfo) {
		this.lastName = removeSpaces(paramAdultInfo.getLastName());
		this.firstName = removeSpaces(paramAdultInfo.getFirstName());
		this.dob = removeSpaces(paramAdultInfo.getDob());
		this.sex = removeSpaces(paramAdultInfo.getSex());
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String paramString) {
		this.lastName = removeSpaces(paramString);
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String paramString) {
		this.firstName = removeSpaces(paramString);
	}

	public String getDob() {
		return this.dob;
	}

	public void setDob(String paramString) {
		this.dob = paramString;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String paramString) {
		this.sex = paramString;
	}

	@Override
	public String toString() {
		StringBuffer localStringBuffer = new StringBuffer();
		localStringBuffer.append(this.firstName + " ");
		localStringBuffer.append(this.lastName + "    ");
		localStringBuffer.append(this.dob + "    ");
		localStringBuffer.append(this.sex + " ");
		return localStringBuffer.toString();
	}

	public String[] toArray() {
		String[] arrayOfString = new String[5];
		arrayOfString[0] = this.lastName;
		arrayOfString[1] = this.firstName;
		arrayOfString[2] = this.dob;
		arrayOfString[3] = this.sex;
		arrayOfString[5] = Integer.toString(this.checkResult);
		return arrayOfString;
	}

	public int getCheckResult() {
		return this.checkResult;
	}

	public void setCheckResult(int paramInt) {
		this.checkResult = paramInt;
	}

	public boolean isCheckDone() {
		return this.checkDone;
	}

	public void setCheckDone(boolean paramBoolean) {
		this.checkDone = paramBoolean;
	}

	public String removeSpaces(String paramString) {
		String str = paramString;
		str = str.replaceAll("[\\s]", "");
		return str;
	}

	public static String stripSlashes(String paramString) {
		String[] arrayOfString = paramString.split("/");
		StringBuffer localStringBuffer = new StringBuffer();
		for (int i = 0; i < arrayOfString.length; i++) {
			localStringBuffer.append(arrayOfString[i]);
		}
		return localStringBuffer.toString();
	}
}

/*
 * Location: C:\Program Files (x86)\Hawk\Hawk.jar!\org\wdh\hawk\AdultInfo.class
 * Java compiler version: 7 (51.0) JD-Core Version: 0.7.1
 */