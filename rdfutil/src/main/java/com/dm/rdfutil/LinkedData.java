package com.dm.rdfutil;
import com.sun.media.jfxmedia.logging.Logger;
import java.io.*;
import org.apache.jena.atlas.logging.Log;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;
import org.apache.jena.vocabulary.DC;
import org.apache.jena.vocabulary.DB;
import org.apache.log4j.Level;
// To see plugin version go to
//https://maven.apache.org/plugins/
public class LinkedData {   
public String GetRdf()    
{       
      byte[] rdfBytes=null;
        try {
            String personURI    = "http://somewhere/JohnSmith";
            String fullName     = "John Smith";
            Model model = ModelFactory.createDefaultModel();
            Resource johnSmith = model.createResource(personURI);
            johnSmith.addProperty(VCARD.FN, fullName);
            johnSmith.addProperty(VCARD.NICKNAME, "Diegus");
            johnSmith.addProperty(DC.description, "This is the Dublin Core description for this specific RDF");
            johnSmith.addProperty(DB.graphDBSchema, "The schema of the database to be used");
            ByteArrayOutputStream output = new ByteArrayOutputStream();            
            model.write(output,"RDF/XML");            
            rdfBytes = output.toByteArray();
            OutputStream ou = new FileOutputStream("d://data1.nt");
            model.write(ou,"TURTLE");            
            output.close();
        } catch (IOException ex) {
           return ex.getMessage(); 
        }
        return new String(rdfBytes);
     
}
    
}
