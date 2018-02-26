/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author jbienaime
 */
public class phoebeUtil {

    /*
     * Converts java.util.Date to javax.xml.datatype.XMLGregorianCalendar
     */

    /**
     *
     * @param date
     * @return
     */

    public static XMLGregorianCalendar toXMLGregorianCalendar(Date date) {
        GregorianCalendar gCalendar = new GregorianCalendar();
        gCalendar.setTime(date);
        XMLGregorianCalendar xmlCalendar = null;
        try {
            xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(phoebeUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return xmlCalendar;
    }

    /**
     *
     * @param date
     * @return
     */
    public static XMLGregorianCalendar toXMLGregorianCalendarYYYYMMDD(Date date) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        try {
            XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(strDate);
            return xmlDate;
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     *
     * @return
     */
    public static Date CurrentDate() {
        return new Date();
    }

    /*
     * Converts XMLGregorianCalendar to java.util.Date in Java
     */

    /**
     *
     * @param calendar
     * @return
     */

    public static Date toDate(XMLGregorianCalendar calendar) {
        if (calendar == null) {
            return null;
        }
        return calendar.toGregorianCalendar().getTime();
    }

    /**
     *
     * @param date
     * @return
     */
    public static Date dateFormatterYYYYMMDD(Date date) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String format = formatter.format(date);
        System.out.println(format);

        return date;
    }

    /**
     *
     * @param date
     * @return
     */
    public static Date dateFormatterYYYYMMDDHHMMssSSS(Date date) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String format = formatter.format(date);
        System.out.println(format);

        return date;
    }

    /**
     *
     * @param date
     * @return
     */
    public static Date dateFormatterYYYYMMDDHHMMss(Date date) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = formatter.format(date);
        System.out.println(format);

        return date;
    }

    /**
     *
     * @param julianDate
     * @return
     * @throws ParseException
     */
    public static XMLGregorianCalendar convertJuliantoGregorian(String julianDate) throws ParseException {

        //julianDate = "1996039";
        Date date = new SimpleDateFormat("Myydd").parse(julianDate);
        String g = new SimpleDateFormat("yyyy-MM-dd").format(date);
        System.out.println(g);
        try {
            XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(g);
            return xmlDate;
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     *
     * @param str
     * @return
     */
    public static String allNumeric(String str) {

        str = str.replaceAll("[^\\d]", "");

        return str;
    }

}
