/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium.teste.java;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 *
 * @author gbjesus1
 */
public class usarTecladoVirtual {

    public void usarTecladoVirtual(String senha) {
        WebDriver driver = WebDriver();

        for (int i = 0; i < senha.length(); i++) {
            String indice = "" + senha.charAt(i);

            switch (indice) {
                case "1":
                    driver.findElement(By.xpath("//map[@id='tecladotecladoTeste']/area[1]")).click();
                    break;
                case "2":
                    driver.findElement(By.xpath("//map[@id='tecladotecladoTeste']/area[2]")).click();

            }
        }

    }

    private WebDriver WebDriver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
