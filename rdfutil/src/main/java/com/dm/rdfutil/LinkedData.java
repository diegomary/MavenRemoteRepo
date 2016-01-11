package com.dm.rdfutil;
import java.io.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;
import org.apache.jena.vocabulary.DC;
import org.apache.jena.vocabulary.DB;

// To see plugin version go to
//https://maven.apache.org/plugins/

public class LinkedData {
    
    private Model model;
    private Resource ldResource;
    
    public LinkedData(String urlTitle){         
     model = ModelFactory.createDefaultModel();
     ldResource = model.createResource(urlTitle);     
    }     
     
     public void AddDCProperty(String property,DCTERMS dc)
     {  
        switch (dc)            
        {            
            case TITLE:
                  ldResource.addProperty(DC.title, property);                
                break;
            case COVERAGE:
                 ldResource.addProperty(DC.coverage, property);    
                break;
            case CREATOR:
                 ldResource.addProperty(DC.creator, property);    
                break;
            case DATE:
                 ldResource.addProperty(DC.date, property);    
                break;
            case DESCRIPTION:
                 ldResource.addProperty(DC.description, property);    
                break;                
            case ID:
                 ldResource.addProperty(DC.identifier, property);    
                break;               
            default:
                break;
        }       
          
     }
   
    public String GetRdf()    
    {       
          byte[] rdfBytes=null;
          ByteArrayOutputStream output = new ByteArrayOutputStream();            
          model.write(output,"RDF/XML");            
          rdfBytes = output.toByteArray();
          return new String(rdfBytes);
    }

    public void WriteRdfFile(String filePath) throws FileNotFoundException, IOException
    {    
        OutputStream ou = new FileOutputStream(filePath);
        model.write(ou,"RDF/XML");            
        ou.close();
    }

    
}
