package com.agreeya.util.logger;

import java.util.logging.Level;

public enum LogLevel {
	DEBUG, INFO, WARNING, ERROR, NO_LOG, DISABLE;
	/*
	 * set log-debugLevel as per requirement. Global level is given preference
	 * over app and service levels. If global level is disabled, other
	 * levels are considered
	 */
	public static Level setDebugLevel(String sGlobalDebugLevel,
			String sAppDebugLevel) {
		String strGlobalDebugLevel = sGlobalDebugLevel.trim().toUpperCase();
		String strAppDebugLevel = sAppDebugLevel.trim().toUpperCase();
		LogLevel globalDebugLevel = LogLevel.valueOf(strGlobalDebugLevel);
		LogLevel appDebugLevel = LogLevel.valueOf(strAppDebugLevel);
		LogLevel logLevel = globalDebugLevel == LogLevel.DISABLE ? appDebugLevel
				: globalDebugLevel;

		switch (logLevel) {
		case DEBUG:
			return Level.FINE;
		case INFO:
			return Level.INFO;
		case WARNING:
			return Level.WARNING;
		case ERROR:
			return Level.SEVERE;
		case NO_LOG:
			return Level.OFF;
		case DISABLE:
			return Level.OFF;
		default:
			return Level.INFO;
		}
	}
}
