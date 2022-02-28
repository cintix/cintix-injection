/*
 */
package dk.cintix.injection.test;

import dk.cintix.injection.ClassScanner;
import java.util.List;

/**
 *
 * @author migo
 */
public class TestImplmentation {

    
    
    public static void main(String[] args) {
        new TestImplmentation().test();
    }

    private void test() {
        List<Class> testClasses = ClassScanner.getClassesFromPackage("dk.cintix.injection.test", true);
        

    }
}
