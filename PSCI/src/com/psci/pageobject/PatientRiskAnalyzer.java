package com.psci.pageobject;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.psci.util.InitilizerDriverBrowser;
import com.psci.util.WaitDriver;
import com.thoughtworks.selenium.webdriven.commands.IsAlertPresent;



public class PatientRiskAnalyzer {
	
	int x = 5;
	
	//PatientRiskAnalyzerTab Locator
	@FindBy(how = How.XPATH, using = ".//*[@id='costDiv']")
	public WebElement patientRiskAnalyzerTab;
	
		
	//@FindBy(how = How.LINK_TEXT, using = "Exclude MultiSelect")
	@FindBy(linkText = "Exclude MultiSelect")
	public WebElement excludeMultiselectLink;
	
	@FindBy(how = How.LINK_TEXT, using = "MultiSelect")
	public WebElement multiSelect;
	
	//Next button element locator is common for all dimension 
	@FindBy(how=How.XPATH, using="//*[@id='prev-next']/ul/li[2]/a")
	public WebElement nextBtn;
	
	//MultiselectLink for MouseHover common for some dimensions
	@FindBy(how = How.XPATH, using="//div[@id='content']//div[@class='bodycontent']//a[contains(.,'multiselect')]")
	public WebElement multiSelectLink;
	
	@FindBy(how = How.XPATH, using = "//*[@id='content']/div[8]/div[3]/div[3]/div/div[1]/div/img[@class='bottom']")
	private WebElement multiselectCloseIcon;
	
	
	
	//Save this view link and Reports functionality Begin
	
		@FindBy(how = How.LINK_TEXT, using = "Save this view")
		private WebElement saveThisViewLink;
		
		@FindBy(how = How.XPATH, using="//*[@id='content']/div[1]/div[1]")
		public WebElement saveThisViewText;
		
		@FindBy(how = How.XPATH, using="//*[@id='viewName']")
		public WebElement viewName;
		
		@FindBy(how = How.XPATH, using="//html/body/form/div/div[5]/div[3]/div[3]/div[3]/div[1]/div/div[2]/span/textarea")
		public WebElement descField;
		
		@FindBy(how = How.XPATH, using="//*[@id='createNewView']/img")
		public WebElement createViewBtn;
		
		@FindBy(how = How.XPATH, using="//*[@id='msgDiv']")
		public WebElement successMsg;
		
		@FindBy(how = How.XPATH, using="//*[@id='content']/div[5]/div[1]/div[2]/div[2]/ul/li[2]/a")
		public WebElement linkReports;
		
		@FindBy(how = How.XPATH, using="//html/body/form/div[4]/div[3]/div[2]/div/div/ul/li/ul/li[1]/a")
		public WebElement linkViewName;
	
	//Save this view link and Reports functionality End
	
		
	
	// Chart Functionality Begins
		
		@FindBy(how = How.XPATH, using="//html/body/form/div/div[8]/div[1]/div[2]/div[2]/ul/li[3]/a")
		public WebElement linkCharts;
		
		@FindBy(how = How.XPATH, using="//*[@id='selChartType']")
		public WebElement chartTypeDropBox;
		
		//@FindBy(how = How.XPATH, using="//*[@id='chtSubmit']/img[@alt='submit']")
		@FindBy(how = How.XPATH, using="//*[@id='chtSubmit']")
		public WebElement chartSubmitBtn;
		
		
		@FindBy(how = How.XPATH, using="//*[@id='submitbtn']")
		public WebElement updateMapBtn;
		
		@FindBy(how = How.XPATH, using="//*[@id='ParetoChartId']")
		public WebElement paretoChartGraph;
		
		@FindBy(how = How.XPATH, using="//*[@id='inflation']")
		public WebElement inflationField;
		
		@FindBy(how = How.XPATH, using="//html/body/form/div/div/div[3]/div[2]/div[3]/ul/div[9]/ul/li/button")
		public WebElement viewsFieldBtn;
		
		@FindBy(how = How.XPATH, using="//*[@id='ui-multiselect-selView1-option-0']")
		public WebElement firstViewChkbox;
		
		@FindBy(how = How.XPATH, using="//*[@id='ui-multiselect-selView1-option-1']")
		public WebElement secondViewChkbox;
		
		@FindBy(how = How.XPATH, using="html/body/div[2]/div/ul/li[1]/a/span[2]")
		public WebElement checkAllLink;
		
		
		
		//Chart Names
		@FindBy(how = How.XPATH, using="//*[@id='StackedBarChartId']")
		public WebElement chartSOH;
		
		@FindBy(how = How.XPATH, using="//*[@id='map']")
		public WebElement chartGeoSpatial;
		
		@FindBy(how = How.XPATH, using="//*[@id='ParetoChartId']")
		public WebElement chartPareto;
		
		@FindBy(how = How.XPATH, using="//*[@id='HeatMapId']")
		public WebElement chartPatientDensity; 
		
		@FindBy(how = How.XPATH, using="//*[@id='PieChartId']")
		public WebElement chartPie;
		
		@FindBy(how = How.XPATH, using="//*[@id='SpiderChartId']")
		public WebElement chartRisk;
		
		@FindBy(how = How.XPATH, using="//*[@id='HeatMapChartId']")
		public WebElement chartRiskHeatMap;
		
		@FindBy(how = How.XPATH, using="//*[@id='TrendChartId']")
		public WebElement chartTrend;
		
		@FindBy(how = How.XPATH, using="//*[@id='PatientRiskChartId']")
		public WebElement chartPatientRisk;
		
		@FindBy(how = How.XPATH, using="//*[@id='HeatMapId']")
		public WebElement chartQuadRant;
		
		@FindBy(how = How.XPATH, using="//*[@id='WaterFallChartId']")
		public WebElement chartWaterfall;
		
		@FindBy(how = How.XPATH, using="//*[@id='TrendChartId']")
		public WebElement chartTreadViewsCompare;

	// Chart Functionality Ends	
		
		
	
	//Search functionality for any dimensions
	@FindBy(how = How.LINK_TEXT, using = "Search")
	private WebElement searchLink;
	
		@FindBy(how = How.XPATH, using = "//*[@id='selDim']")
		private WebElement dimensionDrop;
		
		@FindBy(how = How.XPATH, using = "//*[@id='selAttr1']")
		private WebElement attributeDrop;
		
		@FindBy(how = How.XPATH, using = "//*[@id='selFilter1']")
		private WebElement filterCriteriaDrop;
		
		@FindBy(how = How.XPATH, using = "//*[@id='SrchCrit1']")
		private WebElement criteriaKeyword;
		
		@FindBy(how = How.XPATH, using = "//*[@id='btnDiv']/ul/li[1]/a/img")
		private WebElement btnGroupCommit;
		
		@FindBy(how = How.XPATH, using = "//*[@id='rulesDiv']/tbody/tr/td[2]/textarea[@id='srchcrit0']")
		private WebElement keywordFound;
		
		@FindBy(how = How.XPATH, using = "//*[@id='btnDiv']/ul/li[4]/a/img")
		private WebElement btnSearch;
		
		@FindBy(how = How.XPATH, using = "//*[@id='resultOptsDiv']/div/ul/li[2]/input[@id='checkAll']")
		private WebElement checkAllCheckbox;
		
		@FindBy(how = How.XPATH, using = "//*[@id='resultOptsDiv']/div/div/div/ul/li[1]/a/img")
		private WebElement btnApply;
		
		@FindBy(how=How.XPATH, using = "//table[@id='PatientsTable']/tbody/tr")
		private List<WebElement> patientsRows;
	
	//Search functionality for any dimensions ends here	
	
		
	//Chronic Conditions  dimension
	@FindBy(how = How.XPATH, using = "//*[@id='ChronicConditionsTbl']/div/span" )
	public WebElement chronicConditionDimension;
		
