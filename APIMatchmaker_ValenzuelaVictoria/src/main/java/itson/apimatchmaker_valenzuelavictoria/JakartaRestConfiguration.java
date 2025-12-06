package itson.apimatchmaker_valenzuelavictoria;

import api.PerfilesResource;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Configures Jakarta RESTful Web Services for the application.
 * @author Juneau
 */
@ApplicationPath("api")
public class JakartaRestConfiguration extends Application {
    
    @Override
    public Set<Class<?>> getClasses(){
       final Set<Class<?>> classes = new HashSet<>();
       
       classes.add(PerfilesResource.class);
       
       return classes;
    }
}
