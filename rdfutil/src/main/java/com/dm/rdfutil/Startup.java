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
        ld.AddDCProperty("id12abdf", DCTERMS.ID);
        ld.AddDCProperty(new Date().toString(), DCTERMS.DATE);        
        ld.AddDCProperty("DMM incorporated", DCTERMS.CREATOR);
        System.out.print(ld.GetRdf());
    }
    
}
