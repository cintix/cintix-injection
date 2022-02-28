/*
 */
package dk.cintix.injection.annotations.impl;

import dk.cintix.injection.annotations.Implementation;
import dk.cintix.injection.annotations.Inject;
import dk.cintix.injection.interfaces.AnnotationManager;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author migo
 */
public class InjectImpl implements AnnotationManager {
    @Override
    public void process(Annotation annotation, Class cls, Object obj) {
        for (Field field : obj.getClass().getDeclaredFields()) {
            try {
                if (field.isAnnotationPresent(Inject.class)) {
                    Inject injectAnnotation = field.getAnnotation(Inject.class);
                    Class injectionInstance = field.getType();
                    if (injectionInstance.isAnnotationPresent(Implementation.class)) {
                        Implementation implementation = (Implementation) injectionInstance.getAnnotation(Implementation.class);
                        injectionInstance = implementation.from();
                    }
                    field.setAccessible(true);
                    field.set(injectionInstance.getDeclaredConstructor().newInstance(), obj);
                }
            } catch (NoSuchMethodException noSuchMethodException) {
            } catch (SecurityException securityException) {
            } catch (InstantiationException instantiationException) {
            } catch (IllegalAccessException illegalAccessException) {
            } catch (IllegalArgumentException illegalArgumentException) {
            } catch (InvocationTargetException invocationTargetException) {
            }
        }
    }
    
}
