package com.psci.testscripts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.psci.pageobject.PatientRiskAnalyzer;
import com.psci.pageobject.VitreosLoginPage;
import com.psci.util.DriverScript;
import com.psci.util.ExcelUtil;
import com.psci.util.InitilizeURL;
import com.psci.util.InitilizerDriverBrowser;
import com.psci.util.ScreenShot;

public class TestPSCI {
	
	public VitreosLoginPage vlp;
	public PatientRiskAnalyzer pra;
	
	
@Parameters("Browser")
@BeforeTest()
public void beforeTest(String browser) 
{
		  InitilizerDriverBrowser.driver = InitilizerDriverBrowser.launchBrowser(browser);
		  InitilizerDriverBrowser.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  InitilizeURL.launchURL("http://202.89.104.116:8080/ClaimsAnalyzer/"); // Test URL
		  //InitilizeURL.launchURL("https://192.99.45.121/Macombs/logoutAction.do");	//Demo URL
		  vlp = PageFactory.initElements(InitilizerDriverBrowser.driver, VitreosLoginPage.class);
		  pra = PageFactory.initElements(InitilizerDriverBrowser.driver, PatientRiskAnalyzer.class);
}
	
	
	
	@DataProvider (name = "Authentication")
	public Object[][] credentials() throws Exception{
		
		Object[][] getData = new DriverScript().getTestData(".\\input\\TestData.xls", "login");
		return getData;
	}


		
	//Login the application with valid credentials 
	@Test(dataProvider = "Authentication", priority=1, enabled=true )
	public void verifyLogin(String username, String passwd){
			
				vlp.verifyLoginPage();
			  	Reporter.log("Verified the Login Page Title Successfully...!");
			  
			  	vlp.loginToVitreos(username, passwd);
			  	Reporter.log("Login into Vitreos by : " + vlp.userNameText.getText() + " successfully and navigating to Patient Risk Analyzer page");
	}
	
	
	
	//Test Cases: 01
	@Test(priority = 2, description = "Verify that without any filter, all dimensions open without any error.", enabled=true)
	public void dimensionsTest(){
		
		pra.dimensionClick(pra.dateOfServiceDimension, pra.signPlusMinusDOS);
		Reporter.log(pra.dateOfServiceDimension.getText() + " dimension is clicked and expanded successfully.");
		
		pra.dimensionClick(pra.chronicConditionDimension, pra.signPlusMinusCC);
		Reporter.log(pra.chronicConditionDimension.getText() + " dimension is clicked and expanded successfully.");
		
		pra.dimensionClick(pra.noOfChronicConditionDimension, pra.signPlusMinusNCC);
		Reporter.log(pra.noOfChronicConditionDimension.getText() + " dimension is clicked and expanded successfully.");
		
		pra.dimensionClick(pra.pCpDimension, pra.signPlusMinusPCP);
		Reporter.log(pra.pCpDimension.getText() + " dimension is clicked and expanded successfully.");
		
		pra.dimensionClick(pra.patientDimension, pra.signPlusMinusPatient);
		Reporter.log(pra.patientDimension.getText() + " dimension is clicked and expanded successfully.");
		
		pra.dimensionClick(pra.physicianDimension, pra.signPlusMinusPhysician);
		Reporter.log(pra.physicianDimension.getText() + " dimension is clicked and expanded successfully.");
		
		pra.dimensionClick(pra.ageGroupDimension, pra.signPlusMinusAG);
		Reporter.log(pra.ageGroupDimension.getText() + " dimension is clicked and expanded successfully.");
		
		pra.dimensionClick(pra.payerDimension, pra.signPlusMinusPayer);
		Reporter.log(pra.payerDimension.getText() + " dimension is clicked and expanded successfully.");
		
		pra.dimensionClick(pra.providerDimension, pra.signPlusMinusProvider);
		Reporter.log(pra.providerDimension.getText() + " dimension is clicked and expanded successfully.");
		
		pra.dimensionClick(pra.admissionTypeDimension, pra.signPlusMinusAdmissionType);
		Reporter.log(pra.admissionTypeDimension.getText() + " dimension is clicked and expanded successfully.");
		
		pra.dimensionClick(pra.claimsSpeDimension, pra.signPlusMinusClaimsSpeciality);
		Reporter.log(pra.claimsSpeDimension.getText() + " dimension is clicked and expanded successfully.");
		
		pra.dimensionClick(pra.claimsTypeDimension, pra.signPlusMinusClaimsType);
		Reporter.log(pra.claimsTypeDimension.getText() + " dimension is clicked and expanded successfully.");
		
		pra.dimensionClick(pra.placeOfServiceDimension, pra.signPlusMinusPlaceOfService);
		Reporter.log(pra.placeOfServiceDimension.getText() + " dimension is clicked and expanded successfully.");
		
		pra.dimensionClick(pra.drgDimension, pra.signPlusMinusDRG);
		Reporter.log(pra.drgDimension.getText() + " dimension is clicked and expanded successfully.");
		
		pra.dimensionClick(pra.procedureDimension, pra.signPlusMinusProcedure);
		Reporter.log(pra.procedureDimension.getText() + " dimension is clicked and expanded successfully.");
		
		pra.dimensionClick(pra.clinicDimension, pra.signPlusMinusClinic);
		Reporter.log(pra.clinicDimension.getText() + " dimension is clicked and expanded successfully.");
		
		pra.dimensionClick(pra.zipcodeDimension, pra.signPlusMinusZipcode);
		Reporter.log(pra.zipcodeDimension.getText() + " dimension is clicked and expanded successfully.");
		
		pra.dimensionClick(pra.pcpAffiliationDimension, pra.signPlusMinusAffiliation);
		Reporter.log(pra.pcpAffiliationDimension.getText() + " dimension is clicked and expanded successfully.");
		
		pra.dimensionClick(pra.medicationsDimension, pra.signPlusMinusMedications);
		Reporter.log(pra.medicationsDimension.getText() + " dimension is clicked and expanded successfully.");
		
	}
	
	
	
