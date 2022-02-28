/*
 */
package dk.cintix.injection.interfaces;

import java.lang.annotation.Annotation;

/**
 *
 * @author migo
 */
public interface AnnotationManager {
    public void process(Annotation annotation, Class cls, Object obj);
}
