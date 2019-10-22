package com.cg.BRSSpringRest.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.BRSSpringRest.dto.Booking;
import com.cg.BRSSpringRest.dto.Passenger;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class TicketGeneratorService {
	
	@Autowired
	BRSService brsService;
	
	private String FILE;
	Integer bookingId;
	
	public String generate(Integer bookingId) throws FileNotFoundException, DocumentException {
		this.bookingId=bookingId;
		Document document=new Document();
		FILE="eTickets/FRSticket"+bookingId+".pdf";
		PdfWriter.getInstance(document, new FileOutputStream(FILE));
		document.open();
		addMetaData(document);
		addContent(document);
		document.close();
		return FILE;
	}
	
	private void addMetaData(Document document) {
		document.addTitle("FRS E-Ticket");
		document.addAuthor("FRS App");
	}
	
	private void addContent(Document document) throws DocumentException {
		Booking booking=brsService.findBookingById(bookingId);
		Paragraph paragraph=new Paragraph("FRS ETicket: "+bookingId);
		PdfPTable table=new PdfPTable(2);
		table.addCell("Booking Id:");
		table.addCell(""+booking.getBookingId());
		table.addCell("Booking Date:");
		table.addCell(""+booking.getDateOfJourney());
		table.addCell("Booking Cost:");
		table.addCell(""+booking.getTotalCost());
		table.addCell("Booking Status: ");
		table.addCell(""+booking.getTotalCost());
		
		table.addCell("Bus Id:");
		table.addCell(""+booking.getBus().getBusId());
		table.addCell("Bus Name: ");
		table.addCell(""+booking.getBus().getBusName());
		table.addCell("Bus Class: ");
		table.addCell(""+booking.getBus().getBusClass());
		table.addCell("Bus Type:");
		table.addCell(""+booking.getBus().getBusType());
		table.addCell("Arrival Time:");
		table.addCell(""+booking.getBus().getStartTime());
		table.addCell("Departure Time:");
		table.addCell(""+booking.getBus().getEndTime());
		table.addCell("Source:");
		table.addCell(""+booking.getBus().getSource());
		table.addCell("Destination:");
		table.addCell(""+booking.getBus().getDestination());
		paragraph.add(table);
		document.add(paragraph);
		paragraph=new Paragraph("Passenger Details: ");
		for(Passenger passenger: booking.getPassengers()) {		
			table=new PdfPTable(2);
			table.addCell("Passenger Id:");
			table.addCell(""+passenger.getPassengerId());
			table.addCell("Passenger Name:");
			table.addCell(""+passenger.getPassengerName());
			table.addCell("Passenger Age:");
			table.addCell(""+passenger.getPassengerAge());
			table.addCell("Passenger Gender:");
			table.addCell(""+passenger.getPassengerGender());
			paragraph.add(table);
		}
		document.add(paragraph);
	}

}
