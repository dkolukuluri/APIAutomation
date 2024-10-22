package api.utilities;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EditEmailableReport {
    public static String editHTMLFile(String filename, StringBuilder finalString) {

    		String modifiedHtml = null;
        try {
            // Read the entire HTML file into a String
            String htmlContent = new String(Files.readAllBytes(Paths.get(filename)));
            
            // Print the original HTML content
            //System.out.println("Original HTML:");
            //System.out.println(htmlContent);
            
            // Replace the placeholders {{title}} and {{message}} with actual values
            modifiedHtml = htmlContent
                    .replace("{replacethistring}", finalString);
            
            // Print the modified HTML content
            //System.out.println("\nModified HTML:");
            //System.out.println(modifiedHtml);
            
            // Optionally, save the modified HTML to a new file
            //String outputFilePath = "modified_example.html";
            //Files.write(Paths.get(outputFilePath), modifiedHtml.getBytes());
            //System.out.println("\nModified HTML saved to: " + outputFilePath);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return modifiedHtml;
    }
}

