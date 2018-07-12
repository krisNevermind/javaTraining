package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (! app.getContactHelper().isThereContact()){
            app.goTo().addNewContact();
            app.getContactHelper().createContact(new  NewContactData().withFirstName("name1").withLastName("name2"));
        }
    }

    @Test
    public void testContactModification(){
        Set<NewContactData> before = app.getContactHelper().all();
        NewContactData modifiedContact = before.iterator().next();
 //       int index = before.size() - 1;
        NewContactData contact = new NewContactData().withId(modifiedContact.getId()).withFirstName("name1").withLastName("name2").withHomePhoneNumber("12345").withEmail("email@email.com");
        app.getContactHelper().modifyContact(contact);
        Set<NewContactData> after = app.getContactHelper().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedContact);
        before.add(contact);
/*        Comparator<? super NewContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  */
        Assert.assertEquals(before, after);
    }


}
