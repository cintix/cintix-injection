/*
 */
package dk.cintix.injection;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

/**
 *
 * @author cintix
 */
public class ClassScanner {

    /**
     * 
     * @param packageName
     * @param recursive
     * @return 
     */
    public static List<Class> getClassesFromPackage(String packageName, boolean recursive) {
        List<Class> classes = new LinkedList<>();
        try {
            final StandardJavaFileManager fileManager = ToolProvider.getSystemJavaCompiler().getStandardFileManager(null, null, null);
            Iterator<JavaFileObject> fileObjects = fileManager.list(StandardLocation.CLASS_PATH, packageName, Collections.singleton(JavaFileObject.Kind.CLASS), recursive).iterator();
            while (fileObjects.hasNext()) {
                JavaFileObject obj = fileObjects.next();
                final String[] split = obj.getName()
                        .replace(".class", "")
                        .replace(")", "")
                        .split(Pattern.quote(File.separator));
                final String fullClassName = packageName + "." + split[split.length - 1];
                classes.add(Class.forName(fullClassName));
            }
        } catch (Exception iOException) {
            iOException.printStackTrace();
        }
        return classes;
    }
}
