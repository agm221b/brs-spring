package com.cg.BRSSpringRest.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cg.BRSSpringRest.dto.Booking;
import com.cg.BRSSpringRest.dto.Passenger;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePdfReport {
	
	private static final Logger logger = LoggerFactory.getLogger(GeneratePdfReport.class);

    public static ByteArrayInputStream bookingReport(Booking booking) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
        	
        	PdfPTable bookingTable=new PdfPTable(5);
        	bookingTable.setWidthPercentage(100);
        	bookingTable.setWidths(new int[] {2,2,2,2,2});
        	
        	Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        	PdfPCell hcell;
        	PdfPCell cell;
        	
        	hcell = new PdfPCell(new Phrase("Booking Id", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            bookingTable.addCell(hcell);
        	
            hcell = new PdfPCell(new Phrase("Date Of Journey", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            bookingTable.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Mode Of Payment", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            bookingTable.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Total Cost", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            bookingTable.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Booking Status", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            bookingTable.addCell(hcell);
            
            cell = new PdfPCell(new Phrase(booking.getBookingId().toString()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            bookingTable.addCell(cell);
            
            cell = new PdfPCell(new Phrase(booking.getDateOfJourney().toString()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            bookingTable.addCell(cell);
            
            cell = new PdfPCell(new Phrase(booking.getModeOfPayment().toString()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            bookingTable.addCell(cell);
            
            cell = new PdfPCell(new Phrase(booking.getTotalCost().toString()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            bookingTable.addCell(cell);
            
            cell = new PdfPCell(new Phrase(booking.getBookingStatus().toString()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            bookingTable.addCell(cell);
            
            bookingTable.setSpacingBefore(50);
            bookingTable.setSpacingAfter(50);
            
            PdfPTable busTable = new PdfPTable(8);
            busTable.setWidthPercentage(100);
            busTable.setWidths(new int[]{2,2,2,2,2,2,2,2});
            
            hcell = new PdfPCell(new Phrase("Bus Id", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            busTable.addCell(hcell);
        	
            hcell = new PdfPCell(new Phrase("Bus Name", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            busTable.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Bus Type", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            busTable.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Bus Class", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            busTable.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Source", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            busTable.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Destination", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            busTable.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Departure Time", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            busTable.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Arrival Time", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            busTable.addCell(hcell);
            
            cell = new PdfPCell(new Phrase(booking.getBus().getBusId().toString()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            busTable.addCell(cell);
            
            cell = new PdfPCell(new Phrase(booking.getBus().getBusName().toString()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            busTable.addCell(cell);
            
            cell = new PdfPCell(new Phrase(booking.getBus().getBusType().toString()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            busTable.addCell(cell);
            
            cell = new PdfPCell(new Phrase(booking.getBus().getBusClass().toString()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            busTable.addCell(cell);
            
            cell = new PdfPCell(new Phrase(booking.getBus().getSource().toString()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            busTable.addCell(cell);
            
            cell = new PdfPCell(new Phrase(booking.getBus().getDestination().toString()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            busTable.addCell(cell);
            
            cell = new PdfPCell(new Phrase(booking.getBus().getStartTime().toString()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            busTable.addCell(cell);
            
            cell = new PdfPCell(new Phrase(booking.getBus().getEndTime().toString()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            busTable.addCell(cell);

            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setWidths(new int[]{3,3,3,3});

            
            hcell = new PdfPCell(new Phrase("Passenger Id", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Passenger Name", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Passenger Age", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Passenger Gender", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);            

            for (Passenger passenger : booking.getPassengers()) {

                cell = new PdfPCell(new Phrase(passenger.getPassengerId().toString()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(passenger.getPassengerName()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(passenger.getPassengerAge().toString()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setPaddingRight(5);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(passenger.getPassengerGender().toString()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setPaddingRight(5);
                table.addCell(cell);
                
            }
            
            table.setSpacingBefore(50);
            table.setSpacingAfter(50);
            
            
            
            PdfWriter.getInstance(document, out);
            document.open();
            document.addTitle("Booking Details for Booking Id "+booking.getBookingId());
            Paragraph paragraph=new Paragraph("Booking Details");
            paragraph.setAlignment(20);
            document.add(paragraph);
            document.add(bookingTable);
            document.add(busTable);
            document.add(table);

            document.close();

        } catch (DocumentException ex) {

            logger.error("Error occurred: {0}", ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

}
