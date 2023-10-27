package org.mvn;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	// create a driver
			public static WebDriver driver;

			// create a browser launch
			public static void launchBrowser() {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				
			}
			// system minimize
			public static void WindowsMinimize() {
				driver.manage().window().maximize();
			}
			// launch URL
			public static void launchUrl(String url) {
				driver.get(url);
			}
			

			// get in page title
			public static void pageTitle() {
				String title = driver.getTitle();
				System.out.println(title);
			}

			// get in page URL
			public static void pageUrl() {
				String currentUrl = driver.getCurrentUrl();
				System.out.println(currentUrl);
			}

			// pass Text
			public static void passText(String txt, WebElement ele) {
				ele.sendKeys(txt);
			}

			// close the driver
			public static void closedriver() {
				driver.close();
			}

			// close all browser
			public static void close() {
				driver.quit();
			}

			// button click in browser
			public static void btnClick(WebElement ele) {
				ele.click();
			}

			// take a screenshot
			public static void ScreenShot(String imgName) throws IOException {
				TakesScreenshot ts = (TakesScreenshot) driver;
				File image = ts.getScreenshotAs(OutputType.FILE);
				File fs = new File("Location+ imgName.png");
				FileUtils.copyFile(image, fs);
			}

			// action
			public static Actions a;

			public static void moveCursor(WebElement targetWebElement) {
				a = new Actions(driver);
				a.dragAndDrop(targetWebElement, targetWebElement).perform();
			}

			// java Executor
			public static JavascriptExecutor js;

			public static void scrollThePage(WebElement element) {
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true)", element);
			}

			public static void scroll(WebElement tarWebEle) {
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(false)", tarWebEle);
			}

			// EXCEL SHEET
			public static void CreateExcelSheet(int rowNum,int cellNum,String NewData) throws IOException {
				File f = new File("C:\\Users\\MARUTHUMP\\eclipse-workspace\\MavenProject\\Excel\\NewSheet1.xlsx");
//				FileInputStream fis = new FileInputStream(f);
				Workbook wb = new XSSFWorkbook();
				Sheet NewSheet = wb.createSheet();
				Row createRow = NewSheet.createRow(rowNum);
				Cell createCell = createRow.createCell(cellNum);
				createCell.setCellValue(NewData);
				FileOutputStream fos = new FileOutputStream(f);
				wb.write(fos);
			}
			public static void CreateCell(int rowNum,int cellNum,String NewData) throws IOException {
				File f = new File("C:\\Users\\MARUTHUMP\\eclipse-workspace\\MavenProject\\Excel\\NewSheet1.xlsx");
//				FileInputStream fis = new FileInputStream(f);
				Workbook wb = new XSSFWorkbook();
				Sheet NewSheet = wb.createSheet();
				Row createRow = NewSheet.getRow(rowNum);
				Cell createCell = createRow.createCell(cellNum);
				createCell.setCellValue(NewData);
				FileOutputStream fos = new FileOutputStream(f);
				wb.write(fos);
			}
			public static void CreateRows(int rowNum,int cellNum,String NewData) throws IOException {
				File f = new File("C:\\Users\\MARUTHUMP\\eclipse-workspace\\MavenProject\\Excel\\NewSheet1.xlsx");
//				FileInputStream fis = new FileInputStream(f);
				Workbook wb = new XSSFWorkbook();
				Sheet NewSheet = wb.createSheet();
				Row createRow = NewSheet.getRow(rowNum);
				Cell createCell = createRow.getCell(cellNum);
				createCell.setCellValue(NewData);
				FileOutputStream fos = new FileOutputStream(f);
				wb.write(fos);
				
			}
			public static void UpdateTheParticularCell(String WriteNewData,String exisitingData, int getrowNum, int getcellNum) throws IOException {
				//file create
				File f = new File("C:\\Users\\MARUTHUMP\\eclipse-workspace\\MavenProject\\Excel");
				FileInputStream fis = new FileInputStream(f);
				Workbook ws = new XSSFWorkbook(fis);
				Sheet s = ws.createSheet("Datas");
				Row r = s.getRow(getrowNum);
				Cell c = r.getCell(getcellNum);
				String StringCell = c.getStringCellValue();
				if (StringCell.equals(exisitingData)) {
					c.setCellValue(WriteNewData);
				} 
				FileOutputStream fos = new FileOutputStream(f);
				ws.write(fos);
				}

		}