package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			//	NOTE by Akash :- Updated the ArayList size i.e [3] and assigned getter values to ArrayList indexes in sequential order.			
			Object[]  obj = new Object[3];
			obj[0] = temp.getEmailId();
			obj[1] = temp.getFirstName();
			obj[2] = temp.getLastName();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		// NOTE by Akash:- Path of xlsx file located in local machine, to read test-case input values from excel. 
		String fileName ="C:/Users/AKASHTYAGI/Desktop/Selenium_Learning-Manipal/Selenium_Project/Test_Registration.xlsx";
	    String sheetNumber = "1";

		return new ApachePOIExcelRead().getExcelContent(fileName, sheetNumber); 
	}
	

	@DataProvider(name = "excel2-inputs")
	public Object[][] getExcelSecondTabData(){
		// NOTE by Akash:- Path of xlsx file located in local machine, to read test-case input values from excel. 
		String fileName ="C:/Users/AKASHTYAGI/Desktop/Selenium_Learning-Manipal/Selenium_Project/Test_Registration.xlsx"; 
		String sheetNumber = "2";
		
		return new ApachePOIExcelRead().getExcelContent(fileName, sheetNumber); 
	}
	
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