	//Test Cases: 02
		@Test(priority=3, description="Verify that the Summary row opens for each dimension without any error and TotalCost are equal for all dimensions", enabled=true)
		public void dimensionSummaryTotalCostTest(){
			
			String chronicSummaryTotalCost = pra.dimensionSummaryClick(pra.chronicConditionDimension, pra.signPlusMinusCC, pra.summaryCC, pra.summaryTotalCostCC);
			System.out.println(chronicSummaryTotalCost);
			Reporter.log("Chronic Condition summary is clicked successfully.");
			
			String noOfChronicSummaryTotalCost = pra.dimensionSummaryClick(pra.noOfChronicConditionDimension, pra.signPlusMinusNCC, pra.summaryNCC, pra.summaryTotalCostNCC);
			System.out.println(noOfChronicSummaryTotalCost);
			Reporter.log("No Of Chronic Condition summary is clicked successfully.");
			 
			String pCpDimensionSummaryTotalCost = pra.dimensionSummaryClick(pra.pCpDimension, pra.signPlusMinusPCP, pra.summaryPCP, pra.summaryTotalCostPCP);
			System.out.println(pCpDimensionSummaryTotalCost);
			Reporter.log("PCP summary is clicked successfully.");
			
			String patientDimensionSummaryTotalCost = pra.dimensionSummaryClick(pra.patientDimension, pra.signPlusMinusPatient, pra.summaryPatient, pra.summaryTotalCostPatient);
			System.out.println(patientDimensionSummaryTotalCost);
			Reporter.log("Patient summary is clicked successfully.");
			
			String physicianDimensionSummaryTotalCost = pra.dimensionSummaryClick(pra.physicianDimension, pra.signPlusMinusPhysician, pra.summaryPhysician, pra.summaryTotalCostPhysician);
			System.out.println(physicianDimensionSummaryTotalCost);
			Reporter.log("Attending Physician summary is clicked successfully.");
			
			String dateOfServiceDimensionSummaryTotalCost = pra.dimensionSummaryClick(pra.dateOfServiceDimension, pra.signPlusMinusDOS, pra.summaryDOS, pra.summaryTotalCostDOS);
			System.out.println(dateOfServiceDimensionSummaryTotalCost);
			Reporter.log("Date of Service summary is clicked successfully.");
			
			String ageGroupDimensionSummaryTotalCost = pra.dimensionSummaryClick(pra.ageGroupDimension, pra.signPlusMinusAG, pra.summaryAG, pra.summaryTotalCostAG);
			System.out.println(ageGroupDimensionSummaryTotalCost);
			Reporter.log("Age Group summary is clicked successfully.");
			
			String payerDimensionSummaryTotalCost = pra.dimensionSummaryClick(pra.payerDimension,  pra.signPlusMinusPayer, pra.summaryPayer, pra.summaryTotalCostPayer);
			System.out.println(payerDimensionSummaryTotalCost);
			Reporter.log("Payer summary is clicked successfully.");
			
			String providerDimensionSummaryTotalCost = pra.dimensionSummaryClick(pra.providerDimension,  pra.signPlusMinusProvider, pra.summaryProvider, pra.summaryTotalCostProvider);
			System.out.println(providerDimensionSummaryTotalCost);
			Reporter.log("Provider summary is clicked successfully.");
			
			String admissionTypeDimensionSummaryTotalCost = pra.dimensionSummaryClick(pra.admissionTypeDimension,  pra.signPlusMinusAdmissionType, pra.summaryAdmissionType, pra.summaryTotalCostAdmissionType);
			System.out.println(admissionTypeDimensionSummaryTotalCost);
			Reporter.log("Admission Type summary is clicked successfully.");
			
			String claimsSpeDimensionSummaryTotalCost = pra.dimensionSummaryClick(pra.claimsSpeDimension,  pra.signPlusMinusClaimsSpeciality, pra.summaryClaimsSpeciality, pra.summaryTotalCostClaimsSpeciality);
			System.out.println(claimsSpeDimensionSummaryTotalCost);
			Reporter.log("Claims Speciality summary is clicked successfully.");
			
			String claimsTypeDimensionSummaryTotalCost = pra.dimensionSummaryClick(pra.claimsTypeDimension,  pra.signPlusMinusClaimsType, pra.summaryClaimsType, pra.summaryTotalCostClaimsType);
			System.out.println(claimsTypeDimensionSummaryTotalCost);
			Reporter.log("Claim Type summary is clicked successfully.");
			
			String placeOfServiceDimensionSummaryTotalCost = pra.dimensionSummaryClick(pra.placeOfServiceDimension,  pra.signPlusMinusPlaceOfService, pra.summaryPlaceOfService, pra.summaryTotalCostPlaceOfService);
			System.out.println(placeOfServiceDimensionSummaryTotalCost);
			Reporter.log("Place of Service summary is clicked successfully.");
			
			String drgDimensionSummaryTotalCost = pra.dimensionSummaryClick(pra.drgDimension,  pra.signPlusMinusDRG, pra.summaryDRG, pra.summaryTotalCostDRG);
			System.out.println(drgDimensionSummaryTotalCost);
			Reporter.log("DRG summary is clicked successfully.");
			
			String procedureDimensionSummaryTotalCost = pra.dimensionSummaryClick(pra.procedureDimension,  pra.signPlusMinusProcedure, pra.summaryProcedure, pra.summaryTotalCostProcedure);
			System.out.println(procedureDimensionSummaryTotalCost);
			Reporter.log("Procedure summary is clicked successfully.");
			
			String clinicDimensionSummaryTotalCost = pra.dimensionSummaryClick(pra.clinicDimension,  pra.signPlusMinusClinic, pra.summaryClinic, pra.summaryTotalCostClinic);
			System.out.println(clinicDimensionSummaryTotalCost);
			Reporter.log("Clinic summary is clicked successfully.");
			
			String zipcodeDimensionSummaryTotalCost = pra.dimensionSummaryClick(pra.zipcodeDimension,  pra.signPlusMinusZipcode, pra.summaryZipcode, pra.summaryTotalCostZipcode);
			System.out.println(zipcodeDimensionSummaryTotalCost);
			Reporter.log("Zipcode summary is clicked successfully.");
			
			String pcpAffiliationDimensionSummaryTotalCost = pra.dimensionSummaryClick(pra.pcpAffiliationDimension, pra.signPlusMinusAffiliation,  pra.summaryAffiliation, pra.summaryTotalCostAffiliation );
			System.out.println(pcpAffiliationDimensionSummaryTotalCost); 
			Reporter.log("PCP Affiliation summary is clicked successfully.");
			
			pra.dimensionSummaryClick(pra.medicationsDimension, pra.signPlusMinusMedications,  pra.summaryMedications);
			Reporter.log("Medications summary is clicked successfully.");
			
			List<String> allTotalCost = new ArrayList<String>();
			allTotalCost.add(chronicSummaryTotalCost); 
			allTotalCost.add(noOfChronicSummaryTotalCost);
			allTotalCost.add(pCpDimensionSummaryTotalCost); 
			allTotalCost.add(patientDimensionSummaryTotalCost);
			allTotalCost.add(physicianDimensionSummaryTotalCost); 
			allTotalCost.add(dateOfServiceDimensionSummaryTotalCost);
			allTotalCost.add(ageGroupDimensionSummaryTotalCost); 
			allTotalCost.add(payerDimensionSummaryTotalCost);
			allTotalCost.add(providerDimensionSummaryTotalCost); 
			allTotalCost.add(admissionTypeDimensionSummaryTotalCost);
			allTotalCost.add(claimsSpeDimensionSummaryTotalCost); 
			allTotalCost.add(claimsTypeDimensionSummaryTotalCost);
			allTotalCost.add(placeOfServiceDimensionSummaryTotalCost); 
			allTotalCost.add(drgDimensionSummaryTotalCost);
			allTotalCost.add(procedureDimensionSummaryTotalCost); 
			allTotalCost.add(clinicDimensionSummaryTotalCost);
			allTotalCost.add(zipcodeDimensionSummaryTotalCost); 
			allTotalCost.add(pcpAffiliationDimensionSummaryTotalCost);
			
			for(int i=1; i<allTotalCost.size(); i++){
				Assert.assertEquals(allTotalCost.get(0).contains(allTotalCost.get(i)), true, "Failed because total cost not equal");
			}
		}
		
	
	//Test Cases: 03
	@Test(priority=4, description="Take 1yr filter in DOS and verify that all dimensions open without any error.", enabled=true)
	public void oneYearDOSReportTest(){
		pra.yearReport(12);
	  	Reporter.log(pra.monthsToSelect + " months of " + pra.dateOfServiceDimension.getText() + " multi-select report generated.");
	  }
	
	
	//Test Cases: 04
	@Test(priority=5, description="Verify that user is able to export the Disparities report with 1 yr filter.", enabled=true)
	public void exportPatientDisparitiesReportTest(){
		pra.exportPatientDisparitiesReport(12);
	  	Reporter.log("Disparities report of Patient Dimension with " + pra.monthsToSelect + " months " + "filter exported to excel file.");
	}
	
	
	