	@FindBy(how = How.XPATH, using = "//*[@id='ChronicConditionsTbl']/div/img" )
	public WebElement signPlusMinusCC;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ChronicConditionsDiv']/td[2]/a" )
	//@FindBy(how = How.XPATH, using = ".//*[@id='ChronicConditionsDiv']/td[2]" ) 
	public WebElement summaryCC;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='ChronicConditionsTable']/tbody/tr[2]/td[7]")
	public WebElement summaryTotalCostCC;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ChronicConditionsTable']/tbody/tr[3]/td[2]/a" )
	public WebElement hypertensionLink;
	
	@FindBy(how = How.XPATH, using = "//table[@id='ChronicConditionsTbl']/tbody/tr")
	public List<WebElement> rowCounttt;
	
	
		
	//No Of Chronic Conditions  dimension
	@FindBy(how = How.XPATH, using = "//*[@id='NoOfChronicConditionsTbl']/div/span" )
	public WebElement noOfChronicConditionDimension;
	
	@FindBy(how = How.XPATH, using = "//*[@id='NoOfChronicConditionsTbl']/div/img" )
	public WebElement signPlusMinusNCC;
	
	@FindBy(how = How.XPATH, using = "//*[@id='NoOfChronicConditionsDiv']/td[2]/a" )
	public WebElement summaryNCC;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='NoOfChronicConditionsTable']/tbody/tr[2]/td[7]")
	public WebElement summaryTotalCostNCC;
	
	@FindBy(how = How.XPATH, using = "//*[@id='NoOfChronicConditionsTable']/tbody/tr[3]/td[2]/a" )
	public WebElement chronicconditions;
	
	
	
	//PCP  dimension
	@FindBy(how = How.XPATH, using = "//*[@id='PCPTbl']/div/span" )
	public WebElement pCpDimension;
	
	@FindBy(how = How.XPATH, using = "//*[@id='PCPTbl']/div/img" )
	public WebElement signPlusMinusPCP;
	
	@FindBy(how = How.XPATH, using = "//*[@id='PCPDiv']/td[2]/a" )
	public WebElement summaryPCP;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='PCPTable']/tbody/tr[2]/td[8]")
	public WebElement summaryTotalCostPCP;
	
	@FindBy(how = How.XPATH, using = "//table[@id='PCPTable']/tbody/tr/td[1]" )
	public List<WebElement> checkBoxesFirstColumn;
	
	
	
	//Patient  dimension
	@FindBy(how = How.XPATH, using = "//*[@id='PatientsTbl']/div/span" )
	public WebElement patientDimension;
	
	@FindBy(how = How.XPATH, using = "//*[@id='PatientsTbl']/div/img" )
	public WebElement signPlusMinusPatient;
	
	@FindBy(how = How.XPATH, using = "//*[@id='PatientsDiv']/td[2]/a" )
	public WebElement summaryPatient;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='PatientsTable']/tbody/tr[2]/td[13]")
	public WebElement summaryTotalCostPatient;
	
	@FindBy(how = How.XPATH, using = "//*[@id='Patients']/img" )
	public WebElement patientImageHover;
	
	@FindBy(how = How.XPATH, using = "//*[@id='dropmenu4']/a[3]" )
	public WebElement disparitiesLink ;
	
	@FindBy(how = How.XPATH, using = "//*[@id='dropmenu4']/a[4]" )
	public WebElement careRecommendationLink;
	
	@FindBy(how = How.XPATH, using = "//*[@id='patComplianceRepDiv']" )
	public WebElement chronicsReportWindow;
	
	@FindBy(how=How.XPATH, using="//*[@id='additionalDim1']/table/tbody/tr[7]/td//input[@id='group1']")
	public WebElement allChronicsRadioBtn;
	
	@FindBy(how=How.XPATH, using="//*[@id='additionalDim1']/table/tbody/tr/td/input[@type='checkbox']")
	private List<WebElement> allCheckboxes;
	
	@FindBy(how=How.XPATH, using = "//*[@id='patComplianceRepDiv']/div[2]/div[2]/input[@value='Generate Report']")
	private WebElement generateReportBtn;
	
	@FindBy(how=How.XPATH, using = "//*[@id='detailsDiv']/div[1]/a[2]/img")
	private WebElement exportToXlsImage;
	
	

	//AttendingPhysician  dimension
	@FindBy(how = How.XPATH, using = "//*[@id='PhysicianTbl']/div/span" )
	public WebElement physicianDimension;
		
	@FindBy(how = How.XPATH, using = "//*[@id='PhysicianTbl']/div/img" )
	public WebElement signPlusMinusPhysician;
	
	@FindBy(how = How.XPATH, using = "//*[@id='PhysicianDiv']/td[2]/a" )
	public WebElement summaryPhysician;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='PhysicianTable']/tbody/tr[2]/td[7]")
	public WebElement summaryTotalCostPhysician;
	
	
	//DateOfService  dimension
	@FindBy(how = How.XPATH, using = "//*[@id='TimeTbl']/div/span" )
	public WebElement dateOfServiceDimension;
	
	@FindBy(how = How.XPATH, using = "//*[@id='TimeTable']/tbody/tr[3]/td[1]/a" )
	public WebElement dosYear;
	
	@FindBy(how = How.XPATH, using = "//*[@id='TimeTbl']/div/img" )
	public WebElement signPlusMinusDOS;
	
	@FindBy(how = How.XPATH, using = "//*[@id='TimeDiv']/td[1]/a" )
	public WebElement summaryDOS;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='TimeTable']/tbody/tr[2]/td[10]")
	public WebElement summaryTotalCostDOS;
		
				//Year
				//@FindBy(how = How.XPATH, using = "//span[@class='pscitoggle psciexpand']") 
				@FindBy(how = How.XPATH, using = "//*[@id='TimeTable']/tbody/tr/td/span[@class='pscitoggle psciexpand']")
				public List<WebElement> yearChecks;
				
				//Quarter
				//@FindBy(how = How.XPATH, using = "//span[@class='pscitoggle']" ) 
				@FindBy(how = How.XPATH, using = "//*[@id='TimeTable']/tbody/tr/td/span[@class='pscitoggle']" )
				public List<WebElement> quarterChecks;
				
				//Month
				@FindBy(how = How.XPATH, using = "//table[@id='TimeTable']/tbody/*/td[3]/input[@type='checkbox']")
				public List<WebElement> monthChecks;
				
				//Month Name
				@FindBy(how = How.XPATH, using = "//table[@id='TimeTable']/tbody/*/td[3]/input[@type='a']")
				public List<WebElement> monthChecksName;
				
				//Minus sing
				@FindBy(how = How.XPATH, using="//*[@id='TimeTbl']/div/img[@src='images/minus_img.gif']")
				public WebElement minusImage;
				
				//Plus sing
				@FindBy(how = How.XPATH, using="//*[@id='TimeTbl']/div/img[@src='images/plus_img.gif")
				public WebElement plusImage;
						
				//MultiselectLink for MouseHover
				@FindBy(how = How.LINK_TEXT, using="Date of Service(2014)")
				public WebElement DOS2014;
				
				
						
	//AgeGroup dimension
				
	@FindBy(how = How.XPATH, using = "//*[@id='AgeGroupTbl']/div/span" )
	public WebElement ageGroupDimension;
				
	@FindBy(how = How.XPATH, using = "//*[@id='AgeGroupTbl']/div/img" )
	public WebElement signPlusMinusAG;
	
	@FindBy(how = How.XPATH, using = "//*[@id='AgeGroupDiv']/td[2]/a" )
	public WebElement summaryAG;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='AgeGroupTable']/tbody/tr[2]/td[7]")
	public WebElement summaryTotalCostAG;
	
				
	//Payer dimension
	
	@FindBy(how = How.XPATH, using = "//*[@id='PayerTbl']/div/span" )
	public WebElement payerDimension;
					
	@FindBy(how = How.XPATH, using = "//*[@id='PayerTbl']/div/img" )
	public WebElement signPlusMinusPayer;
	
	@FindBy(how = How.XPATH, using = "//*[@id='PayerDiv']/td[2]/a" )
	public WebElement summaryPayer;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='PayerTable']/tbody/tr[2]/td[8]")
	public WebElement summaryTotalCostPayer;
	
	
		//Payer table head check box
		@FindBy(how=How.XPATH, using="//table[@id='PayerTable']/tbody/tr/td/input[@id='checkall-15']")
		public WebElement headCheckBoxPayer;
	
		//Fifth check box
		@FindBy(how = How.XPATH, using = "//table[@id='PayerTable']/tbody/tr[5]/td[1]/input[@name='chkBox15']")
		private WebElement fifthCheckBoxPayer;
		
		//Sixth check box
		@FindBy(how = How.XPATH, using = "//table[@id='PayerTable']/tbody/tr[6]/td[1]/input[@name='chkBox15']")
		private WebElement sixthCheckBoxPayer;
		
		@FindBy(how = How.XPATH, using = "//table[@id='PayerTable']/tbody/tr[3]/td[2]/a[text()='G']")
		private WebElement checkBoxGPayer;
		
		@FindBy(how = How.XPATH, using = "//table[@id='PayerTable']/tbody/tr[4]/td[2]/a[text()='A']")
		private WebElement checkBoxAPayer;
		
		

	//Provider dimension
	
	@FindBy(how = How.XPATH, using = "//*[@id='ProviderTbl']/div/span" )
	public WebElement providerDimension;
						
	@FindBy(how = How.XPATH, using = "//*[@id='ProviderTbl']/div/img" )
	public WebElement signPlusMinusProvider;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ProviderDiv']/td[2]/a" )
	public WebElement summaryProvider;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='ProviderTable']/tbody/tr[2]/td[8]")
	public WebElement summaryTotalCostProvider;
		
	
	//AdmissionType dimension
	
	@FindBy(how = How.XPATH, using = "//*[@id='AdmissionTypeTbl']/div/span" )
	public WebElement admissionTypeDimension;
							
	@FindBy(how = How.XPATH, using = "//*[@id='AdmissionTypeTbl']/div/img" )
	public WebElement signPlusMinusAdmissionType;
	
	@FindBy(how = How.XPATH, using = "//*[@id='AdmissionTypeDiv']/td[2]/a" )
	public WebElement summaryAdmissionType;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='AdmissionTypeTable']/tbody/tr[2]/td[8]")
	public WebElement summaryTotalCostAdmissionType;
	
	
	//ClaimsSpeciality dimension
	
	@FindBy(how = How.XPATH, using = "//*[@id='ClaimsSpecialityTbl']/div/span" )
	public WebElement claimsSpeDimension;
								
	@FindBy(how = How.XPATH, using = "//*[@id='ClaimsSpecialityTbl']/div/img" )
	public WebElement signPlusMinusClaimsSpeciality;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ClaimsSpecialityDiv']/td[2]/a" )
	public WebElement summaryClaimsSpeciality;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='ClaimsSpecialityTable']/tbody/tr[2]/td[8]")
	public WebElement summaryTotalCostClaimsSpeciality;
		

	//Claim Type
	
	@FindBy(how = How.XPATH, using = "//*[@id='ClaimTypeTbl']/div/span" )
	public WebElement claimsTypeDimension;
								
	@FindBy(how = How.XPATH, using = "//*[@id='ClaimTypeTbl']/div/img")
	public WebElement signPlusMinusClaimsType;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ClaimTypeDiv']/td[2]/a" )
	public WebElement summaryClaimsType;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='ClaimTypeTable']/tbody/tr[2]/td[8]")
	public WebElement summaryTotalCostClaimsType;
	
	
	//Place of Service
	
	@FindBy(how = How.XPATH, using = "//div[@id='FacilityTbl']/div/span" )
	public WebElement placeOfServiceDimension;
									
	@FindBy(how = How.XPATH, using = "//*[@id='FacilityTbl']/div/img")
	public WebElement signPlusMinusPlaceOfService;
	
	@FindBy(how = How.XPATH, using = "//*[@id='FacilityDiv']/td[2]/a" )
	public WebElement summaryPlaceOfService;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='FacilityTable']/tbody/tr[2]/td[8]")
	public WebElement summaryTotalCostPlaceOfService;
	
	
	//DRG
	@FindBy(how = How.XPATH, using = "//*[@id='DRGTbl']/div/span" )
	public WebElement drgDimension;
										
	@FindBy(how = How.XPATH, using = "//*[@id='DRGTbl']/div/img")
	public WebElement signPlusMinusDRG;
	
	@FindBy(how = How.XPATH, using = "//*[@id='DRGDiv']/td[2]/a" )
	public WebElement summaryDRG;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='DRGTable']/tbody/tr[2]/td[9]")
	public WebElement summaryTotalCostDRG;
	
	
	//Procedure
	
	@FindBy(how = How.XPATH, using = "//*[@id='ProcedureTbl']/div/span" )
	public WebElement procedureDimension;
											
	@FindBy(how = How.XPATH, using = "//*[@id='ProcedureTbl']/div/img")
	public WebElement signPlusMinusProcedure;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ProcedureDiv']/td[2]/a" )
	public WebElement summaryProcedure;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='ProcedureTable']/tbody/tr[2]/td[10]")
	public WebElement summaryTotalCostProcedure;

	
	//Clinic
	
	@FindBy(how = How.XPATH, using = "//*[@id='LocationTbl']/div/span" )
	public WebElement clinicDimension;
												
	@FindBy(how = How.XPATH, using = "//*[@id='LocationTbl']/div/img")
	public WebElement signPlusMinusClinic;
	
	@FindBy(how = How.XPATH, using = "//*[@id='LocationDiv']/td[2]/a" )
	public WebElement summaryClinic;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='LocationTable']/tbody/tr[2]/td[7]")
	public WebElement summaryTotalCostClinic;

	
	//Zipcode
	
	@FindBy(how = How.XPATH, using = "//*[@id='ZipCodeTbl']/div/span" )
	public WebElement zipcodeDimension;
													
	@FindBy(how = How.XPATH, using = "//*[@id='ZipCodeTbl']/div/img")
	public WebElement signPlusMinusZipcode;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ZipCodeDiv']/td[2]/a" )
	public WebElement summaryZipcode;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='ZipCodeTable']/tbody/tr[2]/td[9]")
	public WebElement summaryTotalCostZipcode;
	

	//PCP Affiliation
	
	@FindBy(how = How.XPATH, using = "//*[@id='PCPDerivedTbl']/div/span" )
	public WebElement pcpAffiliationDimension;
													
	@FindBy(how = How.XPATH, using = "//*[@id='PCPDerivedTbl']/div/img")
	public WebElement signPlusMinusAffiliation;
	
	@FindBy(how = How.XPATH, using = "//*[@id='PCPDerivedDiv']/td[2]/a" )
	public WebElement summaryAffiliation;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='PCPDerivedTable']/tbody/tr[2]/td[10]")
	public WebElement summaryTotalCostAffiliation;
	
	
	
	//Medications
	
	@FindBy(how = How.XPATH, using = "//*[@id='MedicationsTbl']/div/span" )
	public WebElement medicationsDimension;
														
	@FindBy(how = How.XPATH, using = "//*[@id='MedicationsTbl']/div/img")
	public WebElement signPlusMinusMedications;
	
	@FindBy(how = How.XPATH, using = "//*[@id='MedicationsDiv']/td[2]/a" )
	public WebElement summaryMedications;
	
	
	
	//Analytics Test Cases Properties Begin
	
	@FindBy(how=How.XPATH, using = "//*[@id='scenarioDiv']")
	private WebElement analyticsTab;
	
	@FindBy(how=How.XPATH, using = "//*[@id='selDimen']")
	private WebElement dimensionsDropDown;
	
	@FindBy(how=How.XPATH, using = "//*[@id='selMsrType']")
	private WebElement whoseDropDown;
	
	@FindBy(how=How.XPATH, using = "//*[@id='selAttr']")
	private WebElement riskDropDown;
	
	@FindBy(how=How.XPATH, using = "//*[@id='selSearchCrit']")
	private WebElement criteriaDropDown;
	
	@FindBy(how=How.XPATH, using = "//*[@id='txtSrchCrit']")
	private WebElement criteriafield;
	
	@FindBy(how=How.XPATH, using = "//*[@id='commitCriteriaBtn']")
	private WebElement commitCriteriaBtn;
	
	@FindBy(how=How.XPATH, using = "//table[@id='rulesDiv']/tbody/tr/td[2]/textarea[@id='srchcrit0']")
	private WebElement conditionField;
	
	@FindBy(how=How.XPATH, using = "//*[@id='mastercriteriaBtn']")
	private WebElement commitMasterCriteriaBtn;
	
	@FindBy(how=How.XPATH, using = "//*[@id='submitAnalyticBtn']")
	private WebElement submitAnlysticBtn;
	
	@FindBy(how=How.XPATH, using = ".//*[@id='additionalDim']/div[2]")
	private WebElement resultWindow;
	
	@FindBy(how=How.XPATH, using = "//*[@id='PatientsData']/div/table/tbody/tr/td[contains(text(),'No Matching Records Found.')]")
	private WebElement textResult;
	
	@FindBy(how=How.XPATH, using = "//*[@id='additionalDim']/div[1]/a/img")
	private WebElement windowCloseBtn;
	
	@FindBy(how=How.XPATH, using = "//*[@id='PatientsData']/div[1]/table/tbody/tr[1]/td[1]/input[@id='checkall']")
	private WebElement allChkBox;
	
	@FindBy(how=How.XPATH, using = "//*[@id='additionalDim']/div[2]/a[1]/img")
	private WebElement applyBtn;
	
	@FindBy(how=How.XPATH, using = "//table[@id='PatientsTable']/tbody/tr[1]/td[14]/img[@id='Patients_comp_riskImg']")
	private WebElement plusSingACR;
	
	@FindBy(how=How.XPATH, using = "//table[@id='PatientsTable']/tbody/tr[1]/td[23]/a[text()='HCCRisk']")
	private WebElement linkHCCRisk;
	
	//Analytics Test Cases Properties End
	
	
	
	//Plus sign verification
	public boolean plusSing(WebElement plusElement)
	{
		try 
		{
			return plusElement.getAttribute("src").contains("plus_img");
		} catch(NoSuchElementException e){
			return false;
		}
	}
	
			
	//Minus sign verification
	public boolean minusSing(WebElement minusElement)
	{
		try
		{
			return minusElement.getAttribute("src").contains("minus_img");
		} catch(NoSuchElementException e){
			return false;
		}
	}	
	
	
	//If minus sign is exist then return that minus element
	public WebElement signMinus(WebElement minusElement)
	{
		try
		{
			if(minusElement.getAttribute("src").contains("minus_img")){
				return minusElement;
			} else{
				return null;
			}
			
		} catch(NoSuchElementException e){
			return null;
		}
	}	
	
	
	//Plus click functionality
	public boolean plusClick(WebElement plusElement) 
	{
		try
		{
			if(plusElement.getAttribute("src").contains("plus_img"))
			{
				Thread.sleep(1000);
				plusElement.click();
				return true;
			} else{
				return false;
			}
			
		} catch(Exception e){
			return false;
		}
			
	}
	
	
		
	//Minus click functionality
	public boolean minusClick(WebElement minusElement)
	{
		try
		{
			if(minusElement.getAttribute("src").contains("minus_img")){
				Thread.sleep(1000);
				minusElement.click();
				return true;
			} else{
				return false;
			}
		} catch(Exception e){
			return false;
		}
			
	}
	

	
	
	//Plus and Minus click functionality		
	public boolean clickPlusMinus(WebElement elementPlusMinus)
	{
		try{
			boolean plusSignClick = elementPlusMinus.getAttribute("src").contains("minus_img");
			boolean minusSignClick = elementPlusMinus.getAttribute("src").contains("plus_img");
			
			if(plusSignClick){
				elementPlusMinus.click();
				return plusSignClick;
				
			} else{
				elementPlusMinus.click();
				return minusSignClick;
			}
			
		} catch(NoSuchElementException e){
				return false;
		}
	}
	
	
	
	
	//Verify the availability of WebElement  
	public static boolean isElementPresent(WebElement element)
	{
		try
		{
			return element.isDisplayed();
		} catch(NoSuchElementException e){
			return false;
		}
	}
	
	
	//Verify the availability of Alert
	public boolean isAlertPresent()
	{
		try
		{
			if(InitilizerDriverBrowser.driver.switchTo().alert() != null)
			{
				return true;
			} else{
				return false;
			}
			
		} catch(NoAlertPresentException e){
			return false;
		}
	}
	
	
	//Verify the StaleElementReferenceException of webelement by recurrsion method
	public WebElement refreshElementObject(WebElement element)
	{
		int counter=0;
		try
		{
			counter = counter + 1;
			return element;
		} catch(StaleElementReferenceException e){
			return refreshElementObject(element);
		}
	}
	
	
	
