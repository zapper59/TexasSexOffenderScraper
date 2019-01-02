package org.wdh.hawk;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class DelayedPrintThread implements Runnable {
	Thread runner;
	private int delay;

	public DelayedPrintThread() {
	}

	public DelayedPrintThread(String paramString) {
		this.delay = 5000;
		init(paramString);
	}

	public DelayedPrintThread(String paramString, int paramInt) {
		this.delay = paramInt;
		init(paramString);
	}

	private void init(String paramString) {
		this.runner = new Thread(this, paramString);
		this.runner.start();
	}

	@Override
	public void run() {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException localAWTException) {
			localAWTException.printStackTrace();
		}

		robot.keyPress(KeyEvent.VK_CONTROL );
		robot.keyPress(KeyEvent.VK_P );
		robot.keyRelease(KeyEvent.VK_P );
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.delay(this.delay);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}

/*
 * Location: C:\Program Files
 * (x86)\Hawk\Hawk.jar!\org\wdh\hawk\DelayedPressEnterThread.class Java compiler
 * version: 7 (51.0) JD-Core Version: 0.7.1
 */