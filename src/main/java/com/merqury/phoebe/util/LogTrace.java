/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author jeffersonbienaime
 */
public class LogTrace {
    
    
    public static void Log(String action, String username, String hostname, String computerName, String remoteAddress) throws IOException {
 
        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;
 
        try {
            // This block configure the logger with handler and formatter 
            fh = new FileHandler("MyLogFile.log",true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.log(Level.INFO, "User: {0} action : {1} hostName : {2} computerName : {3} remoteAddress: {4}", new Object[]{username, action,hostname,computerName,remoteAddress});
            fh.close();
 
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(LogTrace.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
