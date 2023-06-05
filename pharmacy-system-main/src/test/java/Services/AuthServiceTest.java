package Services;

import Models.Client;
import Models.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthServiceTest {

    @Test
    void employeeLoginWithCorrectCredentials() throws Exception {
        assertInstanceOf(Employee.class, AuthService.employeeLogin("ahmedmahmoud@gmail.com", "20232020"));
    }

    @Test
    void employeeLoginWithWrongPassword() {

        Exception e = assertThrows(Exception.class,()-> AuthService.employeeLogin("ahmedmahmoud@gmail.com", "2032020"));

        assertEquals("Wrong password!", e.getMessage());
    }

    @Test
    void employeeLoginWithNonExistingEmail() {

        Exception e = assertThrows(Exception.class,()-> AuthService.employeeLogin("ahmedhamed@gmail.com", "20232020"));

        assertEquals("This email does not exist", e.getMessage());
    }

    @Test
    void clientLoginWithCorrectCredentials() throws Exception{
        assertInstanceOf(Client.class, AuthService.clientLogin("mohamed.hagras2002@gmail.com", "450677"));
    }

    @Test
    void clientLoginWithWrongPassword() throws Exception {

        Exception e = assertThrows(Exception.class,()-> AuthService.clientLogin("mohamed.hagras2002@gmail.com", "66677"));

        assertEquals("Wrong password!", e.getMessage());
    }

    @Test
    void clientLoginWithNonExistingEmail() throws Exception {

        Exception e = assertThrows(Exception.class,()-> AuthService.clientLogin("mohamed4444@gmail.com", "66677"));

        assertEquals("This email does not exist", e.getMessage());
    }
}