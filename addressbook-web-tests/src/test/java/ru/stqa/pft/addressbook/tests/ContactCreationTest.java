package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {

        List<NewContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().addNewContact();
        NewContactData contact = new NewContactData("name1", "name2", "12345", "email@email.com");
        app.getContactHelper().createContact(contact);
        app.returnToHomePage();
        List<NewContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() +1);

        int max = 0;
        for (NewContactData g : after){
            if (g.getId()>max){
                max = g.getId();
            }
        }
        contact.setId(max);
        before.add(contact);
        Comparator<? super NewContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
  //      Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
        Assert.assertEquals(before, after);
    }

}