	//Test Cases: 05
	@Test(priority=6, description="Verify that user is able to export the Care Recommendation report with 1 yr filter.", enabled=true)
	public void exportPatientCareRecommendationReportTest() {
		pra.exportPatientCareRecommendationReport(12);
	  	Reporter.log("Care Recommendation report of Patient Dimension with " + pra.monthsToSelect + " months " + "filter exported to excel file.");
	}
	
	
	
	//Test Cases: 06
	@Test(priority=7, description="Verify the Exclude MultiSelect functionality.", enabled=true)
	public void excludeMultiSelectTest(){
		pra.excludeMultiSelectClick();
		Reporter.log("Verified Execlude Multi select functionality successfully");
	}
	
	
	//Test Cases: 07
	@Test(priority=8, description="Verify that user is able to Search for patient information.", enabled=true)
	public void searchTest(){
		pra.searchClick();
		Reporter.log("Verified search functionality successfully");
	}
	
	
	
	//Test Cases: 08
	@Test(priority=9, description="Verify the MultiSelect functionality.", enabled=true)
	public void multiSelectTest(){
		pra.multiSelectClick();
		Reporter.log("Verified multi-select functionality successfully");
	}
	
	
		
	//Test Cases: 09
	@Test(priority=10, description="Verify the Analytics functionality.", enabled=true)
	public void analyticsClickTest(){
		pra.analyticsClick(2);
		Reporter.log("Verified analytics functionality successfully");
	}
	
	
	//Test Cases: 10 
	@Test(priority=11, description="Verify the reports functionality - Creating and view and access", enabled=true)
	public void saveViewLinkTest(){
		pra.saveViewLinkClick(12, "Test View Report 10");
		Reporter.log("Verified Save view and Report functionality successfully");
	}
		
	
	
