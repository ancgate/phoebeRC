/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.controller;

/**
 *
 * @author jbienaime
 */
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionController {

    public static String hostname;
    public static String computerName;
    public static String remoteAddress;

    public static HttpSession getSession() {

        HttpServletRequest request = SessionController.getRequest();
        hostname = request.getRemoteHost(); // hostname
        System.out.println("hostname" + hostname);

        //Getting the remote address even if it is behind a proxy
        remoteAddress = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddress == null) {
            remoteAddress = request.getRemoteAddr();
        }

        System.out.println("remoteAddress: " + remoteAddress);
        try {
            InetAddress inetAddress = InetAddress.getByName(remoteAddress);
            System.out.println("inetAddress: " + inetAddress);
            computerName = inetAddress.getHostName();

            System.out.println("computerName: " + computerName);

            if (computerName.equalsIgnoreCase("localhost")) {
                computerName = java.net.InetAddress.getLocalHost().getCanonicalHostName();
            }
        } catch (UnknownHostException e) {

        }
        return (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
    }

    public static String getUserName() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        return session.getAttribute("username").toString();
    }

    public static String getDisplayName() {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        return session.getAttribute("displayName").toString();
    }

    public static String getEmail() {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        return session.getAttribute("mail").toString();
    }

    public static String getUserId() {
        HttpSession session = getSession();
        if (session != null) {
            return (String) session.getAttribute("userid");
        } else {
            return null;
        }
    }

}
