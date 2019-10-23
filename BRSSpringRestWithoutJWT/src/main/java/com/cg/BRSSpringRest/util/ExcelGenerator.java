package com.cg.BRSSpringRest.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cg.BRSSpringRest.dto.Booking;
import com.cg.BRSSpringRest.dto.Passenger;

public class ExcelGenerator {

	public static ByteArrayInputStream bookingDetailsToExcel(Booking booking) throws IOException {
		String[] COLUMNs = { "Passenger ID", "Passenger Name", "Passenger Age" };
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			CreationHelper createHelper = workbook.getCreationHelper();

			Sheet sheet = workbook.createSheet("Ticket");

			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());

			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			// Row for Header
			Row headerRow = sheet.createRow(0);

			// Header
			for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(COLUMNs[col]);
				cell.setCellStyle(headerCellStyle);
			}

			// CellStyle for Age
			CellStyle ageCellStyle = workbook.createCellStyle();
			ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));

			List<Passenger> passengerList = booking.getPassengers();

			int rowIdx = 1;
			for (Passenger passenger : passengerList) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue((passenger.getPassengerId()));
				row.createCell(1).setCellValue((passenger.getPassengerName()));
				row.createCell(2).setCellValue((passenger.getPassengerAge()));

			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
}