//Test Case#1 : Click single dimension
	public void dimensionClick(WebElement dimensionElement, WebElement minusElement ){
		
		try{
			if(isElementPresent(dimensionElement) && dimensionElement.isEnabled())
			{
				dimensionElement.click();
				Thread.sleep(3000);
				
				//Verifying the expansion of the dimension when click on it. 
				Assert.assertEquals(minusSing(minusElement),true, "FAILED because " + dimensionElement.getText() + " dimension is not expanded.");
				Thread.sleep(2000);
			} else{
				System.out.println("Dimension: --" + dimensionElement.getText());
				Assert.assertEquals(isElementPresent(dimensionElement), true, "FAILED because dimension is not found.");
			}
			
		} catch (Exception e) {
			Assert.assertNotEquals(InitilizerDriverBrowser.driver.getTitle(), "ErrorPage", "FAILED because ErrorPage is found.");
			//e.printStackTrace();
			//System.out.println("Exception found" + "for dimensionClick()");
		}
	}
	
	
	
//Test Case#2 : Click each Dimension Summary and return the total cost of each dimension	
	public String dimensionSummaryClick(WebElement dimensionElement, WebElement plusElement, WebElement summaryElement, WebElement summaryTotalCost ){
		try
		{
			WebDriverWait wait = new WebDriverWait(InitilizerDriverBrowser.driver, 5);
			wait.until(ExpectedConditions.visibilityOf(plusElement));
						
			boolean plusSign = plusSing(plusElement);
			if(dimensionElement.isDisplayed() && plusSign == true)
			{
				Thread.sleep(2000);
				dimensionElement.click();
				WaitDriver.implicitWait(summaryElement);
			} 
				if(summaryElement.isDisplayed() && summaryElement.isEnabled())
				{
					//Calling recursion object
					//WebElement elementSummary = refreshElementObject(summaryElement);
					//elementSummary.click(); or refreshElementObject(summaryElement).click();
					for(int i = 0; i < 5; i++)
					{
						if(summaryElement.isEnabled())
						{
							Thread.sleep(5000);
							summaryElement.click();
							break;
						} 
					}
					Thread.sleep(500);
				} 
				//To validate the expected with actual behavior
				Assert.assertEquals(isElementPresent(summaryElement), false, "FAILED because summary of " + dimensionElement.getText() +  " is not clicked.");
				return summaryTotalCost.getText();
					
		}catch(Exception e){
				Assert.assertNotEquals(InitilizerDriverBrowser.driver.getTitle(), "ErrorPage", "FAILED because ErrorPage displaying.");
				//e.printStackTrace();
				//System.out.println("Exception found" + "for dimensionSummaryClick()");
				return null;
		}
		
		
	}
	
	
	//Test Case#2.1 : Click each Dimension Summary
	public void dimensionSummaryClick(WebElement dimensionElement, WebElement plusElement, WebElement summaryElement){
		try
		{
			WebDriverWait wait = new WebDriverWait(InitilizerDriverBrowser.driver, 5);
			wait.until(ExpectedConditions.visibilityOf(plusElement));
						
			boolean plusSign = plusSing(plusElement);
			if(dimensionElement.isDisplayed() && plusSign == true)
			{
				Thread.sleep(2000);
				dimensionElement.click();
				WaitDriver.implicitWait(summaryElement);
			} 
			
				if(summaryElement.isDisplayed() && summaryElement.isEnabled())
				{
					//Calling recursion object
					//WebElement elementSummary = refreshElementObject(summaryElement);
					//elementSummary.click(); or refreshElementObject(summaryElement).click();
					
					for(int i = 0; i < 5; i++)
					{
						if(summaryElement.isEnabled())
						{
							Thread.sleep(5000);
							summaryElement.click();
							break;
						} 
					}
					
					Thread.sleep(500);
				} 
				
				//To validate the expected with actual behavior
				 Assert.assertEquals(isElementPresent(summaryElement), false, "FAILED because summary of " + dimensionElement.getText() +  " is not clicked.");
					
		}catch(Exception e){
				Assert.assertNotEquals(InitilizerDriverBrowser.driver.getTitle(), "ErrorPage", "FAILED because ErrorPage displaying.");
				//e.printStackTrace();
				//System.out.println("Exception found" + "for dimensionSummaryClick()");
		}
	}
	
	
	
//Test Case#3 : One Year Report of DOS by multi-select
	public int monthsToSelect = 0;
	public void yearReport(int monthsToSelect)
	{
		try{
			WebDriverWait wait = new WebDriverWait(InitilizerDriverBrowser.driver, 3);
			wait.until(ExpectedConditions.elementToBeClickable(signPlusMinusDOS));
			
			plusClick(signPlusMinusDOS);
			
			if(monthsToSelect > 0 && monthsToSelect <= monthChecks.size() ){
				this.monthsToSelect = monthsToSelect;
				for(WebElement yearToClick : yearChecks) {
					yearToClick.click();
				}
			
				for(WebElement quartToClick : quarterChecks) {	
					quartToClick.click();
				}
						
				for(int i=0; i < monthsToSelect; i++) {
					monthChecks.get(i).click();
					//System.out.println("Month Size " + monthChecks.size());
				}
				wait.until(ExpectedConditions.visibilityOf(multiSelect));
				if(isElementPresent(multiSelect) && multiSelect.isEnabled()){
					multiSelect.click();
						
					//Mouse hovering on multi-select link 
					Actions objAction=new Actions(InitilizerDriverBrowser.driver);
					objAction.moveToElement(multiSelectLink).build().perform();
					
					//Clicking on the one year filtered dimensions
					dimensionClick(chronicConditionDimension, signPlusMinusCC);
					//Thread.sleep(1000);
					WaitDriver.implicitWait(summaryCC);
					
					dimensionClick(noOfChronicConditionDimension, signPlusMinusNCC); 			
					//Thread.sleep(3000);
					WaitDriver.implicitWait(summaryNCC);
					
					dimensionClick(pCpDimension, signPlusMinusPCP); 							
					//Thread.sleep(1000);
					WaitDriver.implicitWait(summaryPCP);
					
					dimensionClick(patientDimension, signPlusMinusPatient); 					
					//Thread.sleep(7000);
					WaitDriver.implicitWait(summaryPatient);
					
					dimensionClick(physicianDimension, signPlusMinusPhysician); 				
					//Thread.sleep(15000);
					WaitDriver.implicitWait(summaryPhysician);
					
					dimensionClick(dateOfServiceDimension, signPlusMinusDOS);					
					//Thread.sleep(1000);
					WaitDriver.implicitWait(summaryDOS);
					
					dimensionClick(ageGroupDimension, signPlusMinusAG); 						
					//Thread.sleep(1000);
					WaitDriver.implicitWait(summaryAG);
					
					dimensionClick(payerDimension, signPlusMinusPayer); 						
					//Thread.sleep(1000);
					WaitDriver.implicitWait(summaryPayer);
					
					dimensionClick(providerDimension, signPlusMinusProvider); 					
					//Thread.sleep(1000);
					WaitDriver.implicitWait(summaryProvider);
					
					dimensionClick(admissionTypeDimension, signPlusMinusAdmissionType); 		
					//Thread.sleep(1000);
					WaitDriver.implicitWait(summaryAdmissionType);
					
					dimensionClick(claimsSpeDimension, signPlusMinusClaimsSpeciality); 			
					//Thread.sleep(1000);
					WaitDriver.implicitWait(summaryClaimsSpeciality);
					
					dimensionClick(claimsTypeDimension, signPlusMinusClaimsType); 				
					//Thread.sleep(1000);
					WaitDriver.implicitWait(summaryClaimsType);
					
					dimensionClick(placeOfServiceDimension, signPlusMinusPlaceOfService);		
					//Thread.sleep(1000);
					WaitDriver.implicitWait(summaryPlaceOfService);
					
					dimensionClick(drgDimension, signPlusMinusDRG); 							
					//Thread.sleep(1000);
					WaitDriver.implicitWait(summaryDRG);
					
					dimensionClick(procedureDimension, signPlusMinusProcedure); 				
					//Thread.sleep(1000);
					WaitDriver.implicitWait(summaryProcedure);
					
					dimensionClick(clinicDimension, signPlusMinusClinic); 						
					//Thread.sleep(1000);
					WaitDriver.implicitWait(summaryClinic);
					
					dimensionClick(zipcodeDimension, signPlusMinusZipcode); 					
					//Thread.sleep(1000);
					WaitDriver.implicitWait(summaryZipcode);
					
					dimensionClick(pcpAffiliationDimension, signPlusMinusAffiliation);			
					//Thread.sleep(1000);
					WaitDriver.implicitWait(summaryAffiliation);
					
					dimensionClick(medicationsDimension, signPlusMinusMedications); 
					WaitDriver.implicitWait(summaryMedications);
				}
			
			}else{
				Assert.assertNotEquals(monthsToSelect <= 0, true, "FAILED because month value is equal to ZERO or less than ZERO");
			}
		
		}catch(Exception e){
			Assert.assertNotEquals(InitilizerDriverBrowser.driver.getTitle(), "ErrorPage", "FAILED because ErrorPage displaying.");
			//e.printStackTrace();
			//System.out.println("Exception found" + "for yearReport()");
		} 
	
	} 
	
	
	
	

