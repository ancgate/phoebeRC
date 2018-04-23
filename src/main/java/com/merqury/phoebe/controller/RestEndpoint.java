/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.controller;

import com.merqury.phoebe.beans.MaritalStatusFacade;
import com.merqury.phoebe.beans.NoteTypeFacade;
import com.merqury.phoebe.beans.PermissionsFacade;
import com.merqury.phoebe.beans.PrayerRequestNatureFacade;
import com.merqury.phoebe.beans.RolesFacade;
import com.merqury.phoebe.entity.MaritalStatus;
import com.merqury.phoebe.entity.NoteType;
import com.merqury.phoebe.entity.Permissions;
import com.merqury.phoebe.entity.PrayerRequestNature;
import com.merqury.phoebe.entity.Roles;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jeffersonbienaime
 */
@Path("/")
public class RestEndpoint {

    @Inject
    private PrayerRequestNatureFacade prnf;
    @Inject
    private PermissionsFacade pf;
    @Inject
    private NoteTypeFacade ntf;
    @Inject
    private RolesFacade rf;
    @Inject
    private MaritalStatusFacade msf;

    private List<PrayerRequestNature> prns;
    private List<Permissions> ps;
    private List<Roles> rs;
    private List<MaritalStatus> mss;
    private List<NoteType> nts;

    @GET
    @Path("/PrayerRequestNature")
    @Produces(MediaType.APPLICATION_XML)
    public List<PrayerRequestNature> allPrayerRequestNature() {
        prns = new ArrayList<>();
        System.out.println("Getting Size : ");
        prns.addAll(prnf.findAll());
        System.out.println("Size After : " + prns.size());
        return prns;
    }

    @GET
    @Path("/Permissions")
    @Produces(MediaType.APPLICATION_XML)
    public List<Permissions> allPermissions() {
        ps = new ArrayList<>();
        System.out.println("Getting Size : ");
        ps.addAll(pf.findAll());
        System.out.println("Size After : " + ps.size());
        return ps;
    }

    @GET
    @Path("/Roles")
    @Produces(MediaType.APPLICATION_XML)
    public List<Roles> allRoles() {
        rs = new ArrayList<>();
        System.out.println("Getting Size : ");
        rs.addAll(rf.findAll());
        System.out.println("Size After : " + rs.size());
        return rs;
    }

    @GET
    @Path("/MaritalStatus")
    @Produces(MediaType.APPLICATION_XML)
    public List<MaritalStatus> allMaritalStatus() {
        mss = new ArrayList<>();
        System.out.println("Getting Size : ");
        mss.addAll(msf.findAll());
        System.out.println("Size After : " + mss.size());
        return mss;
    }

    @GET
    @Path("/NoteType")
    @Produces(MediaType.APPLICATION_XML)
    public List<NoteType> allNoteType() {
        nts = new ArrayList<>();
        System.out.println("Getting Size : ");
        nts.addAll(ntf.findAll());
        System.out.println("Size After : " + nts.size());
        return nts;
    }

    @GET
    @Path("/PermissionInRole/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Permissions> allPermissionInRoles(@PathParam("id") Integer id) {
        ps = new ArrayList<>();
        System.out.println("Getting Size : ");
        ps.addAll(rf.listOfPermissionsInRole(id));
        System.out.println("Size After : " + ps.size());
        return ps;
    }

}
