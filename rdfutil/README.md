In order to run this sample the first thing to do is to install Netbeans with all the features. 
This will also install Maven bundled usually located in the following folder if windows is chosen:
Maven folder bundled with Netbeans: C:\Program Files\NetBeans 8.0.2\java\maven
Once installed Netbeans the next thing to do is download the project from Github and using the commandline inside the project folder
where the pom.xml file resides issue the command:
mvn clean install
This command will compile the project and will install it in the local Maven repository which is on Windows installation located
in the following folder:
C:\Users\Username\.m2\repository\com\mycompany
the file pom xml contains information that allow to get all the dependencies from different maven repositories online and linked them.
The plugin shade allows also to declare the Main class inside the project and render it executable using the command line
command:
java -jar TestMv-1.0-SNAPSHOT.jar

The downloaded zip folder from github can be opened directly from netbeans and the project type is a maven project console application.
I have created a start class just to give an example of utilization of the shade plugin see pom.xml which add a manifest and also includes all dependencies for the final jar to run.
The final jar can be used also as a lybrary in whatever other java application.

The study is proceeding and this document will be updated with new pieces of information soon.


