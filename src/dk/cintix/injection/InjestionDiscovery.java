/*
 */
package dk.cintix.injection;

import dk.cintix.injection.annotations.Inject;
import dk.cintix.injection.annotations.impl.InjectImpl;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author cintix
 */
public class InjestionDiscovery {
    
    static {
        AnnotationManager.registerManager(Inject.class, InjectImpl.class);
    }
    
    private final static Map<Class<?>, Object> discovered = new TreeMap<>(); 
    
    public static void discovery(String packages) {
        List<Class> classesFromPackage = ClassScanner.getClassesFromPackage(packages, true);
        for(Class cls : classesFromPackage) {
            
        }
        
    }
    
    
}
