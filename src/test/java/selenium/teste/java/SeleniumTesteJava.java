/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium.teste.java;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author gbjesus1
 */
public class SeleniumTesteJava {

    public static void main(String[] args) throws FileNotFoundException, IOException, AWTException {

        /* configurando o webdriver do Internet Explorer */
        // na linha abaixo, é informado o driver do IE e o caminho que ele se encontra
        System.setProperty("webdriver.ie.driver",
                "C:\\Users\\gbjesus1\\Documents\\Selenium\\WebDriver\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe");

        // Instanciando um objeto chamado driver do tipo WebDriver do Internet Explorer
        WebDriver driver = new InternetExplorerDriver();

        //Informando a URL do site que sera usado para teste.
        String baseUrl = "https://10.116.83.101:8010/sigov/index.do";
        //Executando o selenium
        driver.get(baseUrl);

        /* Aqui ja foi aberto o navegador, na URL informada acima
        o metodo findElement vai procurar na pagina atraves do parametro informado
        que no caso é o linkText, e tambem é informado o valor do texto que ele vai procurar
        quando ele achar, a função click sera acionado
         */
        driver.findElement(By.linkText("Mais informações")).click();
        driver.findElement(By.linkText("Continuar para a página da Web (não recomendado)")).click();
        /* Configuração para encotrar o caminho do arquivo em excell */
        File file = new File("C:\\Users\\gbjesus1\\Documents\\Selenium\\Massa\\GOVWEB_Inter_Mantem_Usuarios_CXA_1o Dia-7219.xlsx");
        FileInputStream fis = new FileInputStream(file);
//        /* Configurando a leitura do arquivo Excell */
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(32);
        Cell cell = row.getCell(4);

        // Variaveis que terão valor com os dados vindo da celula do excell para preenchimento
        //do campo GovConta Caixa
        String agencia = sheet.getRow(32).getCell(4).getStringCellValue();
        String fixoUm = sheet.getRow(32).getCell(5).getStringCellValue();
        String fixoDois = sheet.getRow(32).getCell(6).getStringCellValue();
        String Data = sheet.getRow(32).getCell(7).getStringCellValue();
////        /* -------------------------------------------------------------------- */
        WebElement govConta = driver.findElement(By.id("numeroGovConta"));
        govConta.sendKeys(agencia + fixoUm + fixoDois + Data);

        String senha = sheet.getRow(32).getCell(8).getStringCellValue();
        driver.findElement(By.id("senhaUsuario")).click();
        WebElement senhaUserd = driver.findElement(By.tagName("area")).findElement(By.id("rr"));
        WebElement senhaUser = driver.findElement(By.id("senhaUsuario"));
        
        senhaUser.sendKeys(senha);
        driver.switchTo().alert().accept();
        System.out.println(senhaUserd);
        

//        driver.findElement(By.id("tecladotecladoTeste")).sendKeys(senha);
//
//        WebElement senhaUsuario = driver.findElement(By.id("senhaUsuario"));
//        WebElement teclado = driver.findElement(By.id("tecladotecladoTeste"));
//        new Actions(driver).moveByOffset(9, 5).click().build().perform();
//        Robot robot = new Robot();
//        robot.mouseMove(0, 500);
//        robot.mousePress(InputEvent.BUTTON1_MASK);
//        robot.mouseRelease(InputEvent.BUTTON1_MASK);
//        System.out.println(cell);
        //System.out.println(sheet.getRow(32).getCell(4));
    }

}
