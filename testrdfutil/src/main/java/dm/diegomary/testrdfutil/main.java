
package dm.diegomary.testrdfutil;

import com.dm.rdfutil.DCTERMS;
import com.dm.rdfutil.LinkedData;
import com.dm.rdfutil.NsPrefix;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Diego
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        LinkedData ld = new LinkedData();
        ld.AddPrefix(new NsPrefix("wbs", "http://webnames.com/"));
      
        ld.CreateResource("http://dmm888.com/diegowebsite");
        ld.AddPrefixedResource("https://profiles.google.com/116142573163051163758/about", "wbs", "owner");
        ld.AddPrefixedProperty("wbs", "webprovider","aruba");
        ld.AddPrefixedProperty("wbs", "ftpenabled","true");
        
        ld.CreateResource("http://dmm888.com/mariawebsite");
        ld.AddPrefixedResource("http://mariaburlando.com", "wbs", "owner");
        ld.AddPrefixedProperty("wbs", "webprovider","amazon");
        ld.AddPrefixedProperty("wbs", "ftpenabled","false");
        
        ld.SetCurrentResource("http://dmm888.com/diegowebsite");
        ld.AddPrefixedProperty("wbs", "spaceavailable","unlimited");
        
        
        ld.SetCurrentResource("http://dmm888.com/mariawebsite");
        ld.AddPrefixedProperty("wbs", "spaceavailable","2gb");
        
        try {
            ld.WriteRdfFile("d://test.rdf");
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.print(ld.GetRdf());
    }
    
}
