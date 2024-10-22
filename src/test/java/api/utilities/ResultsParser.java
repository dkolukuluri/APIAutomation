package api.utilities;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ResultsParser {

    public static String parseAllureResults(String allureResultsPath) throws IOException {
        File resultsDirectory = new File(allureResultsPath);
        File[] resultFiles = resultsDirectory.listFiles((dir, name) -> name.endsWith(".json"));
        
        if (resultFiles == null) {
            System.out.println("No Allure results found!");
            return allureResultsPath;
        }

        int passedCount = 0;
        int failedCount = 0;
        int skippedCount = 0;

        ObjectMapper objectMapper = new ObjectMapper();

        for (File resultFile : resultFiles) {
            JsonNode rootNode = objectMapper.readTree(resultFile);
            String status = rootNode.path("status").asText();
            
            switch (status.toLowerCase()) {
                case "passed":
                    passedCount++;
                    break;
                case "failed":
                    failedCount++;
                    break;
                case "skipped":
                    skippedCount++;
                    break;
            }
        }

        return generateCustomHtmlReport(passedCount, failedCount, skippedCount);
    }

    public static String generateCustomHtmlReport(int passed, int failed, int skipped) {
        String htmlReport =
                "<html><head><title>Custom Test Report</title></head>" +
                        "<body><h1>Test Execution Summary</h1>" +
                        "<p><strong>Passed Tests:</strong> " + passed + "</p>" +
                        "<p><strong>Failed Tests:</strong> " + failed + "</p>" +
                        "<p><strong>Skipped Tests:</strong> " + skipped + "</p>" +
                        "</body></html>";

        try {
            File reportFile = new File("custom-report.html");
            FileUtils.writeStringToFile(reportFile, htmlReport, "UTF-8");
            System.out.println("Custom HTML report generated: " + reportFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
		return htmlReport;
    }
}

