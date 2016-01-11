package com.dm.rdfutil;
import java.io.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DC;

/** 
 * this class allows
 * @author Diego
 */
public class LinkedData {
    
    public Model model;
    private Resource ldResource;
    
    /**
     *this is the constructor
     */
    public LinkedData(){         
     model = ModelFactory.createDefaultModel();
    }
    
    /**
     *this is the prefix adder
     * @param prefix
     * The prefix is the prefix
     */
    public void AddPrefix(NsPrefix prefix)
    {    
     model.setNsPrefix(prefix.Prefix, prefix.Url);
    }
    
    public void CreateResource(String urlTitle)
    {    
     ldResource = model.createResource(urlTitle);    
    }    
    
    public void SetCurrentResource(String urlTitle)
    {    
        ldResource=model.getResource(urlTitle);
    }   
    
         
    public void AddPrefixedResource(String resourceUrl, String NsPrefix, String vocabularyTerm)
    {    
     ldResource.addProperty(model.createProperty(model.getNsPrefixURI(NsPrefix),vocabularyTerm), model.createResource(resourceUrl));    
    }
    
     public void AddPrefixedProperty(String NsPrefix, String vocabularyTerm,String property)
     {         
        ldResource.addProperty(model.createProperty(model.getNsPrefixURI(NsPrefix),vocabularyTerm),property);
     }
    
     public void AddDCProperty(String property,DCTERMS dc)
     {  
        switch (dc)            
        {            
            case TITLE:
                 ldResource.addProperty(DC.title, model.createLiteral(property));   
                break;
            case COVERAGE:
                 ldResource.addProperty(DC.coverage, model.createLiteral(property));    
                break;
            case CREATOR:
                 ldResource.addProperty(DC.creator, model.createLiteral(property));    
                break;
            case DATE:
                 ldResource.addProperty(DC.date, model.createLiteral(property));    
                break;
            case DESCRIPTION:
                 ldResource.addProperty(DC.description, model.createLiteral(property));    
                break;                
            case ID:
                 ldResource.addProperty(DC.identifier, model.createLiteral(property));    
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
