/*
 */
package dk.cintix.injection;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author migo
 */
public class AnnotationManager {

    private final static Map<Class<?> , Class<? extends dk.cintix.injection.interfaces.AnnotationManager>> managers = new TreeMap<>();
    private final static Map<Class<? extends dk.cintix.injection.interfaces.AnnotationManager>, dk.cintix.injection.interfaces.AnnotationManager> managerInstances = new TreeMap<>();

    public static void registerManager(Class<?> annotation, Class<? extends dk.cintix.injection.interfaces.AnnotationManager> cls) {
        managers.put(annotation, cls);
    }

    public static void injestAnnotations(Object obj) {
        Class<?> cls = obj.getClass();

        for (Annotation annotation : cls.getAnnotations()) {
            if (managers.containsKey(annotation.annotationType())) {
                Class<? extends dk.cintix.injection.interfaces.AnnotationManager> managerClass = managers.get(annotation);
                dk.cintix.injection.interfaces.AnnotationManager manager = instance(managerClass);
                manager.process(annotation, cls, obj);
            }
        }
    }

    private static dk.cintix.injection.interfaces.AnnotationManager instance(Class<? extends dk.cintix.injection.interfaces.AnnotationManager> cls) {
        try {
            if (!managerInstances.containsKey(cls)) {
                managerInstances.put(cls, cls.getDeclaredConstructor().newInstance());
            }
            return managerInstances.get(cls);
        } catch (Exception ex) {
            Logger.getLogger(AnnotationManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
