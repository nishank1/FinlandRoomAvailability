# backend-room-availabilty
New spring-boot backend module 
This is a new module which will handle the back-end part of this new app
Prerequisites
---------------

    Java 8 SDK
    Maven 3
    IDE - IntelliJ/Eclipse

Application setup
----------------------
1. Clone the project to the local or remote system(<DOWNLOAD_DIR>).
2. Build using - mvn clean install
3. For IDE, import it like a normal maven project
4. Modify src/main/resources/application.properties according to your requirements, the default config works fine otherwise
5. Now run/debug the project

Local testing
----------------------
If you have local port forwarding to 8000, you can just start the application by running
1. mvn spring-boot:run

Output: for database : http://localhost:8000/h2-console/
for apis install post-man