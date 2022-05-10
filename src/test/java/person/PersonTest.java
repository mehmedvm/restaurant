package person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person tempPerson = new Person();

    @BeforeEach
    void setUp() {
    }

    @Test
    void NameTest() {
        tempPerson.setFirstName("Adam");
        tempPerson.setLastName("Ingram");
        assertEquals("Adam", tempPerson.getFirstName());
        assertEquals("Ingram", tempPerson.getLastName());
    }

    @Test
    void getPhoneNoTest() {
        tempPerson.setPhoneNo(1231231234);
        assertEquals(1231231234,tempPerson.getPhoneNo());
    }


}

/*
 @Test
    void groupedAssertions() {
        student.setName("Lindsay");
        student.setAge(25);

        assertAll("Test Props",
                () -> assertEquals("Lindsay", student.getName(), "First Name Failed"),
                () -> assertEquals(25, student.getAge(), "Wrong Age"),
                () -> assertEquals("ATL", student.getAddress(), "Wrong Address"));
    }
 */