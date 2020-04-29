## Automation Test Configuration 


### Below are the steps depicting how to Configure and Execute Selenium automation scripts in IntelliJ Idea


#### Prerequisites for the machine where automation is supposed to run
1. Java must be installed. Version must be 1.8 or above. Download from http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
2. Download IntelliJ Idea from https://www.jetbrains.com/idea/download

#### Steps:
1) Clone the automation project from GitHub
2) Unzip the attached automation project to your local drive
3) Open IntelliJ
4) Click Import Project 
5) To know how to import maven project in IntelliJ - https://www.jetbrains.com/help/idea//2017.1/importing-project-from-maven-model.html
6) Once imported, It might take few mins to be loaded

#### Changing Test Data according to particular org
1) Open spreadsheet(UserData.xlsx which is contained in the project itself) located at src\test\resources\TestData\UserData.xlsx 
2) Open Users sheet
3) Update following column values For Admin user
##### Columns: UserType,	UserName,	Password, UserURL
 
#### Setting Chrome browser mode (Headless or HeadFull)
1) Open src/test/resources/TestData/UserData.xlsx
2) Navigate to URL sheet
3) Under the Browser column, Select desired mode of browser

#### To run the scripts in parallel, Please follow the following steps

1) Open the workbook src/test/resources/SuiteControl/TestSelection.xlsx
2) Now Open the sheet called SuiteControl.
3) Left hand side there are modules.
4) There is a column RunMode which tell which module has to be executed in parallel by setting Yes/No.
5) There is another column called ParallelCount which tell how many threads are to be run. Put any count from 0 to 3. We can put more than 3 also but it might distrub the execution.
6) In the same workbook there are other sheet (Module wise). These sheets have related test cases. Put Yes/No for those particular test cases.

#### Executing a single script

1) Double click any script you want to execute under src/test/java/MRCS/Tests/
2) Right click on the opened script
3) Select Run As -> TestNG Test

#### Executing the whole suite
1) Now in IntelliJ, navigate to View Menu -> Tools Windows -> Maven Project
2) On the right side you will see Maven Project
3) Expand the Project
4) Expand The LifeCycle menu
5) Click on clean
6) Click On Run Maven Build in the Maven Project window
7) Once you see the Build Success in console then select test option and click Run Maven Build in the Maven Project window
8) You will see tests running

##Note
1. All the forms must be configured before proceed
2. If any of the form not available then in Suite control sheet that particular test should be marked as 'No'
###Updating Suite Control workbook
1. Open workbook src/test/resources/SuiteControl/TestSelection.xlsx
2. Goto the desired module and mark Yes/No based on the requirement for run mode.      
