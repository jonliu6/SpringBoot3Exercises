1. Install and configure MySQL Database

	• Download MySQL from www.mysql.com and configure thru the installation
	• If you download .zip file, run %MYSQL_HOME%\bin\mysql_configurator.exe and configure the data folder, accounts, service etc.
		○ Data Directory: C:\ProgramData\MySQL\data
		○ Type and Networking: defaults - Development Computer, TCP/IP, Port 3306 etc
		○ Root password and any user accounts
		○ Windows Services (optional if running as standalone)
		○ Server File Permission: defaults only to Administrators Group, you may need to manually add the users' access
		○ Sample Database: skip
		○ Apply Configuration - execute
		
	• Start MySQL by running mysqld --defaults-file="C:/ProgramData/MySQL/data/my.ini" --console
	• Stop MySQL by running mysqladmin -u root -p shutdown
	• Connect to MySQL using mysql -u <userid> -p
	• List existing databases: Show databases;
	• Create a new database: CREATE DATABASE demodb;
	• Switch to a database: USE <database name>;

2. Download Spring Boot initial project from https://start.spring.io/
	• specify Project Metadata
	• Add dependencies - MySQL Driver, Spring Data JPA