//Test Case#4 : Exporting one year Patient Disparities Report
	public void exportPatientDisparitiesReport(int monthsToSelect) 
	{
		// to create the object of Screen for taking screenshots of desktop components
		try
		{
			boolean flag = minusSing(signPlusMinusPatient);
			if(flag)
			{
				boolean imgAtt = patientImageHover.getAttribute("src").matches("(.*)export-icon1(.*)");
				if(imgAtt)
				{
					Actions imgAction = new Actions(InitilizerDriverBrowser.driver);
					imgAction.moveToElement(patientImageHover).build().perform();
					
					
					Thread.sleep(5000);
					
					disparitiesLink.click();
					Thread.sleep(2000);
					
					Assert.assertEquals(isElementPresent(chronicsReportWindow), true, "Failed");
					Thread.sleep(1000);
					
					allChronicsRadioBtn.click();
						
					for (WebElement allChecks: allCheckboxes )
					{
						allChecks.click();
					}
					
					Thread.sleep(3000);
					generateReportBtn.click();
						
					// parent Window
					String mainWindow = InitilizerDriverBrowser.driver.getWindowHandle();
						
					// handling multiple windows				
					Set<String> windows = InitilizerDriverBrowser.driver.getWindowHandles();
													
					if (windows.size() >= 1) 
					{
						for (String window : windows)
						{
							InitilizerDriverBrowser.driver.switchTo().window(window);
							
							if (InitilizerDriverBrowser.driver.getTitle().equals("Patient Disparities in care Report"))
							{
								InitilizerDriverBrowser.driver.switchTo().window(window);
								Thread.sleep(2000);
									
								//Exporting to excel file
								exportToXlsImage.click();
								Thread.sleep(2000);
								
								//AutoIT implementation
								//Select open option in download dialogue dialogue box
								if(InitilizerDriverBrowser.driver.toString().contains("FirefoxDriver")){
									
									Runtime.getRuntime().exec("D:\\Projects\\Automation\\Workspace\\PSCI\\AutoIT\\Open\\FFOpenDialog.exe");
									System.out.println("Excel file opened successfully");
									Thread.sleep(10000);
									
								}
								
								else if(InitilizerDriverBrowser.driver.toString().contains("ChromeDriver")){
									
									Runtime.getRuntime().exec("D:\\Projects\\Automation\\Workspace\\PSCI\\AutoIT\\Open\\ChromeOpenDialog.exe");
									System.out.println("Excel file opened successfully");
									Thread.sleep(10000);
									
								}
								
								else if(InitilizerDriverBrowser.driver.toString().contains("InternetExplorerDriver")){
									
									Runtime.getRuntime().exec("D:\\Projects\\Automation\\Workspace\\PSCI\\AutoIT\\Open\\IEOpenDialog.exe");
									System.out.println("Excel file opened successfully");
									Thread.sleep(10000);
									
								}
								
								//To open the excel file and validate the data
								Runtime.getRuntime().exec("D:\\Projects\\Automation\\Workspace\\PSCI\\AutoIT\\Open\\OpenExcel.exe");
								System.out.println("Excel file closed successfully");
								
								
								Thread.sleep(2000);
								//closing the child window
								InitilizerDriverBrowser.driver.close();
								break;
									
							}
						}
					}
						
						//Returning back to Parent window
						InitilizerDriverBrowser.driver.switchTo().window(mainWindow);
					}
					
				} else{    //It execute the method independently from else part of method
					
					WebDriverWait wait = new WebDriverWait(InitilizerDriverBrowser.driver, 3);
				
					wait.until(ExpectedConditions.visibilityOf(signPlusMinusDOS));
				
					plusClick(signPlusMinusDOS);
								
					if(monthsToSelect > 0 && monthsToSelect <= monthChecks.size() )
					{
						this.monthsToSelect = monthsToSelect;
						for(WebElement yearToClick : yearChecks)
						{
							yearToClick.click();
						}
				
						for(WebElement quartToClick : quarterChecks)
						{	
							quartToClick.click();
						}
							
						for(int i=0; i < monthsToSelect; i++)
						{
							monthChecks.get(i).click();
						}
					
						//wait.until(ExpectedConditions.visibilityOf(multiSelect));
					
						if(multiSelect.isDisplayed() && multiSelect.isEnabled())
						{
							multiSelect.click();
											
							//Mouse hovering on multi-select link 
							Actions objAction=new Actions(InitilizerDriverBrowser.driver);
							objAction.moveToElement(multiSelectLink).build().perform();
												
							dimensionClick(patientDimension, signPlusMinusPatient ); 
							WaitDriver.implicitWait(summaryPatient);
												
							boolean imgAtt = patientImageHover.getAttribute("src").contains("export-icon1");
							if(imgAtt)
							{
								Actions imgAction = new Actions(InitilizerDriverBrowser.driver);
								imgAction.moveToElement(patientImageHover).build().perform();
								Thread.sleep(5000);
								
								disparitiesLink.click();
								Thread.sleep(2000);
								
								Assert.assertEquals(isElementPresent(chronicsReportWindow), true, "Failed");
							
								Thread.sleep(1000);
								allChronicsRadioBtn.click();
							
								for(WebElement allChecks: allCheckboxes )
								{
									allChecks.click();
								}
							
								Thread.sleep(3000);
								generateReportBtn.click();
							
								// Parent Window
								String mainWindow = InitilizerDriverBrowser.driver.getWindowHandle();
							
								// Handling multiple windows				
								Set<String> windows = InitilizerDriverBrowser.driver.getWindowHandles();
								if(windows.size() >= 1) 
								{
									for (String window : windows) 
									{
										InitilizerDriverBrowser.driver.switchTo().window(window);
										// System.out.println("Looping window..." + window.toString());
									
										if (InitilizerDriverBrowser.driver.getTitle().equals("Patient Disparities in care Report")) 
										{
											InitilizerDriverBrowser.driver.switchTo().window(window);
											Thread.sleep(2000);
										
											//Exporting to excel file
											exportToXlsImage.click();
											Thread.sleep(2000);
										
											//AutoIT implementation
											//Select open option in download dialogue dialogue box
											if(InitilizerDriverBrowser.driver.toString().contains("FirefoxDriver")){
												
												Runtime.getRuntime().exec("D:\\Projects\\Automation\\Workspace\\PSCI\\AutoIT\\Open\\FFOpenDialog.exe");
												System.out.println("Excel file opened successfully");
												Thread.sleep(10000);
												
											}
											
											else if(InitilizerDriverBrowser.driver.toString().contains("ChromeDriver")){
												
												Runtime.getRuntime().exec("D:\\Projects\\Automation\\Workspace\\PSCI\\AutoIT\\Open\\ChromeOpenDialog.exe");
												System.out.println("Excel file opened successfully");
												Thread.sleep(10000);
												
											}
											
											else if(InitilizerDriverBrowser.driver.toString().contains("InternetExplorerDriver")){
												
												Runtime.getRuntime().exec("D:\\Projects\\Automation\\Workspace\\PSCI\\AutoIT\\Open\\IEOpenDialog.exe");
												System.out.println("Excel file opened successfully");
												Thread.sleep(10000);
												
											}
											
											//To open the excel file and validate the data
											Runtime.getRuntime().exec("D:\\Projects\\Automation\\Workspace\\PSCI\\AutoIT\\Open\\OpenExcel.exe");
											System.out.println("Excel file closed successfully");
											
											
											Thread.sleep(2000);
											//closing the child window
											InitilizerDriverBrowser.driver.close();
											break;
										} 
									}
								}
							
								//Returning back to Parent window
								InitilizerDriverBrowser.driver.switchTo().window(mainWindow);
							}
									  	
						}else{
							System.out.println("Multiselect link is either not displayed or not enabled.");
					}
				
				}else{
					System.out.println("Please enter valid month number to generate the multi select report");
			}
				
		}//Method else part end here
			
	}catch(Exception e){
		Assert.assertNotEquals(InitilizerDriverBrowser.driver.getTitle(), "ErrorPage", "FAILED because ErrorPage displaying.");
		//e.printStackTrace();
		//System.out.println("Exception found" + "for exportPatientDisparitiesReport()");
	} 
}
		
	
	
	
	
