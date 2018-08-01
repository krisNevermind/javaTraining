package ru.stqa.pft.mantis.appmanager;

import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class PasswordHelper extends HelperBase {

    public PasswordHelper(ApplicationManager app) {
        super(app);
    }

    public void loginUI (String username, String password){
        type(By.xpath("//input[@name='username']"), username);
        click(By.xpath("//input[@value='Login']"));
        type(By.xpath("//input[@name='password']"), password);
        click(By.xpath("//input[@value='Login']"));
    }

    public void navigateToUserManagement(){
        click(By.xpath("//span[@class='menu-text'][contains(text(), 'Manage')]"));
        click(By.xpath("//a[text()='Manage Users']"));
    }

    public void selectSomeUser(){
        List<WebElement> rows = wd.findElements(By.xpath("//table//tbody//tr"));
        int count = rows.size();
        String randomRowNumber = getRandomNumberFrom(1, count);
        click(By.xpath("//tbody//tr["+randomRowNumber+"]//a"));
    }

    public void resetUserPassword(){
        click(By.xpath("//input[@value='Reset Password']"));
    }

    public String extractUserEmail(){
        String userEmail = wd.findElement(By.xpath("//tr[3]//input[@name='email']")).getAttribute("value");
        return userEmail;
    }

    public String extractUserName(){
        String userName = wd.findElement(By.xpath("//tr[1]//input[@name='username']")).getAttribute("value");
        return userName;
    }

    public void resetPassword(String confirmationLink, String newPassword){
        wd.get(confirmationLink);
        type(By.xpath("//tr[3]//input[@name='password']"), newPassword);
        type(By.xpath("//tr[4]//input[@name='password_confirm']"), newPassword);
        click(By.xpath("//span[text()='Update User']"));
    }

    public static String getRandomNumberFrom(int min, int max) {
        Random r = new Random();
        String s = String.valueOf(r.nextInt((max - min) + 1) + min);
        return s;

    }


}
