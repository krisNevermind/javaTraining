package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(FirefoxDriver wd) {

        super (wd);
    }

    public void goToGroupPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    public void addNewContact() {
        click(By.linkText("add new"));
    }
}
