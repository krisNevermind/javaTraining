package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {

        Contacts before = app.contact().all();
        app.goTo().addNewContact();
        File photo = new File ("src/test/resources/picture.png");
        NewContactData contact = new NewContactData().withFirstName("name1").withLastName("name2").withPhoto(photo);
        app.contact().createContact(contact);
        app.returnToHomePage();
        assertThat(app.contact().count(), equalTo(before.size() +1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
    }

    @Test (enabled = false)
    public void testCurrentDir(){ File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File ("src/test/resources/picture.png");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }

}