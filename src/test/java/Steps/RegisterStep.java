package Steps;

import Base.BaseStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.xml.bind.SchemaOutputResolver;
import java.util.*;

public class RegisterStep extends BaseStep {
    String uuid = UUID.randomUUID().toString();

    @Given("^a web browser is at the Hepsiburada home page$")
    public void aWebBrowserIsAtTheHepsiburadaHomePage() {
        geturl();
    }

    @When("^the user click dropdown$")
    public void theUserClickDropdown() {
        findElementClick("myAccount",Pather.id);

    }

    @And("^user clicks on the login item$")
    public void userClicksOnTheLoginItem() {
        findElementClick("login",Pather.id);
    }

    @Then("^user sees the login form$")
    public void userSeesTheLoginForm() {

        waitElement(findElement("txtUserName",Pather.id,""),TimeOut.LOW);
    }

    @And("^user enters the mail$")
    public void userEntersTheMail() {
        PageScrolldown();
        findElement("txtUserName",Pather.id,"").sendKeys("nailerdemir3535@gmail.com");
    }

    @And("^user click login button$")
    public void userClickLoginButton() {
        findElementClick("btnLogin",Pather.id);
    }

    @And("^user enters password$")
    public void userEntersPassword() {

        findElement("txtPassword",Pather.id,"").sendKeys("nail1994");
    }

    @And("^user click Login2 button$")
    public void userClickLogin2Button() {
        findElementClick("btnEmailSelect",Pather.id);
    }

    @And("^search product$")
    public void searchBoxClick(){
        findElement("#SearchBoxOld > div > div > div.SearchBoxOld-inputContainer",Pather.cssSelector).click();
        findElement("#SearchBoxOld > div > div > div.SearchBoxOld-inputContainer",Pather.cssSelector).sendKeys("Iphone11");
        findElement("#SearchBoxOld > div > div > div.SearchBoxOld-buttonContainer",Pather.cssSelector).click();
    };

    @And("^driver close$")
    public void driverClose() {
        DriverQuit();
    }

    @And("^HepsiBurada text click$")
    public void hepsiburadaTextClick() {
        findElementClick("/html/body/div/div/div/div[1]/div[1]/a",Pather.xPath);
    }

