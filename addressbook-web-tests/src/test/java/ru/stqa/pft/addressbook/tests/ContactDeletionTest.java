package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.NewContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.db().contacts().size() == 0){
            app.goTo().addNewContact();
            app.contact().createContact(new  NewContactData().withFirstName("name1").withLastName("name2"));
        }
    }

    @Test
    public void testContactDeletion() {
        Contacts before = app.db().contacts();
        NewContactData deletedContact = before.iterator().next();
        app.contact().deleteContact(deletedContact);
        app.getWebDriver().switchTo().alert().accept();
        app.contact().returnHome();
        assertEquals(app.contact().count(), before.size() - 1);
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(deletedContact)));

    }


}
