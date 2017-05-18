package org.wdh.hawk;

import java.util.ArrayList;
import java.util.List;

public class AdultInfoHelper {
	public static List<String[]> toStringArray(List<AdultInfo> paramList) {
		ArrayList localArrayList = new ArrayList();
		for (int i = 0; i < paramList.size(); i++) {
			localArrayList.add(((AdultInfo) paramList.get(i)).toArray());
		}
		return localArrayList;
	}
}

/*
 * Location: C:\Program Files
 * (x86)\Hawk\Hawk.jar!\org\wdh\hawk\AdultInfoHelper.class Java compiler
 * version: 7 (51.0) JD-Core Version: 0.7.1
 */