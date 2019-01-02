package org.wdh.hawk;

import java.awt.Robot;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TXSexualOffender {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	Robot robot;
	Logger logger;
//	private boolean printFlag = true;
	private boolean printFlag = false;
	private List entries;
	private boolean write = true;
	private int checksOk;
	private int checksBad;
	private int checkNotDone;
	int index = 0;
	private boolean onlyCheckNewEntries = true;
	boolean toggle = false;
	boolean simulate = false;
	boolean firstTime = true;

	static final String SEARCH_EXTENSION = "SexOffenderRegistry/Search/Default/SearchByNames?lastName={0}&firstName={1}&DOB={2}";
	static final String UNICODE_SPACE =    "%2F";
	static final String RESULTS_TABLE_CLASS = "table-boarder";

	public TXSexualOffender() {
	}

	public TXSexualOffender(List paramList, boolean paramBoolean1, boolean paramBoolean2) {
		this.entries = paramList;
		this.printFlag = paramBoolean2;
		this.onlyCheckNewEntries = paramBoolean1;
		this.checksOk = 0;
		this.checksBad = 0;
		this.checkNotDone = 0;
	}

	public void setUp() throws Exception {
		if (!this.simulate) {
			System.out.println(getClass().getClassLoader().getResources("geckodriver_windows.exe"));
			String search = "geckodriver_windows.exe";
			if (System.getProperty("os.name").contains("Linux")) {
				search = "geckodriver_linux";
			}
			Enumeration<URL> enumer = getClass().getClassLoader().getResources(search);
			while (enumer.hasMoreElements()){
				URL driverURL = enumer.nextElement();
				try {
					System.setProperty("webdriver.gecko.driver", driverURL.getPath());
					System.out.println(driverURL.getPath());
					this.robot = new Robot();
					this.logger = Logger.getLogger("InfoLogging");
					this.driver = new FirefoxDriver();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					this.baseUrl = "https://records.txdps.state.tx.us/";
					return;
				} catch (Exception e) {
				}
			}
			JOptionPane.showMessageDialog(null,"Could not find driver file.","ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}

	public void testTXSexualOffender() throws Exception {
		if (this.entries != null) {
			for (int i = 0; i < this.entries.size(); i++) {
				AdultInfo localAdultInfo = (AdultInfo) this.entries.get(i);
				if (this.simulate) {
					simulateTestcase(localAdultInfo);
				} else if (!onlyCheckNewEntries ^ localAdultInfo.getCheckResult() == 0) {
					doTestcase(localAdultInfo);
					localAdultInfo.setCheckDone(true);
				}
			}
		}
	}

	public void doTestcase(AdultInfo info) throws Exception {
		/*driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		if (true || this.firstTime) {
		this.firstTime = false;
		this.driver.get(this.baseUrl + "/SexOffender/PublicSite/Application/Search/Caveats.aspx?SearchType=Name");
		this.driver.findElement(By.id("ContentBody_chkAgree")).click();
		this.driver.findElement(By.id("ContentBody_btnContinue")).click();
//		} else {
//			this.driver.findElement(By.id("ContentBody_SearchHeader1_hlSearch")).click();
//		}
		this.driver.findElement(By.id("ContentBody_ctrlSearchByName_txtLastName")).clear();
		this.driver.findElement(By.id("ContentBody_ctrlSearchByName_txtLastName")).sendKeys(
				new CharSequence[]{paramAdultInfo.getLastName()});
		this.driver.findElement(By.id("ContentBody_ctrlSearchByName_txtFirstName")).clear();
		this.driver.findElement(By.id("ContentBody_ctrlSearchByName_txtFirstName")).sendKeys(
				new CharSequence[]{paramAdultInfo.getFirstName()});
//		this.driver.findElement(By.id("ContentBody_ctrlSearchByName_txtBirthDate")).clear();
//		System.out.println(AdultInfo.stripSlashes(paramAdultInfo.getDob()));
		this.driver.findElement(By.id("ContentBody_ctrlSearchByName_txtBirthDate")).sendKeys(
				new CharSequence[]{AdultInfo.stripSlashes(paramAdultInfo.getDob())});
		if (paramAdultInfo.getSex() != null)
			new Select(this.driver.findElement(By.id("ContentBody_ctrlSearchByName_ddlSex")))
					.selectByVisibleText(paramAdultInfo.getSex().toUpperCase());
		this.driver.findElement(By.id("ContentBody_btnSearch")).click();
		*/

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		this.driver.get(this.baseUrl + MessageFormat.format(SEARCH_EXTENSION, info.getLastName(), info.getFirstName(), info.getDob().replaceAll("/", UNICODE_SPACE)));

		//getRecords(found.size()>0?found.get(0).getText():"Foo", info);

		// This table only exists if there were results found
		List<WebElement>found = driver.findElements(By.className(RESULTS_TABLE_CLASS));
		if (found.size() > 0) {
			info.setCheckResult(AdultInfo.CHECK_BAD);
		} else {
			info.setCheckResult(AdultInfo.CHECK_OK);
		}

		if (this.printFlag) {
			new DelayedPrintThread("PrintThread", 3000);
			//this.driver.findElement(By.id("hlPrint")).click();
			this.robot.delay(5000);
		}
		this.robot.delay(3000);
	}

	public void tearDown() throws Exception {
		this.driver.quit();
		String str = this.verificationErrors.toString();
		if (!"".equals(str)) {
			Assert.fail(str);
		}
	}

	public void simulateTestcase(AdultInfo paramAdultInfo) throws Exception {
		if (this.toggle) {
			this.checksOk += 1;
		} else {
			this.checksBad += 1;
		}
		this.toggle = (!this.toggle);
	}

	private boolean isElementPresent(By paramBy) {
		try {
			this.driver.findElement(paramBy);
			return true;
		} catch (NoSuchElementException localNoSuchElementException) {
		}
		return false;
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert localAlert = this.driver.switchTo().alert();
			if (this.acceptNextAlert) {
				localAlert.accept();
			} else {
				localAlert.dismiss();
			}
			String str = localAlert.getText();
			return str;
		} finally {
			this.acceptNextAlert = true;
		}
	}

	public boolean isPrintFlag() {
		return this.printFlag;
	}

	public void setPrintFlag(boolean paramBoolean) {
		this.printFlag = paramBoolean;
	}

	public int getChecksOk() {
		return this.checksOk;
	}

	public void setChecksOk(int paramInt) {
		this.checksOk = paramInt;
	}

	public int getChecksBad() {
		return this.checksBad;
	}

	public void setChecksBad(int paramInt) {
		this.checksBad = paramInt;
	}

	/*public void getRecords(String paramString, AdultInfo paramAdultInfo) {
		if (paramString.toLowerCase()
				.matches("^.*(\n)?.*" + paramAdultInfo.lastName + " " + paramAdultInfo.firstName + "( [\\-0-9]+)? 0$")) {
			this.checksOk += 1;
			paramAdultInfo.setCheckResult(AdultInfo.CHECK_OK);
		} else {
			System.out.println("Could not find match in: "+paramString);
			this.checksBad += 1;
			paramAdultInfo.setCheckResult(AdultInfo.CHECK_BAD);
		}
	}*/
}

/*
 * Location: C:\Program Files
 * (x86)\Hawk\Hawk.jar!\org\wdh\hawk\TXSexualOffender.class Java compiler
 * version: 7 (51.0) JD-Core Version: 0.7.1
 */