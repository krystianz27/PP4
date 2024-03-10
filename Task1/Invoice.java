import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Invoice {

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();

        // Adding items to the list
        items.add(new Item("Clean Code, Robert C. Martin", 100.00, 8));
        items.add(new Item("Applying UML and Patterns, C. Larman", 300.00, 8));
        items.add(new Item("Shipping", 50.00, 23));

        // Calculating the total net amount and VAT sum for each rate
        double totalNetAmountVAT8 = 0;
        double totalNetAmountVAT23 = 0;
        double totalVAT8 = 0;
        double totalVAT23 = 0;

        for (Item item : items) {
            if (item.vatRate == 8) {
                totalVAT8 += item.calculateGrossAmount() - item.netAmount;
                totalNetAmountVAT8 += item.netAmount;
            } else if (item.vatRate == 23) {
                totalVAT23 += item.calculateGrossAmount() - item.netAmount;
                totalNetAmountVAT23 += item.netAmount;
            }
        }

        System.out.println(String.format("%-15s %-15s %-15s", "", "Total netto", "Total VAT"));
        System.out.println("--------------- --------------- ---------------");
        System.out.printf("%-15s %-15.2f %-15.2f\n", "VAT 8%", totalNetAmountVAT8, totalVAT8);
        System.out.printf("%-15s %-15.2f %-15.2f\n", "VAT 8%", totalNetAmountVAT23, totalVAT23);

        // System.out.println("| | Total netto | X |");
        // System.out.println("|--------------|------------|----------|");
        // System.out.printf("| VAT 8%% | %.2f | %.2f |\n", totalNetAmountVAT8,
        // totalVAT8);
        // System.out.printf("| VAT 23%% | %.2f | %.2f |\n", totalNetAmountVAT23,
        // totalVAT23);

        // Markdown Generating
        StringBuilder markdownContent = new StringBuilder();
        markdownContent.append("| | Total netto | Total VAT |\n");
        markdownContent.append("|:--------------|:------------:|:----------:|\n");
        markdownContent
                .append(String.format("| VAT 8%% | %.2f | %.2f |\n", totalNetAmountVAT8,
                        totalVAT8));
        markdownContent
                .append(String.format("| VAT 23%% | %.2f | %.2f |\n", totalNetAmountVAT23,
                        totalVAT23));

        // Save content to .md file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("invoice_output.md"))) {
            writer.write(markdownContent.toString());
            // System.out.println("Markdown file has been created succesfully.");
        } catch (IOException e) {
            System.err.println("An error occured: " +
                    e.getMessage());
        }

        // System.err.println(markdownContent);
    }
}