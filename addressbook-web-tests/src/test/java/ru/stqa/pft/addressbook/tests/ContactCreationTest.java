package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.NewContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {

        Contacts before = app.contact().all();
        app.goTo().addNewContact();
        NewContactData contact = new NewContactData().withFirstName("name1").withLastName("name2");
        app.contact().createContact(contact);
        app.returnToHomePage();
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() +1));
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
    }

}