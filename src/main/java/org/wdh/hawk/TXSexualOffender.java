package org.wdh.hawk;

import java.awt.Robot;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
			if (System.getProperty("os.name").contains("Linux")) {
				System.setProperty("webdriver.gecko.driver", getClass().getClassLoader().getResource("geckodriver_linux").getPath());
			} else {
				System.setProperty("webdriver.gecko.driver", getClass().getClassLoader().getResource("geckodriver_windows.exe").getPath());
			}
			this.robot = new Robot();
			this.logger = Logger.getLogger("InfoLogging");
			this.driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			this.baseUrl = "https://records.txdps.state.tx.us/";
//			this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

	public void testTXSexualOffender() throws Exception {
		if (this.entries != null) {
			for (int i = 0; i < this.entries.size(); i++) {
				AdultInfo localAdultInfo = (AdultInfo) this.entries.get(i);
				if (this.simulate) {
					simulateTestcase(localAdultInfo);
				} else if (this.onlyCheckNewEntries) {
					if (localAdultInfo.getCheckResult() == 0) {
						doTestcase(localAdultInfo);
						localAdultInfo.setCheckDone(true);
					}
				} else {
					doTestcase(localAdultInfo);
					localAdultInfo.setCheckDone(true);
				}
			}
		}
	}

	public void doTestcase(AdultInfo paramAdultInfo) throws Exception {
		if (this.firstTime) {
			this.firstTime = false;
			this.driver.get(this.baseUrl + "/SexOffender/PublicSite/Application/Search/Caveats.aspx?SearchType=Name");
			this.driver.findElement(By.id("ContentBody_chkAgree")).click();
			this.driver.findElement(By.id("ContentBody_btnContinue")).click();
		} else {
			this.driver.findElement(By.id("ContentBody_SearchHeader1_hlSearch")).click();
		}
		this.driver.findElement(By.id("ContentBody_ctrlSearchByName_txtLastName")).clear();
		this.driver.findElement(By.id("ContentBody_ctrlSearchByName_txtLastName")).sendKeys(
				new CharSequence[]{paramAdultInfo.getLastName()});
		this.driver.findElement(By.id("ContentBody_ctrlSearchByName_txtFirstName")).clear();
		this.driver.findElement(By.id("ContentBody_ctrlSearchByName_txtFirstName")).sendKeys(
				new CharSequence[]{paramAdultInfo.getFirstName()});
		this.driver.findElement(By.id("ContentBody_ctrlSearchByName_txtBirthDate")).clear();
		this.driver.findElement(By.id("ContentBody_ctrlSearchByName_txtBirthDate")).sendKeys(
				new CharSequence[]{AdultInfo.stripSlashes(paramAdultInfo.getDob())});
		new Select(this.driver.findElement(By.id("ContentBody_ctrlSearchByName_ddlSex"))).selectByVisibleText(paramAdultInfo.getSex()
				.toUpperCase());
		this.driver.findElement(By.id("ContentBody_btnSearch")).click();
		getRecords(this.driver.getPageSource(), paramAdultInfo);
		if (this.printFlag) {
			DelayedPressEnterThread localDelayedPressEnterThread = new DelayedPressEnterThread("DelayedPressEnterThread", 5000);
			this.driver.findElement(By.id("hlPrint")).click();
			this.robot.delay(5000);
		}
		this.robot.delay(5000);
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

	public void getRecords(String paramString, AdultInfo paramAdultInfo) {
		Pattern localPattern = Pattern.compile("^.*<td align=\"center\">[0]</td>.*$", 32);
		Matcher localMatcher = localPattern.matcher(paramString);
		if (localMatcher.matches()) {
			this.checksOk += 1;
			paramAdultInfo.setCheckResult(1);
		} else {
			this.checksBad += 1;
			paramAdultInfo.setCheckResult(2);
		}
	}
}

/*
 * Location: C:\Program Files
 * (x86)\Hawk\Hawk.jar!\org\wdh\hawk\TXSexualOffender.class Java compiler
 * version: 7 (51.0) JD-Core Version: 0.7.1
 */