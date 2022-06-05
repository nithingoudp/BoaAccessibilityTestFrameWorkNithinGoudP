package boa.pages;

import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeReporter;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import static boa.config.Hooks.*;

public abstract class BasePage {

    private static Results axeAnalysis;
    private static String ReportDirectory = null;
    private static final String AxeReportsDir = "AxeReports";
    private static final String DatePattern = "yyyy_MM_dd_HH_mm_ss";

    abstract void analyzeThisPage();

    public void analyzePage(String fileName) {
        if (isAxesEnabled) {
            axeAnalysis = axeBuilder.analyze(driver);

            generateReport(fileName);
        }
    }

    public void analyzePage(WebElement element, String fileName) {
        if (isAxesEnabled) {
            axeAnalysis = axeBuilder.analyze(driver, element);

                generateReport(fileName);
        }
    }

    private void generateReport(String fileName) {
        List<Rule> violations = axeAnalysis.getViolations();

        AxeReporter.getReadableAxeResults("Accessibility Test", driver, violations);

        if (violations.size() != 0) {
            if (ReportDirectory == null) {
                ReportDirectory = System.getProperty("user.dir")+ File.separator + AxeReportsDir + File.separator
                        + "AxeReport_" + new SimpleDateFormat(DatePattern).format(new java.util.Date())
                        + File.separator;
                new File(ReportDirectory).mkdirs();
            }

            String reportPath = ReportDirectory + fileName + "_Violations_" + new SimpleDateFormat(DatePattern).format(new java.util.Date());
            AxeReporter.writeResultsToTextFile(reportPath, AxeReporter.getAxeResultString());

            reportPath = reportPath.replace("_Violations_", "_Report_");
            AxeReporter.writeResultsToJsonFile(reportPath, axeAnalysis);

        } else
            System.out.println("No Violations in " + fileName);
    }
}
