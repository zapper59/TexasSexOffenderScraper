package org.wdh.hawk;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class DelayedPressEnterThread implements Runnable {
	Thread runner;
	private int delay;

	public DelayedPressEnterThread() {
	}

	public DelayedPressEnterThread(String paramString) {
		this.delay = 5000;
		init(paramString);
	}

	public DelayedPressEnterThread(String paramString, int paramInt) {
		this.delay = paramInt;
		init(paramString);
	}

	private void init(String paramString) {
		this.runner = new Thread(this, paramString);
		this.runner.start();
	}

	@Override
	public void run() {
		Robot localRobot = null;
		try {
			localRobot = new Robot();
		} catch (AWTException localAWTException) {
			localAWTException.printStackTrace();
		}
		localRobot.delay(this.delay);
		localRobot.keyPress(KeyEvent.VK_ENTER);
		localRobot.keyRelease(KeyEvent.VK_ENTER);
	}
}

/*
 * Location: C:\Program Files
 * (x86)\Hawk\Hawk.jar!\org\wdh\hawk\DelayedPressEnterThread.class Java compiler
 * version: 7 (51.0) JD-Core Version: 0.7.1
 */