package ru.stqa.pft.addressbook.tests;

import org.hamcrest.Matcher;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.NewContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.db().contacts().size() == 0){
            app.goTo().addNewContact();
            app.contact().createContact(new  NewContactData().withFirstName("name1").withLastName("name2"));
        }
    }

    @Test
    public void testContactModification(){
        Contacts before = app.db().contacts();
        NewContactData modifiedContact = before.iterator().next();
        NewContactData contact = new NewContactData().withId(modifiedContact.getId()).withFirstName("name1").withLastName("name2")
                .withMobilePhone("456").withEmail("email@email.com").withAddress("address");
        app.contact().modifyContact(contact);
        assertEquals(app.contact().count(), before.size());
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }
}
