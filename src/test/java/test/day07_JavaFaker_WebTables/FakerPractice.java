package test.day07_JavaFaker_WebTables;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerPractice {

    @Test
    public void Faker_test(){
        Faker faker = new Faker();

        String name = faker.name().fullName(); // Miss Samanta Schmidt
        System.out.println("name = " + name);
        String firstName = faker.name().firstName(); // Emory
        System.out.println("firstName = " + firstName);
        String lastName = faker.name().lastName(); // Barton
        System.out.println("lastName = " + lastName);

        String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
        System.out.println("streetAddress = " + streetAddress);

        String howIMetYporMother = faker.howIMetYourMother().catchPhrase();
        System.out.println("howIMetYporMother = " + howIMetYporMother);

        String friends = faker.friends().quote();
        System.out.println("friends = " + friends);


    }
}
