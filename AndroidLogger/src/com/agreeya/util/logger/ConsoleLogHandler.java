
package com.agreeya.util.logger;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import android.util.Log;

public class ConsoleLogHandler extends Handler
{
    
    @Override
    public void close()
    {}
    
    @Override
    public void flush()
    {}
    
    // filter logs and publish them
    @Override
    public void publish(LogRecord record)
    {
        String className = record.getLoggerName() + ": "
                + simplifyClassName(record.getSourceClassName());
        int threadID = record.getThreadID();
        String methodName = record.getSourceMethodName();
        String msg = record.getMessage();
        int level = record.getLevel().intValue();
        
        logMessage(className, threadID, methodName, msg, level, record.getThrown());
    }
    
    // simplify class name from full applied package name to simple class
    private String simplifyClassName(String sourceClassName)
    {
        String fullClassName[] = sourceClassName.split("\\.");
        return fullClassName[fullClassName.length - 1];
    }
    
    private void logMessage(String className, int threadID, String methodName, String msg,
            int level, Throwable throwable)
    {
        if (level == Level.FINE.intValue()) {
            Log.d(className, "ThreadID:" + threadID + "," + methodName + "()," + msg);
        }
        else if (level == Level.INFO.intValue()) {
            Log.i(className, "ThreadID:" + threadID + "," + methodName + "()," + msg);
        }
        else if (level == Level.WARNING.intValue()) {
            Log.w(className, "ThreadID:" + threadID + "," + methodName + "()," + msg, throwable);
        }
        else if (level == Level.SEVERE.intValue()) {
            Log.e(className, "ThreadID:" + threadID + "," + methodName + "()," + msg, throwable);
        }
        
    }
    
}
