# BOA Accessibility Test Framework

This framework is for Accessibility Testing of Bank Of America application.

Below tools are used in this framework:
- Selenium WebDriver 4.1.4
- TestNG 7.5
- Axe Core (axe-core:selenium) library 4.4.1
- WebDriver Manager 5.1.1


## Requirements
- Chrome/FireFox must be installed. If this has to be run on any other browser please update `src/test/java/boa/config/Hooks.java` accordingly.
- Java SE Development Kit must be installed.
- Maven must be installed


## To Run
- Go to `testng.xml` -> update `browser` parameter with required browser name. Ex: Chrome, FireFox.
- Add listeners to Run Configurations for TestNG HTML Reports
- Run/Debug `testng.xml`
- If you want to enable or disable Axe Scan then update `enableAxes` parameter in `testng.xml`. By default, scan is enabled.


## Approach
- Using above-mentioned tools I'm automating BOA application.
- For each page and also for same pages with different popups/dialogs I'm scanning for Accessibility checks.
- Separate scan reports (Full JSON Report, Violations Readable Text Report) for each page will be generated for ease of debugging/sharing/fixing. 
