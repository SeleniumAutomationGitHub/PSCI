set projectLocation=C:\Users\skbehera\git\PSCI\PSCI
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\PSCIExecute.xml