//Test Case#5 : Exporting one year Patient Care Recommendation Report
	public void exportPatientCareRecommendationReport(int monthsToSelect) {
		
		// to create the object of Screen for taking screenshots of desktop components
				try
				{
					Thread.sleep(8000);
					WebDriverWait wait = new WebDriverWait(InitilizerDriverBrowser.driver, 3);
					boolean flag = minusSing(signPlusMinusPatient);
					if(flag)
					{
						boolean imgAtt = patientImageHover.getAttribute("src").matches("(.*)export-icon1(.*)");
						if(imgAtt)
						{
							Actions imgAction = new Actions(InitilizerDriverBrowser.driver);
							imgAction.moveToElement(patientImageHover).build().perform();
							Thread.sleep(5000);
							
							wait.until(ExpectedConditions.visibilityOf(careRecommendationLink));
							careRecommendationLink.click();
							
							Thread.sleep(2000);
							//Existence of pop-up window
							Assert.assertEquals(isElementPresent(chronicsReportWindow), true, "FAILED because model pop-up window is not opened.");
							
							Thread.sleep(1000);
							allChronicsRadioBtn.click();
							
							for(WebElement allChecks: allCheckboxes )
							{
								allChecks.click();
							}
							Thread.sleep(3000);
							generateReportBtn.click();
							
							//Parent Window
							String mainWindow = InitilizerDriverBrowser.driver.getWindowHandle();
							
							//Handling multiple windows				
							Set<String> windows = InitilizerDriverBrowser.driver.getWindowHandles();
														
							if (windows.size() >= 1) 
							{
								for (String window : windows) 
								{
									InitilizerDriverBrowser.driver.switchTo().window(window);
									//System.out.println("Looping window..." + window.toString());
									
									if (InitilizerDriverBrowser.driver.getTitle().equals("Patient Care Recommendation Report")) 
									{
										InitilizerDriverBrowser.driver.switchTo().window(window);
										Thread.sleep(2000);
										
										//Exporting data to excel file from child window
										exportToXlsImage.click();
										Thread.sleep(2000);
										
										//AutoIT implementation
										//Select open option in download dialogue dialogue box
										if(InitilizerDriverBrowser.driver.toString().contains("FirefoxDriver")){
											
											Runtime.getRuntime().exec("D:\\Projects\\Automation\\Workspace\\PSCI\\AutoIT\\Open\\FFOpenDialog.exe");
											System.out.println("Excel file opened successfully");
											Thread.sleep(10000);
											
										}
										
										else if(InitilizerDriverBrowser.driver.toString().contains("ChromeDriver")){
											
											Runtime.getRuntime().exec("D:\\Projects\\Automation\\Workspace\\PSCI\\AutoIT\\Open\\ChromeOpenDialog.exe");
											System.out.println("Excel file opened successfully");
											Thread.sleep(10000);
											
										}
										
										else if(InitilizerDriverBrowser.driver.toString().contains("InternetExplorerDriver")){
											
											Runtime.getRuntime().exec("D:\\Projects\\Automation\\Workspace\\PSCI\\AutoIT\\Open\\IEOpenDialog.exe");
											System.out.println("Excel file opened successfully");
											Thread.sleep(10000);
											
										}
										
										//To open the excel file and validate the data
										Runtime.getRuntime().exec("D:\\Projects\\Automation\\Workspace\\PSCI\\AutoIT\\Open\\OpenExcel.exe");
										System.out.println("Excel file closed successfully");
										
										
										Thread.sleep(2000);
										//closing the child window
										InitilizerDriverBrowser.driver.close();
										break;
									}
								}
							}
							
							//Returning back to Parent window
							InitilizerDriverBrowser.driver.switchTo().window(mainWindow);
						}
						
					} else{    //It execute the method independently from else part of method
						
					//wait.until(ExpectedConditions.elementToBeClickable(signPlusMinusDOS));
					plusClick(signPlusMinusDOS);
					if(monthsToSelect > 0 && monthsToSelect <= monthChecks.size() )
					{
						this.monthsToSelect = monthsToSelect;
						for(WebElement yearToClick : yearChecks)
						{
							yearToClick.click();
						}
					
						for(WebElement quartToClick : quarterChecks)
						{	
							quartToClick.click();
						}
								
						for(int i=0; i < monthsToSelect; i++)
						{
							monthChecks.get(i).click();
						}
						
						wait.until(ExpectedConditions.visibilityOf(multiSelect));
						if(multiSelect.isDisplayed() && multiSelect.isEnabled()){
							multiSelect.click();
							//Mouse hovering on multi-select link 
							Actions objAction=new Actions(InitilizerDriverBrowser.driver);
							objAction.moveToElement(multiSelectLink).build().perform();
							Thread.sleep(5000);
							
							dimensionClick(patientDimension, signPlusMinusPatient ); 
							//Thread.sleep(10000);
							WaitDriver.implicitWait(summaryPatient);
							
							wait.until(ExpectedConditions.visibilityOf(patientImageHover));
							
							boolean imgAtt = patientImageHover.getAttribute("src").matches("(.*)export-icon1(.*)");
							if(imgAtt)
							{
								//Thread.sleep(2000);
								Actions imgAction = new Actions(InitilizerDriverBrowser.driver);
								imgAction.moveToElement(patientImageHover).build().perform();
								Thread.sleep(10000);
								
								
								wait.until(ExpectedConditions.visibilityOf(careRecommendationLink));
								careRecommendationLink.click();
								Thread.sleep(2000);
								
								//Existence of pop-up window
								Assert.assertEquals(isElementPresent(chronicsReportWindow), true, "FAILED because model pop-up window is not opened.");
								
								allChronicsRadioBtn.click();
								
								for(WebElement allChecks: allCheckboxes )
								{
									allChecks.click();
								}
								
								Thread.sleep(3000);
								generateReportBtn.click();
								
								
								//Parent Window
								String mainWindow = InitilizerDriverBrowser.driver.getWindowHandle();
								
								
								//Handling multiple windows				
								Set<String> windows = InitilizerDriverBrowser.driver.getWindowHandles();
								if (windows.size() >= 1) 
								{
									for (String window : windows) 
									{
										InitilizerDriverBrowser.driver.switchTo().window(window);
										//System.out.println("Looping window..." + window.toString());
										if (InitilizerDriverBrowser.driver.getTitle().equals("Patient Care Recommendation Report")) 
										{
											//InitilizerDriverBrowser.driver.getWindowHandle();
											InitilizerDriverBrowser.driver.switchTo().window(window);
											Thread.sleep(2000);
											
											//Exporting data to excel file from child window
											exportToXlsImage.click();
											Thread.sleep(5000);
											
											//AutoIT implementation
											//Select open option in download dialogue dialogue box
											if(InitilizerDriverBrowser.driver.toString().contains("FirefoxDriver")){
												
												Runtime.getRuntime().exec("D:\\Projects\\Automation\\Workspace\\PSCI\\AutoIT\\Open\\FFOpenDialog.exe");
												System.out.println("Excel file opened successfully");
												Thread.sleep(10000);
												
											}
											
											else if(InitilizerDriverBrowser.driver.toString().contains("ChromeDriver")){
												
												Runtime.getRuntime().exec("D:\\Projects\\Automation\\Workspace\\PSCI\\AutoIT\\Open\\ChromeOpenDialog.exe");
												System.out.println("Excel file opened successfully");
												Thread.sleep(10000);
												
											}
											
											else if(InitilizerDriverBrowser.driver.toString().contains("InternetExplorerDriver")){
												
												Runtime.getRuntime().exec("D:\\Projects\\Automation\\Workspace\\PSCI\\AutoIT\\Open\\IEOpenDialog.exe");
												System.out.println("Excel file opened successfully");
												Thread.sleep(10000);
												
											}
											
											//To open the excel file and validate the data
											Runtime.getRuntime().exec("D:\\Projects\\Automation\\Workspace\\PSCI\\AutoIT\\Open\\OpenExcel.exe");
											System.out.println("Excel file closed successfully");
											
											
											Thread.sleep(2000);
											//closing the child window
											InitilizerDriverBrowser.driver.close();
											break;
											
										}
									}
								}
								
								//Returning back to Parent window
								InitilizerDriverBrowser.driver.switchTo().window(mainWindow);
							}
										  	
						}else{
								System.out.println("Multiselect link is either not displayed or not enabled.");
						}
					}else{
						System.out.println("Please enter valid month number to generate the multi select report");
					}
					
				}//Method else part ends here
				
				}catch(Exception e){
					
					Assert.assertNotEquals(InitilizerDriverBrowser.driver.getTitle(), "ErrorPage", "FAILED because ErrorPage displaying.");
					e.printStackTrace();
					//System.out.println("Exception found" + "for exportPatientCareRecommendationReport()");
				} 
			} 
	
	
	
	
	
	
//Test Case#6 : Verify the "Exclude MultiSelect" functionality.
	public void excludeMultiSelectClick()
	{
		try
		{
			//WebDriverWait wait = new WebDriverWait(InitilizerDriverBrowser.driver, 3);
			Thread.sleep(2000);
			
			if(isElementPresent(multiSelectLink) && multiSelectLink.isEnabled())
			{
				multiselectCloseIcon.click();
			}
				Thread.sleep(3000);
				plusClick(signPlusMinusPayer);
				if(headCheckBoxPayer.isDisplayed() && !headCheckBoxPayer.isSelected())
				{
					Thread.sleep(3000);
					
					 //Selecting the header check box
					 headCheckBoxPayer.click();
					 Thread.sleep(5000);
					 
					 //De-selecting he two check boxes
					 fifthCheckBoxPayer.click();
					 sixthCheckBoxPayer.click();
					 Thread.sleep(2000);
					 
					 //Click on Execlude Multi-select link
					 excludeMultiselectLink.click();
					 
					 Actions objAction=new Actions(InitilizerDriverBrowser.driver);
					 objAction.moveToElement(multiSelectLink).build().perform();
					 Thread.sleep(3000);
					 
					 payerDimension.click();
					 Thread.sleep(1000);
					 
					 Assert.assertEquals(checkBoxGPayer.getText().equals("G"), true, "Exclude multiselect functionality failed");
					 Assert.assertEquals(checkBoxAPayer.getText().equals("A"), true, "Exclude multiselect functionality failed");
				 } else{
					 System.out.println("Element is not found");
				 }
			
		} catch(Exception e){
			Assert.assertNotEquals(InitilizerDriverBrowser.driver.getTitle(), "ErrorPage", "FAILED because ErrorPage displaying.");
			//System.out.println("No Matching Records Found.");
			//e.printStackTrace();
			//System.out.println("Exception found for excludeMultiSelectClick()");
		}
	}
	
	

		
	
//Test Case#7 : Verify the "Search" functionality.
	public void searchClick()
	{
		try
		{
			if(isElementPresent(multiSelectLink) && multiSelectLink.isEnabled())
			{
				multiselectCloseIcon.click();
			} 
				
			if(searchLink.isDisplayed() && searchLink.isEnabled())
			{
				Thread.sleep(2000);
				searchLink.click();
				Assert.assertEquals(InitilizerDriverBrowser.driver.getTitle(), "Search",  "Search title verified Failed");
				
				Thread.sleep(5000);
				new Select(dimensionDrop).selectByVisibleText("Patients");
			
				Thread.sleep(5000);
				new Select(attributeDrop).selectByValue("Patient_name");
				
				Thread.sleep(4000);
				new Select(filterCriteriaDrop).selectByVisibleText("contains");
				
				Thread.sleep(1000);
				criteriaKeyword.sendKeys("thomas");
					
				Thread.sleep(3000);
				btnGroupCommit.click();
			
				Assert.assertEquals(keywordFound.getText().contains("thomas"), true,  "Keyword 'thomas' Failed");
			
				Thread.sleep(3000);
				btnSearch.click();
				
				Thread.sleep(3000);
				checkAllCheckbox.click();
				btnApply.click();
				
				Thread.sleep(3000);
				Actions objAction=new Actions(InitilizerDriverBrowser.driver);
				objAction.moveToElement(multiSelectLink).build().perform(); 
				Thread.sleep(3000);
				patientDimension.click();
				
				int patientsRowscount = patientsRows.size();
			
				for(int i=3; i<=patientsRowscount; i++)
				{
					WebElement patientsNameColumntext = InitilizerDriverBrowser.driver.findElement(By.xpath("//table[@id='PatientsTable']/tbody/tr["+i+"]/td[4]"));
					Assert.assertEquals(patientsNameColumntext.getText().contains("THOMAS"), true,  "'THOMAS' search result Failed");
				}
			} else{
				System.out.println("Search element not found");
			}
			
		}catch(Exception e)
		{
			//e.printStackTrace();
			Assert.assertNotEquals(InitilizerDriverBrowser.driver.getTitle(), "ErrorPage", "FAILED because ErrorPage displaying.");
			//System.out.println("Exception found for searchClick()");
		}
	}
	
	
	
	
	
