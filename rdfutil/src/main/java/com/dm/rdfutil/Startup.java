/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dm.rdfutil;

import java.util.Date;

/**
 *
 * @author Diego
 */
public class Startup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
        LinkedData ld = new LinkedData("http://dmm888.com/diegowebsite");        
        ld.AddPrefix(new NsPrefix("DM88", "http://dmm888.com/"));        
        ld.AddDCProperty("titleofthewebsite", DCTERMS.TITLE);
        ld.AddDCProperty("id12abdf", DCTERMS.ID);
        ld.AddDCProperty(new Date().toString(), DCTERMS.DATE);        
        ld.AddDCProperty("DMM incorporated", DCTERMS.CREATOR);
        ld.AddPrefixedResource("https://profiles.google.com/116142573163051163758/about", "http://dmm888.com/", "owner");
        System.out.print(ld.GetRdf());
    }
    
}
