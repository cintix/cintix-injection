/*
 */
package dk.cintix.injection.test.service;

import dk.cintix.injection.annotations.Implementation;

/**
 *
 * @author cintix
 */
@Implementation(from = TestServiceImplementation.class)
public interface TestService {
    public String sayHello();
}
