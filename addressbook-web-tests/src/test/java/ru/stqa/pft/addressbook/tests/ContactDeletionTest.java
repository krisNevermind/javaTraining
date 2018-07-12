package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (! app.getContactHelper().isThereContact()){
            app.goTo().addNewContact();
            app.getContactHelper().createContact(new NewContactData("name1", "name2", "12345", "email@email.com"));
        }
    }

    @Test
    public void testContactDeletion() {
        List<NewContactData> before = app.getContactHelper().getContactList();
        int index = before.size() - 1;
        app.getContactHelper().selectContact(index);
        app.getContactHelper().deleteSelectedContact();
        app.getWebDriver().switchTo().alert().accept();
        app.getContactHelper().returnHome();
        List<NewContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), index);

        before.remove(index);
        Assert.assertEquals(after, before);
    }

}
