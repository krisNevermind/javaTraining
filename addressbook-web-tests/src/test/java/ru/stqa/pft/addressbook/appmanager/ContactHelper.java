package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitNewContact() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillInContactData(NewContactData newContactData) {
        type(By.name("firstname"), newContactData.getFirstName());
        type(By.name("lastname"), newContactData.getLastName());
        type(By.name("mobile"), newContactData.getHomePhoneNumber());
        type(By.name("email"), newContactData.getEmail());
    }

    public void deleteSelectedContact() {

        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void openContactForEditing() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void createContact(NewContactData contact) {
        fillInContactData(contact);
        submitNewContact();
    }

    public boolean isThereContact() {
    return isElementPresent(By.name("selected[]"));
    }

    public List<NewContactData> getContactList() {
        List<NewContactData> contacts = new ArrayList<NewContactData>();
        List<WebElement> elements = wd.findElements(By.xpath("//td[@class='center']//input"));
        for (WebElement element : elements) {
            String name = element.getText();
            NewContactData contact = new NewContactData(name, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