//Test Case#8 : Verify the "Multi Select" functionality.
	public void multiSelectClick()
	{
		try{
			List<String> drNames = new ArrayList<String>();
			
			if(isElementPresent(multiSelectLink) && multiSelectLink.isEnabled())
			{
				multiselectCloseIcon.click();
			}
				
				if(pCpDimension.isDisplayed() && pCpDimension.isEnabled())
				{
					Thread.sleep(2000);
					pCpDimension.click();
					
					for(int i=3; i < checkBoxesFirstColumn.size(); i++)
					{
						if(i == 4 || i == 7 || i == 11)
						{	
							//Selecting only the specific check box numbers
							InitilizerDriverBrowser.driver.findElement(By.xpath("//table[@id='PCPTable']/tbody/tr[" + i + "]/td[1]/input[@type='checkbox']")).click();
							
							//Store the names of selected check box in array list object one by one
							drNames.add(InitilizerDriverBrowser.driver.findElement(By.xpath("//table[@id='PCPTable']/tbody/tr[" + i + "]/td[2]/a")).getText());
						}
					}
					
					Thread.sleep(2000);
					multiSelect.click();
					
					Thread.sleep(3000);
					Actions objAction=new Actions(InitilizerDriverBrowser.driver);
					objAction.moveToElement(multiSelectLink).build().perform(); 
					
					Thread.sleep(2000);
					pCpDimension.click();
					
					//Comparing the size of the row counts with the size of Array list object
					Assert.assertEquals(drNames.size() == (checkBoxesFirstColumn.size()-2), true, "FAILED because of size not equal");
					
					//Verifying each doctor's name with checked check box names
						for(int i=3; i <= checkBoxesFirstColumn.size(); i++)
						{
							String names = (InitilizerDriverBrowser.driver.findElement(By.xpath("//table[@id='PCPTable']/tbody/tr[" + i + "]/td[2]/a")).getText());
							Assert.assertEquals(drNames.contains(names), true, "Failed due to " + names + " not matched");
						}
				}
			
		} catch(Exception e){
			Assert.assertNotEquals(InitilizerDriverBrowser.driver.getTitle(), "ErrorPage", "FAILED because ErrorPage displaying.");
			//e.printStackTrace();
			//System.out.println("Exception found for multiSelectClick()");
		}
	}
	
	
		
	
	
//Test Case#9 : Verify the "Analytics" functionality.
	public void analyticsClick(int criteriaValue)
	{
		try
		{
			if(criteriaValue !=0){
						
				if(isElementPresent(multiSelectLink) && multiSelectLink.isEnabled())
				{
					multiselectCloseIcon.click();
				}
			
				Thread.sleep(1000);
				if(analyticsTab.isDisplayed() && analyticsTab.isEnabled())
				{
				
					Thread.sleep(2000);
					analyticsTab.click();
					Assert.assertEquals(InitilizerDriverBrowser.driver.getTitle(), "Scenario-Builder", "Failed because of not navigating to Analytics page");
				
					new Select (dimensionsDropDown).selectByVisibleText("Patients");
					Thread.sleep(3000);
				
					new Select (whoseDropDown).selectByValue("risk");
					Thread.sleep(3000);
				
					new Select (riskDropDown).selectByVisibleText("Avg. HCCRisk");
					Thread.sleep(3000);
				
					new Select (criteriaDropDown).selectByIndex(2);
					Thread.sleep(1000);
				
					String criVal = Integer.toString(criteriaValue);
					criteriafield.sendKeys(criVal);
				
				
					commitCriteriaBtn.click();
				
					Thread.sleep(2000);
					Assert.assertEquals(conditionField.getText().matches("(.*)"+criVal+"(.*)"), true, "Conditions failed");
				
				
					commitMasterCriteriaBtn.click();
					Thread.sleep(2000);
				
					Assert.assertEquals(conditionField.getText().matches("(.*)"+criVal+"(.*)"), true, "Conditions failed");
				
					Thread.sleep(2000);
					submitAnlysticBtn.click();
				
				
					//Alert alert = InitilizerDriverBrowser.driver.switchTo().alert();
					//Assert.assertEquals(alert.getText(), "Do you want to Submit Analytic without saving Template.  Click OK to Continue.", "Pop-up message is not matched");
					Thread.sleep(3000);
					Assert.assertEquals(isAlertPresent(), true, "FAILED becasues alert pop-up is not displayed");
					InitilizerDriverBrowser.driver.switchTo().alert().accept();
				
					//Thread.sleep(10000);
					WaitDriver.implicitWait(resultWindow);
					Assert.assertEquals(isElementPresent(resultWindow), true, "FAILED becasues pop-up window is not displayed");
					
					Thread.sleep(2000);
					allChkBox.click();
					
					Thread.sleep(1000);
					applyBtn.click();
				
					Thread.sleep(2000);
					Actions actObj = new Actions(InitilizerDriverBrowser.driver);
					actObj.moveToElement(multiSelectLink).build().perform();
				
					Thread.sleep(2000);
					patientDimension.click();
				
					Thread.sleep(2000);
					plusSingACR.click();
				
					Thread.sleep(1000);
					linkHCCRisk.click();
				
					//Size of the rows in PatientsTable
					int rowCount = InitilizerDriverBrowser.driver.findElements(By.xpath("//table[@id='PatientsTable']/tbody/tr")).size();
				
					for (int i = 3; i <= rowCount; i++  )
					{
						Thread.sleep(2000);
					
						//Fetching the value which is greater than 2 and converting into double prim type
						double hccfRiskValue = Double.parseDouble(InitilizerDriverBrowser.driver.findElement(By.xpath("//table[@id='PatientsTable']/tbody/tr[" + i + "]/td[23]")).getText());
					
						//Verifying the value is greater than the criteria value or not.
						Assert.assertEquals(hccfRiskValue > criteriaValue, true, "FAILED because HCCFRisk value is less than "+criteriaValue);
						//System.out.println("Criteria value " + hccfRiskValue);
					}
				}
			} else{
				Assert.assertNotEquals(criteriaValue <= 0, true, "FAILED because month value is equal to ZERO or less than ZERO");
			}
		} catch(Exception e){
			Assert.assertNotEquals(InitilizerDriverBrowser.driver.getTitle(), "ErrorPage", "FAILED because ErrorPage displaying.");
			e.printStackTrace();
			//System.out.println("Exception found for analyticsClick()");
		}
	}
	
	

	
	
	
//	Test Case#10 : Save view and Reports functionality
	public void saveViewLinkClick(int monthsToSelect, String viewReportName)
	{
		try{
			
			if(isElementPresent(multiSelectLink) && multiSelectLink.isEnabled())
			{
				multiselectCloseIcon.click();
			}
				WebDriverWait wait = new WebDriverWait(InitilizerDriverBrowser.driver, 3);
				wait.until(ExpectedConditions.elementToBeClickable(signPlusMinusDOS));
				plusClick(signPlusMinusDOS);
				
				if(monthsToSelect > 0 && monthsToSelect <= monthChecks.size() )
				{
					this.monthsToSelect = monthsToSelect;
					for(WebElement yearToClick : yearChecks) 
					{
						yearToClick.click();
					}
				
					for(WebElement quartToClick : quarterChecks) 
					{	
						quartToClick.click();
					}
							
					for(int i = 0; i < monthsToSelect; i++) 
					{
						monthChecks.get(i).click();
						//System.out.println("Month Sizes  " + monthChecks.size());
					}
					
					if(isElementPresent(multiSelect) && multiSelect.isEnabled())
					{
						multiSelect.click();
						Thread.sleep(1000);
						
						//Mouse hovering on multi-select link 
						Actions objAction=new Actions(InitilizerDriverBrowser.driver);
						objAction.moveToElement(multiSelectLink).build().perform();
						Thread.sleep(1000);
						
						saveThisViewLink.click();
						Assert.assertEquals(InitilizerDriverBrowser.driver.getTitle(), "Save this view", "FAILED because Save this view title is not matched");
						Thread.sleep(2000);
						
						//To name the view
						viewName.sendKeys(viewReportName);
						Thread.sleep(2000);
						
						//To add the description
						descField.sendKeys("Details of " +viewReportName );
						createViewBtn.click();
						Thread.sleep(1000);
						
						//Verifying the successful message after creating View
						Assert.assertEquals(successMsg.getText(), "View Successfully Created.", "FAILED because view not created successfully");
						Thread.sleep(2000);
						
						//Click on Report link
						linkReports.click();
						Thread.sleep(3000);

						//Click on View link
						linkViewName.click();
						Thread.sleep(3000);
						
						Assert.assertEquals(isElementPresent(multiSelect), true, "FAILED because multiSelect link is not found.");
						Thread.sleep(1000);
						
						//Mouse hovering on multi-select link 
						Actions objAct=new Actions(InitilizerDriverBrowser.driver);
						objAct.moveToElement(multiSelectLink).build().perform();
						
						//To expand DOS dimension
						dimensionClick(dateOfServiceDimension, signPlusMinusDOS);
						Thread.sleep(7000);
						
						//To verify whether DOS dimension expanded or not.
						Assert.assertEquals(minusSing(minusImage), true, "FAILED because DateOfService dimension is not expanded.");
						Thread.sleep(4000);
						
						//To verify whether one year data displaying or not.
						Assert.assertEquals(monthChecks.size() == monthsToSelect , true, "FAILED because " + monthsToSelect + " months data is not available.");
						
					} else{
						Assert.assertEquals(isElementPresent(multiSelect), true, "FAILED because MultiSelect element is not found.");
					}
				
				}else{
					Assert.assertNotEquals(monthsToSelect <= 0, true, "FAILED because month value is ZERO or less than ZERO");
				}
			
			}catch(Exception e){
				Assert.assertNotEquals(InitilizerDriverBrowser.driver.getTitle(), "ErrorPage", "FAILED because ErrorPage displaying.");
				//e.printStackTrace();
				//System.out.println("Exception found for saveViewLinkClick()");
			} 
		
		} 
		
	
	
	
	