	//Test Cases: 11 
	@Test(priority=12, description="Verify that user is able to open all charts.", enabled=true)
	public void openChartsTest(){
		pra.openChartsClick();
		Reporter.log("Verified all chart functionality successfully.");
	}
					
	
	//Test Cases: 12 
	@Test(priority=13, description="Verify the PMPM cost for 2015 - Q2 from DOS Dimension.", enabled=true)
	public void costPMPMTest(){
		pra.verifyCostPMPM();
		Reporter.log("Verified the PMPM cost for 2015 - Q2 from DOS Dimension successfully.");
	}
	
	
	//Test Cases: 13 
	@Test(priority=14, description="Verify the rate measures values (Hospital admission per 1000) for 2015 - Q2 from DOS Dimension.", enabled=true)
	public void RateMeasureValueTest(){
		pra.verifyRateMeasureValue();
		Reporter.log("Verified Rate measures value Hospital admission per 1000 successfully.");
	}
	
	
	@Test(priority=15, description="Verify the logout functionality.", enabled=true)
	public void verifyLogout(){
		vlp.logoutFromViterous();
		Reporter.log("Verified Logout functionality successfully.");
	}
	
	
	//Here TestResult class implements ITestReult interface (org.testng.internal.TestResult)
	@AfterMethod(enabled = true)
	public void captureScreenShot(ITestResult result) throws Exception {
		//System.out.println(result.getClass()); //The class who is implementing the interface is TestResult
		if(result.FAILURE==result.getStatus()){
			ScreenShot.failedScreenShot(result.getName(), "png", "yyyy_MMM_dd hh_mm_ss");
		}
		
	}
	
	
	@AfterTest(enabled=false)
	public void browserQuitTest() 
	{
		vlp.browserQuit();
		
	}
	
	
	
}
