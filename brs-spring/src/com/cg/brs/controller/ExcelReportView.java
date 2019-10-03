package com.cg.brs.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.cg.brs.dto.Booking;
import com.cg.brs.dto.User;

public class ExcelReportView extends AbstractXlsView {

		
		@Override
		protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception{
			response.setHeader("Content-Disposition", "attachment;filename=\"student.xls\"");
			
			 List<Booking> bookingList = (List<Booking>)model.get("bookingList");
			 Sheet sheet = workbook.createSheet("Booking Data");
			 Row header = sheet.createRow(0);
			 header.createCell(0).setCellValue("Booking ID");
			 header.createCell(1).setCellValue("Date");
			 header.createCell(2).setCellValue("Bus name");
			 header.createCell(3).setCellValue("Mode of Payment");
			 header.createCell(4).setCellValue("Total Cost");
			 header.createCell(5).setCellValue("Status");
			  
			 int rowNum = 1;
			 for(Booking booking:bookingList){
			 Row row = sheet.createRow(rowNum++);
			 row.createCell(0).setCellValue(booking.getBookingId());
			 row.createCell(1).setCellValue(booking.getDateOfJourney().toString());
			 row.createCell(2).setCellValue(booking.getBus().getBusName());
			 row.createCell(3).setCellValue(booking.getModeOfPayment());
			 row.createCell(4).setCellValue(booking.getTotalCost());
			 row.createCell(5).setCellValue(booking.getBookingStatus());
		}

	}

}