    @And("^Take first product$")
    public void takeFirstProduct() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> elementList= driver.findElements(By.xpath("/html/body/div[3]/main/div[2]/div/div[6]/div[2]/div[2]/div[4]/div/div/div/div/div/div/div/ul/li"));
        System.out.println(elementList.size());
        elementList.get(0).click();
    }

    @And("^Enter new tab$")
    public void enterNewTab() {
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<String>(windowHandles);

        System.out.println("Total window number: " + windowHandlesList.size() + "\n");

        driver.switchTo().window(windowHandlesList.get(1));
    }
    @And("^Take First Product Store Name$")
    public void takeFirstProductStoreName() {
        WebElement element1=findElement("/html/body/div[2]/main/div[3]/section[1]/div[4]/div/div[4]/div[1]/div[2]/div/div[1]/div[4]/div[1]/span/span[2]/a",Pather.xPath);
        String bayiAdi=element1.getText();
        System.out.println(bayiAdi);
        GenelHash.put("a",bayiAdi);
        WebElement urunAdi1=findElement("/html/body/div[2]/main/div[3]/section[1]/div[4]/div/div[4]/div[1]/header/h1",Pather.xPath);
        String urunAdi2=urunAdi1.getText();
        GenelHash.put("ilkUrunAdi",urunAdi2);
        WebElement urunFiyatBasi=findElement("/html/body/div[2]/main/div[3]/section[1]/div[4]/div/div[4]/div[1]/div[2]/div/div[1]/div[1]/span/span[1]",Pather.xPath);
        String urunFiyatBasi1=urunFiyatBasi.getText();
        WebElement urunFiyatSonu=findElement("/html/body/div[2]/main/div[3]/section[1]/div[4]/div/div[4]/div[1]/div[2]/div/div[1]/div[1]/span/span[2]",Pather.xPath);
        String urunFiyatSonu1=urunFiyatSonu.getText();
        String urunFiyatTam=urunFiyatBasi1+","+urunFiyatSonu1+" TL";
        GenelHash.put("ilkUrunFiyat",urunFiyatTam);
        System.out.println(urunAdi2+" - "+urunFiyatTam);
        findElementClick("addToCart",Pather.id);
    }


    @And("^Return Old Tab$")
    public void returnOldTab() {
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<String>(windowHandles);

        System.out.println("Total window number: " + windowHandlesList.size() + "\n");

        driver.switchTo().window(windowHandlesList.get(0));
    }

    @And("^Take Second Product$")
    public void takeSecondProduct() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> elementList= driver.findElements(By.xpath("/html/body/div[3]/main/div[2]/div/div[6]/div[2]/div[2]/div[4]/div/div/div/div/div/div/div/ul/li"));
        System.out.println(elementList.size());
        for (int i = 1; i <= elementList.size(); i++) {
            System.out.println(i);
            elementList.get(i).click();
            Set<String> windowHandles = driver.getWindowHandles();
            List<String> windowHandlesList = new ArrayList<String>(windowHandles);
            System.out.println("Total window number: " + windowHandlesList.size() + "\n");
            driver.switchTo().window(windowHandlesList.get(i+1));
            WebElement element1=findElement("/html/body/div[2]/main/div[3]/section[1]/div[4]/div/div[4]/div[1]/div[2]/div/div[1]/div[4]/div[1]/span/span[2]/a",Pather.xPath);
            String bayiAdi1=element1.getText();
            System.out.println(bayiAdi1);
            System.out.println(GenelHash.get("a"));
            System.out.println(GenelHash.get("a").contains((bayiAdi1)));
            if (!(GenelHash.get("a").contains(bayiAdi1)))
            {
                findElementClick("addToCart",Pather.id);
                i=elementList.size();
                WebElement urunAdi3=findElement("/html/body/div[2]/main/div[3]/section[1]/div[4]/div/div[4]/div[1]/header/h1",Pather.xPath);
                String urunAdi4=urunAdi3.getText();
                GenelHash.put("ikinciUrunAdi",urunAdi4);
                WebElement urunFiyatBasi2=findElement("/html/body/div[2]/main/div[3]/section[1]/div[4]/div/div[4]/div[1]/div[2]/div/div[1]/div[1]/span/span[1]",Pather.xPath);
                String urunFiyatBasi3=urunFiyatBasi2.getText();
                WebElement urunFiyatSonu2=findElement("/html/body/div[2]/main/div[3]/section[1]/div[4]/div/div[4]/div[1]/div[2]/div/div[1]/div[1]/span/span[2]",Pather.xPath);
                String urunFiyatSonu3=urunFiyatSonu2.getText();
                String urunFiyatTam1=urunFiyatBasi3+","+urunFiyatSonu3+" TL";
                GenelHash.put("ikinciUrunFiyat",urunFiyatTam1);
                System.out.println(urunAdi4+" - "+urunFiyatTam1);
            };
            driver.switchTo().window(windowHandlesList.get(0));
        }

    }

    @And("^Go to Basket$")
    public void goToBasket() throws InterruptedException {
        Thread.sleep(3000);
        findElementClick("/html/body/div[3]/div[2]/div[1]/div/div/div/div/div/div[2]/div[3]/a/span[2]",Pather.xPath);
    }

    @And("^Control Basket$")
    public void controlBasket() {
        WebElement element1= findElement("/html/body/div/div/div/div[2]/div/div[2]/section/section/div[4]/div/ul/li/div/div/div[1]/div[2]/div[2]/a",Pather.xPath);
        String birinciUrunAd=element1.getText();
        WebElement element2= findElement("/html/body/div/div/div/div[2]/div/div[2]/section/section/div[4]/div/ul/li/div/div/div[1]/div[2]/div[4]/div[1]/div[1]/div[2]",Pather.xPath);
        String birinciUrunFiyat=element2.getText();
        WebElement element3= findElement("/html/body/div/div/div/div[2]/div/div[2]/section/section/div[3]/div/ul/li/div/div/div[1]/div[2]/div[2]/a",Pather.xPath);
        String ikinciUrunAd=element3.getText();
        WebElement element4= findElement("/html/body/div/div/div/div[2]/div/div[2]/section/section/div[3]/div/ul/li/div/div/div[1]/div[2]/div[4]/div[1]/div[1]/div[2]",Pather.xPath);
        String ikinciUrunFiyat=element4.getText();
        if (GenelHash.get("ilkUrunAdi").contains(birinciUrunAd)){
            System.out.println("İlk ürünün adı doğru");
        }
        else {
            System.out.println("İlk ürünün adı yanlış");
        }


        if (GenelHash.get("ilkUrunFiyat").contains(birinciUrunFiyat)){
            System.out.println("İlk ürünün fiyatı doğru");
        }
        else {
            System.out.println("İlk ürünün fiyatı yanlış");
        }


        if (GenelHash.get("ikinciUrunAdi").contains(ikinciUrunAd)){
            System.out.println("İkinci ürünün adı doğru");
        }
        else {
            System.out.println("İkinci ürünün adı yanlış");
        }


        if (GenelHash.get("ikinciUrunFiyat").contains(ikinciUrunFiyat)){
            System.out.println("İkinci ürünün fiyatı doğru");
        }
        else {
            System.out.println("İkinci ürünün fiyatı yanlış");
        }
    }
}

