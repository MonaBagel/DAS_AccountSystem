package za.ac.nwu.das.logic.service.imp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateAccountTypeServiceImpTest {

    private FetchAccountTypeServiceImp testClass;

    @BeforeEach
    void setUp() {
        testClass = new FetchAccountTypeServiceImp(null);

    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void methodTest() {
        assertTrue(testClass.methodToTest());
    }
}