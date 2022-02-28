/*
 */
package dk.cintix.injection.test.service;

/**
 *
 * @author cintix
 */
public class TestServiceImplementation implements TestService {

    @Override
    public String sayHello() {
        return "Hello my friend";
    }
    
}