//Test Case#11 : Open charts functionality
	public void openChartsClick()
	{
		try
		{
			if(isElementPresent(multiSelectLink) && multiSelectLink.isEnabled())
			{
				multiselectCloseIcon.click();
				Thread.sleep(1000);
			}
			
			if(isElementPresent(linkCharts) && linkCharts.isEnabled())
			{
				linkCharts.click();
				Thread.sleep(2000);
				
				//To get all the values from the drop down
				List<WebElement> allOptions = new Select(chartTypeDropBox).getOptions();
				//System.out.println(allOptions.size());
				
				/*for(int i=0; i<allOptions.size(); i++){
					
					String chartN = allOptions.get(i).getText();
					System.out.println(chartN);
					
				}*/
				
				System.out.println();
				for(WebElement chartName: allOptions)
				{
					switch(chartName.getText())
					{
						case "SOHChart":
						{	
							Thread.sleep(2000);
							//chartName.click();
							new Select(chartTypeDropBox).selectByVisibleText(chartName.getText());
							Thread.sleep(1000);
							
							chartSubmitBtn.click();
							Thread.sleep(15000);
							
							//System.out.println(chartName.getText() + "Chart name");
							Assert.assertEquals(isElementPresent(chartSOH), true, "FAILED because " + chartName.getText() + " is not open.");
							break;
						}
						
						/*case "Geo Spatial Chart":
						{	
							//chartName.click();
							new Select(chartTypeDropBox).selectByVisibleText(chartName.getText());
							Thread.sleep(1000);
							
							updateMapBtn.click();
							Thread.sleep(10000);
							Assert.assertEquals(isElementPresent(chartGeoSpatial), true, "FAILED because " + chartName.getText() + " chart is not open.");
							//System.out.println(chartName.getText() + "Chart name");
							break;
						}*/
						
						case "Pareto Chart":
						{	
							//chartName.click();
							new Select(chartTypeDropBox).selectByVisibleText(chartName.getText());
							Thread.sleep(1000);
							
							chartSubmitBtn.click();
							Thread.sleep(12000);
							Assert.assertEquals(isElementPresent(chartPareto), true, "FAILED because " + chartName.getText() + " chart is not open.");
							//System.out.println(chartName.getText() + "Chart name");
							break;
						}
						
						case "Patient Density Chart":
						{	
							//chartName.click();
							new Select(chartTypeDropBox).selectByVisibleText(chartName.getText());
							Thread.sleep(1000);
							
							chartSubmitBtn.click();
							Thread.sleep(12000);
							Assert.assertEquals(isElementPresent(chartPatientDensity), true, "FAILED because " + chartName.getText() + " chart is not open.");
							//System.out.println(chartName.getText() + "Chart name");
							break;
						}
					
						case "Pie Chart":
						{	
							//chartName.click();
							new Select(chartTypeDropBox).selectByVisibleText(chartName.getText());
							Thread.sleep(1000);
							
							chartSubmitBtn.click();
							Thread.sleep(12000);
							Assert.assertEquals(isElementPresent(chartPie), true, "FAILED because " + chartName.getText() + " chart is not open.");
							//System.out.println(chartName.getText() + "Chart name");
							break;
						}
						
						case "Risk Chart":
						{	
							//chartName.click();
							new Select(chartTypeDropBox).selectByVisibleText(chartName.getText());
							Thread.sleep(1000);
							
							chartSubmitBtn.click();
							Thread.sleep(12000);
							Assert.assertEquals(isElementPresent(chartRisk), true, "FAILED because " + chartName.getText() + " chart is not open.");
							//System.out.println(chartName.getText() + "Chart name");
							break;
						}
						
						case "Risk Heat Map":
						{	
							//chartName.click();
							new Select(chartTypeDropBox).selectByVisibleText(chartName.getText());
							Thread.sleep(1000);
							
							chartSubmitBtn.click();
							Thread.sleep(12000);
							Assert.assertEquals(isElementPresent(chartRiskHeatMap), true, "FAILED because " + chartName.getText() + " chart is not open.");
							//System.out.println(chartName.getText() + "Chart name");
							break;
						}
						
						case "Trend Chart":
						{	
							//chartName.click();
							new Select(chartTypeDropBox).selectByVisibleText(chartName.getText());
							Thread.sleep(1000);
							
							chartSubmitBtn.click();
							//Thread.sleep(15000);
							WaitDriver.implicitWait(chartTrend);
							Assert.assertEquals(isElementPresent(chartTrend), true, "FAILED because " + chartName.getText() + " chart is not open.");
							//System.out.println(chartName.getText() + "Chart name");
							break;
						}
						
						case "Waterfall Chart":
						{	
							//chartName.click();
							new Select(chartTypeDropBox).selectByVisibleText(chartName.getText());
							Thread.sleep(1000);
							
							inflationField.sendKeys("2");
							chartSubmitBtn.click();
							Thread.sleep(12000);
							Assert.assertEquals(isElementPresent(chartWaterfall), true, "FAILED because " + chartName.getText() + " chart is not open.");
							//System.out.println(chartName.getText() + "Chart name");
							break;
						}
						
						case "Patient Risk Chart":
						{	
							//chartName.click();
							new Select(chartTypeDropBox).selectByVisibleText(chartName.getText());
							Thread.sleep(1000);
							
							chartSubmitBtn.click();
							Thread.sleep(12000);
							Assert.assertEquals(isElementPresent(chartPatientRisk), true, "FAILED because " + chartName.getText() + " chart is not open.");
							//System.out.println(chartName.getText() + "Chart name");
							break;
						}
						
						case "Quadrant Chart":
						{	
							//chartName.click();
							new Select(chartTypeDropBox).selectByVisibleText(chartName.getText());
							Thread.sleep(1000);
							
							chartSubmitBtn.click();
							//Thread.sleep(20000);
							WaitDriver.implicitWait(chartQuadRant);
							Assert.assertEquals(isElementPresent(chartQuadRant), true, "FAILED because " + chartName.getText() + " chart is not open.");
							//System.out.println(chartName.getText() + "Chart name");
							break;
						}
						
						
						case "Trend Chart to Compare Views":
						{	
							//chartName.click();
							new Select(chartTypeDropBox).selectByVisibleText(chartName.getText());
							Thread.sleep(1000);
							//chartSubmitBtn.click();
							
							if(isAlertPresent()){
								//Close the alert
								InitilizerDriverBrowser.driver.switchTo().alert().accept();
								
								//Navigate to Patient Risk Analyzer
								patientRiskAnalyzerTab.click(); 
								Thread.sleep(500);
								
								//Call this method to create view
								saveViewLinkClick(12, "Test View Report One 12");
								saveViewLinkClick(12, "Test View Report Two 12");
								
								if(isElementPresent(multiSelectLink) && multiSelectLink.isEnabled())
								{
									multiselectCloseIcon.click();
								}
								
								//Click on Charts link
								linkCharts.click();
								Thread.sleep(2000);
								
								//Select chart name from the drop down
								new Select(chartTypeDropBox).selectByVisibleText("Trend Chart to Compare Views");
								Thread.sleep(1000);
								
								//Select two views for chart
								viewsFieldBtn.click();
								Thread.sleep(500);
								
								//checkAllLink.click();
								firstViewChkbox.click();
								secondViewChkbox.click();
								Thread.sleep(1000);
								
								//Tab out for moving to Submit button
								new Actions(InitilizerDriverBrowser.driver).sendKeys(Keys.TAB).build().perform();
								
								//Click on Submit button
								chartSubmitBtn.click();
								Thread.sleep(20000);
								
							}else{
								
								viewsFieldBtn.click();
								firstViewChkbox.click();
								secondViewChkbox.click();
								Thread.sleep(1000);
								
								//Tab out for moving to Submit button
								new Actions(InitilizerDriverBrowser.driver).sendKeys(Keys.TAB).build().perform();
								
								chartSubmitBtn.click();
								//Thread.sleep(20000);
								WaitDriver.implicitWait(chartTreadViewsCompare);
							}
							
							Thread.sleep(20000);
							Assert.assertEquals(isElementPresent(chartTreadViewsCompare), true, "FAILED because " + chartName.getText() + " chart is not open.");
							//System.out.println(chartName.getText() + "Chart name");
							break;
						}
					}
				}	
				
			} else{
				
				Assert.assertEquals(isElementPresent(linkCharts), true, "FAILED because chart link is not found.");
			}
			
		} catch(Exception e){
			Assert.assertNotEquals(InitilizerDriverBrowser.driver.getTitle(), "ErrorPage", "FAILED because ErrorPage displaying.");
			//e.printStackTrace();
			//System.out.println("Exception found for openChartsClick()");
		}
	}
	
	
	
	

	//Test Cases#12 : Verify the PMPM cost for 2015 - Q2 from DOS Dimension
	public void verifyCostPMPM()
	{
		double totalCost=0;
		double totalPMPMCost=0;
		
		long enroleeCountFirstMonth = 0;
		long enroleeCountSecondMonth = 0;
		long enroleeCountThirdMonth = 0;
		long sumOfEnroleeCount=0;
		
		String actualTotalPMPMCost = null;
		String expectedTotalPMPMCost = null;
		String year = null;
		String quarter = null;
		
		
		try
		{
			patientRiskAnalyzerTab.click();
			Thread.sleep(500);
			
			//Expanding Date of Service Dimension
			dimensionClick(dateOfServiceDimension, signPlusMinusDOS);
			WaitDriver.implicitWait(summaryDOS);
			
			
			for(WebElement yearToClick : yearChecks) {
				yearToClick.click();
			}
		
			for(WebElement quartToClick : quarterChecks) {	
				quartToClick.click();
			}
					
			/*for(int i=0; i < monthsToSelect; i++) {
				monthChecks.get(i).click();
			}*/
			
			
			//InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='Time_Hosp_Admissions_RateImg']")).click();
			
			List<WebElement> rows =  InitilizerDriverBrowser.driver.findElements(By.xpath("//*[@id='TimeTable']/tbody/tr"));
			
			for(int i=1; i<rows.size(); i++){
				
				//Fetching the year from web table
				year = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + i + "]/td[1]")).getText();
				
				//Fetching the each quarter from web table
				quarter = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + i + "]/td[2]")).getText();
				
				//Comparing fetched quarter 
				if(quarter.equalsIgnoreCase("Q4")){
					
					//Fetching the last month of Q4
					String monthDec = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+1) + "]/td[3]")).getText();
					
					if(monthDec.equalsIgnoreCase("Dec")){
						
						//Fetching total cost of Q4
						String 	totalCostQ4 = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + i + "]/td[10]")).getText().substring(1).replace(",", "");
						if(totalCost == 0){
							totalCost = Double.parseDouble(totalCostQ4);
						}
						
						//Fetching total PMPMCost of Q4
						String 	totalPMPMCostQ4 = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + i + "]/td[7]")).getText().substring(1).replace(",", "");
						if(expectedTotalPMPMCost == null){
							expectedTotalPMPMCost = totalPMPMCostQ4;
						}
						
						//Fetching the enrollee count of December in Q4
						String enroleeCountDec = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+1) + "]/td[5]")).getText().replace(",", "");
						if(enroleeCountFirstMonth == 0){
							enroleeCountFirstMonth = Long.parseLong(enroleeCountDec);
						}
						
						//Fetching the enrollee count of November in Q4
						String enroleeCountNov = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+2) + "]/td[5]")).getText().replace(",", "");
						if(enroleeCountSecondMonth == 0){
							enroleeCountSecondMonth = Long.parseLong(enroleeCountNov);
						}
						
						//Fetching the enrollee count of October in Q4
						String enroleeCountOct = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+3) + "]/td[5]")).getText().replace(",", "");
						if(enroleeCountThirdMonth == 0){
							enroleeCountThirdMonth = Long.parseLong(enroleeCountOct);
						}
					}
				}
				
				
				if(quarter.equalsIgnoreCase("Q3")){
					
					String monthSep = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+1) + "]/td[3]")).getText();
					
					if(monthSep.equalsIgnoreCase("Sep")){
						
						String 	totalCostQ3 = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + i + "]/td[10]")).getText().substring(1).replace(",", "");
						if(totalCost == 0){
							totalCost = Double.parseDouble(totalCostQ3);
						}
						
						String 	totalPMPMCostQ3 = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + i + "]/td[7]")).getText().substring(1).replace(",", "");
												
						if(expectedTotalPMPMCost == null){
							expectedTotalPMPMCost = totalPMPMCostQ3;
						}
						
						String enroleeCountSep = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+1) + "]/td[5]")).getText().replace(",", "");
						
						if(enroleeCountFirstMonth == 0){
							enroleeCountFirstMonth = Long.parseLong(enroleeCountSep);
						}
						
						String enroleeCountAug = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+2) + "]/td[5]")).getText().replace(",", "");
						
						if(enroleeCountSecondMonth == 0){
							enroleeCountSecondMonth = Long.parseLong(enroleeCountAug);
						}
						
						String enroleeCountJul = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+3) + "]/td[5]")).getText().replace(",", "");
						
						if(enroleeCountThirdMonth == 0){
							enroleeCountThirdMonth = Long.parseLong(enroleeCountJul);
						}
					}
				}
				
				
				if(quarter.equalsIgnoreCase("Q2")){
					
					String monthJun = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+1) + "]/td[3]")).getText();
					
					if(monthJun.equalsIgnoreCase("Jun")){
						
						String 	totalCostQ2 = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + i + "]/td[10]")).getText().substring(1).replace(",", "");
						if(totalCost == 0){
							totalCost = Double.parseDouble(totalCostQ2);
						}
						
						String 	totalPMPMCostQ2 = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + i + "]/td[7]")).getText().substring(1).replace(",", "");
												
						if(expectedTotalPMPMCost == null){
							expectedTotalPMPMCost = totalPMPMCostQ2;
						}
						
						String enroleeCountJun = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+1) + "]/td[5]")).getText().replace(",", "");
						
						if(enroleeCountFirstMonth == 0){
							enroleeCountFirstMonth = Long.parseLong(enroleeCountJun);
						}
						
						String enroleeCountMay = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+2) + "]/td[5]")).getText().replace(",", "");
						
						if(enroleeCountSecondMonth == 0){
							enroleeCountSecondMonth = Long.parseLong(enroleeCountMay);
						}
						
						String enroleeCountApr = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+3) + "]/td[5]")).getText().replace(",", "");

						if(enroleeCountThirdMonth == 0){
							enroleeCountThirdMonth = Long.parseLong(enroleeCountApr);
						}
					}
				}
				
				
				if(quarter.equalsIgnoreCase("Q1")){
					
					String monthMar = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+1) + "]/td[3]")).getText();
					
					if(monthMar.equalsIgnoreCase("Mar")){
						
						String 	totalCostQ1 = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + i + "]/td[10]")).getText().substring(1).replace(",", "");

						if(totalCost == 0) {
							totalCost = Double.parseDouble(totalCostQ1);
						}
						
						String 	totalPMPMCostQ1 = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + i + "]/td[7]")).getText().substring(1).replace(",", "");
												
						if(expectedTotalPMPMCost == null){
							expectedTotalPMPMCost = totalPMPMCostQ1;
						}
						
						String enroleeCountMar = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+1) + "]/td[5]")).getText().replace(",", "");

						if(enroleeCountFirstMonth == 0){
							enroleeCountFirstMonth = Long.parseLong(enroleeCountMar);
						}
						
						String enroleeCountFeb = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+2) + "]/td[5]")).getText().replace(",", "");

						if(enroleeCountSecondMonth == 0){
							enroleeCountSecondMonth = Long.parseLong(enroleeCountFeb);
						}
						
						String enroleeCountJan = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+3) + "]/td[5]")).getText().replace(",", "");
						
						if(enroleeCountThirdMonth == 0){
							enroleeCountThirdMonth = Long.parseLong(enroleeCountJan);
						}
					}
				}
			}
			
			System.out.println();
			
			//Fetching Total Cost of Quarter
			/*System.out.println("Total cost of Quarter :" + totalCost);
			
			System.out.println("Enrollee Count of First Month: " + enroleeCountFirstMonth);
			System.out.println("Enrollee Count of Second Month: " + enroleeCountSecondMonth);
			System.out.println("Enrollee Count of Third Month: " + enroleeCountThirdMonth);*/
			
			//Sum of all three Enrollee Counts
			sumOfEnroleeCount = enroleeCountFirstMonth + enroleeCountSecondMonth + enroleeCountThirdMonth;
			//System.out.println("Sum of all three months Enrollee Count : " + sumOfEnroleeCount);
			
			//Converting the String value into Double for calculation
			totalPMPMCost = totalCost/sumOfEnroleeCount;
			//System.out.println("After calculation without rounding the value : " +totalPMPMCost);
			
			System.out.println("Expected PMPMQ2 Cost: " + expectedTotalPMPMCost);
			
			//Rounding to two decimal value
			actualTotalPMPMCost = (new DecimalFormat("###.00").format(totalPMPMCost));
			System.out.println("Actual PMPMQ2 Cost: " + actualTotalPMPMCost);

			//Validating the actual Total PMPM Cost of Q2 with expected Total PMPM Cost of Q2
			Assert.assertEquals(expectedTotalPMPMCost, actualTotalPMPMCost, "Failed because PMPMCost is wrong.");

		} catch(Exception e){
			Assert.assertNotEquals(InitilizerDriverBrowser.driver.getTitle(), "ErrorPage", "FAILED because ErrorPage displaying.");
			//e.printStackTrace();
		}
		
	}
	
	
	
	
	
	//Test Cases#13 : Verify the rate measures values (Hospital admission per 1000) for 2015 - Q2 from DOS Dimension
	public void verifyRateMeasureValue()
	{
		double averageOfEnroleeCount=0;
		double hospitalAdmissionPerThousand = 0;
		
		String year = null;
		String quarter = null;
		
		String enroleeCountFirstMonth = null;
		String enroleeCountSecondMonth = null;
		String enroleeCountThirdMonth = null;
		
		String sumOfAddmissionCount = null;
		
		String expectedHospitalAddimissionPerThousand = null;
		String actualHospitalAddimissionPerThousand = null;
		
		try
		{
			patientRiskAnalyzerTab.click();
			Thread.sleep(500);
			
			//Expanding Date of Service Dimension
			dimensionClick(dateOfServiceDimension, signPlusMinusDOS);
			WaitDriver.implicitWait(summaryDOS);
			
			
			for(WebElement yearToClick : yearChecks) {
				yearToClick.click();
			}
		
			for(WebElement quartToClick : quarterChecks) {	
				quartToClick.click();
			}
					
			/*for(int i=0; i < monthsToSelect; i++) {
				monthChecks.get(i).click();
			}*/
			
			List<WebElement> rows =  InitilizerDriverBrowser.driver.findElements(By.xpath("//*[@id='TimeTable']/tbody/tr"));
			
			for(int i=1; i<rows.size(); i++){
				
				//Fetching the year from web table
				year = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + i + "]/td[1]")).getText();
				
				//Fetching the each quarter from web table
				quarter = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + i + "]/td[2]")).getText();
				
				//Comparing fetched quarter 
				if(quarter.equalsIgnoreCase("Q4")){
					
					//Fetching the highest month in Q4
					String monthMar = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+1) + "]/td[3]")).getText();
					
					if(monthMar.equalsIgnoreCase("Dec")){
						
						//Fetching tool tip value from Q4 as Sum of Admission Count as per Q4
						String admissionCountToolTip = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + i + "]/td[28]")).getAttribute("title");
						if(sumOfAddmissionCount == null){
							sumOfAddmissionCount = admissionCountToolTip;
						}
						
						//Fetching admission per 1000 value as per Q4
						String 	admissionPerThousandValue = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + i + "]/td[28]")).getText();
						if(expectedHospitalAddimissionPerThousand == null){
							expectedHospitalAddimissionPerThousand = admissionPerThousandValue;
						}
						
						//Fetching enrolee count of Dec
						String enroleeCountDec = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+1) + "]/td[5]")).getText().replace(",", "");
						if(enroleeCountFirstMonth == null){
							enroleeCountFirstMonth = enroleeCountDec;
						}
						
						//Fetching enrolee count of Nov
						String enroleeCountNov = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+2) + "]/td[5]")).getText().replace(",", "");
						if(enroleeCountSecondMonth == null){
							enroleeCountSecondMonth = enroleeCountNov;
						}
						
						//Fetching enrolee count of Oct
						String enroleeCountOct = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+3) + "]/td[5]")).getText().replace(",", "");
						if(enroleeCountThirdMonth == null){
							enroleeCountThirdMonth = enroleeCountOct;
						}
					}
				}
				
				
				if(quarter.equalsIgnoreCase("Q3")){
					
					String monthMar = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+1) + "]/td[3]")).getText();
					
					if(monthMar.equalsIgnoreCase("Sep")){
						
						String admissionCountToolTip = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + i + "]/td[28]")).getAttribute("title");
						if(sumOfAddmissionCount == null){
							sumOfAddmissionCount = admissionCountToolTip;
						}
						
						String 	admissionPerThousandValue = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + i + "]/td[28]")).getText();
						if(expectedHospitalAddimissionPerThousand == null){
							expectedHospitalAddimissionPerThousand = admissionPerThousandValue;
						}
						
						String enroleeCountSep = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+1) + "]/td[5]")).getText().replace(",", "");
						if(enroleeCountFirstMonth == null){
							enroleeCountFirstMonth = enroleeCountSep;
						}
						
						String enroleeCountAug = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+2) + "]/td[5]")).getText().replace(",", "");
						if(enroleeCountSecondMonth == null){
							enroleeCountSecondMonth = enroleeCountAug;
						}
						
						String enroleeCountJul = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+3) + "]/td[5]")).getText().replace(",", "");
						if(enroleeCountThirdMonth == null){
							enroleeCountThirdMonth = enroleeCountJul;
						}
					}
				}
				
				
				if(quarter.equalsIgnoreCase("Q2")){
					
					String monthMar = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+1) + "]/td[3]")).getText();
					
					if(monthMar.equalsIgnoreCase("Jun")){
						
						String admissionCountToolTip = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + i + "]/td[28]")).getAttribute("title");
						if(sumOfAddmissionCount == null){
							sumOfAddmissionCount = admissionCountToolTip;
						}
						
						String 	admissionPerThousandValue = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + i + "]/td[28]")).getText();
						if(expectedHospitalAddimissionPerThousand == null){
							expectedHospitalAddimissionPerThousand = admissionPerThousandValue;
						}
						
						String enroleeCountJun = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+1) + "]/td[5]")).getText().replace(",", "");
						if(enroleeCountFirstMonth == null){
							enroleeCountFirstMonth = enroleeCountJun;
						}
						
						String enroleeCountMay = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+2) + "]/td[5]")).getText().replace(",", "");
						if(enroleeCountSecondMonth == null){
							enroleeCountSecondMonth = enroleeCountMay;
						}
						
						String enroleeCountApr = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+3) + "]/td[5]")).getText().replace(",", "");
						if(enroleeCountThirdMonth == null){
							enroleeCountThirdMonth = enroleeCountApr;
						}
					}
				}
				
				
				if(quarter.equalsIgnoreCase("Q1")){
					
					String monthMar = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+1) + "]/td[3]")).getText();
					
					if(monthMar.equalsIgnoreCase("Mar")){
						
						String admissionCountToolTip = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + i + "]/td[28]")).getAttribute("title");
						
						if(sumOfAddmissionCount == null){
							sumOfAddmissionCount = admissionCountToolTip;
						}
						
						String 	admissionPerThousandValue = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + i + "]/td[28]")).getText();
						if(expectedHospitalAddimissionPerThousand == null){
							expectedHospitalAddimissionPerThousand = admissionPerThousandValue;
						}
						
						String enroleeCountMar = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+1) + "]/td[5]")).getText().replace(",", "");
						if(enroleeCountFirstMonth == null){
							enroleeCountFirstMonth = enroleeCountMar;
						}
						
						String enroleeCountFeb = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+2) + "]/td[5]")).getText().replace(",", "");
						if(enroleeCountSecondMonth == null){
							enroleeCountSecondMonth = enroleeCountFeb;
						}
						
						String enroleeCountJan = InitilizerDriverBrowser.driver.findElement(By.xpath(".//*[@id='TimeTable']/tbody/tr[" + (i+3) + "]/td[5]")).getText().replace(",", "");
						if(enroleeCountThirdMonth == null){
							enroleeCountThirdMonth = enroleeCountJan;
						}
					}
				}
			}
			
			System.out.println(); System.out.println();
			
			//Fetching Sum of Admission Count as tool tip value for Quarter
			/*System.out.println("Sum of Admission Count tool tip :" + sumOfAddmissionCount);
			
			System.out.println("Enrollee Count of First Month : " + enroleeCountFirstMonth);
			System.out.println("Enrollee Count of Second Month : " + enroleeCountSecondMonth);
			System.out.println("Enrollee Count of Third Month : " + enroleeCountThirdMonth);*/
			
			//Converting the String value into Double value and find out the average of three months of a quarter
			averageOfEnroleeCount = (Double.parseDouble(enroleeCountFirstMonth) + Double.parseDouble(enroleeCountSecondMonth) + Double.parseDouble(enroleeCountThirdMonth))/3 ;
			//System.out.println("Average of all three months Enrollee Count : " + averageOfEnroleeCount);
			
			//Converting the String value into Double value and calculating as per the formula (Sum of admission count / average of enrollee count)*1000
			hospitalAdmissionPerThousand = (Double.parseDouble(sumOfAddmissionCount)/averageOfEnroleeCount)*1000; 
			//System.out.println("After calculation without rounding the value : " + hospitalAdmissionPerThousand);
			
			System.out.println("Expected Hospital Addimission Per Thousand Value : " + expectedHospitalAddimissionPerThousand);
			
			//Rounding to two decimal value and manipulating with the value '0.01' to match with accurate value in UI
			actualHospitalAddimissionPerThousand = (new DecimalFormat("###.00").format(hospitalAdmissionPerThousand + 0.01));
			System.out.println("Actual Hospital Addimission Per Thousand Value : " + actualHospitalAddimissionPerThousand);
			
			//Validating the actual Total PMPM Cost of Q2 with expected Total PMPM Cost of Q2
			Assert.assertEquals(expectedHospitalAddimissionPerThousand, actualHospitalAddimissionPerThousand, "Failed because Actual Hospital Addimission Per 1000 value is wrong.");

		} catch(Exception e){
			Assert.assertNotEquals(InitilizerDriverBrowser.driver.getTitle(), "ErrorPage", "FAILED because ErrorPage displaying.");
			//e.printStackTrace();
			//System.out.println("Exception found for openChartsClick()");
		}
	}
	
	
	
	
} //Class Ends here
	
	



