package com.revature.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerSingelton {

	private static Logger log;

	public static Logger getLottger() {

		if (log != null) {
			return log;
		} else {
			log = LogManager.getRootLogger();
			return log;
		}

	}

}
