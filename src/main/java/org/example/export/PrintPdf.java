package org.example.export;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import org.example.entity.Purchase;

import java.time.format.DateTimeFormatter;

public class PrintPdf {

    public static void printPurchaseToPdf(Purchase purchase) {
        String filePath = "/Users/tonkata1505/projects/transport_company/src/main/resources/purchase" + purchase.getId() + ".pdf";

        try (PdfWriter writer = new PdfWriter(filePath)) {

            try (PdfDocument pdf = new PdfDocument(writer)) {

                try (Document document = new Document(pdf)) {

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    Paragraph title = new Paragraph("Purchase #" + purchase.getId())
                            .setFontSize(18)
                            .setBold()
                            .setTextAlignment(TextAlignment.CENTER);

                    document.add(title);

                    document.add(new Paragraph("Arrival point: " + purchase.getArrivalPlace()));

                    document.add(new Paragraph("Departure point: " + purchase.getDeparturePlace()));

                    document.add(new Paragraph("Start time: " + purchase.getStartTime().format(formatter)));

                    document.add(new Paragraph("End time: " + purchase.getEndTime().format(formatter)));

                    document.add(new Paragraph("Price: " + purchase.getPrice()));

                    document.add(new Paragraph("Driver: " + purchase.getEmployee().getFirstName() + " " + purchase.getEmployee().getLastName()));

                    document.add(new Paragraph("Company: " + purchase.getCompany().getCompanyName()));

                }
            }
            System.out.println("PDF created successfully at: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
