package com.infrutious.springmvc.logic;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelParser {

	public static void main(String[] args) {
		List<List<String>> data = parse("C:\\Users\\manikanta\\Desktop\\Drools Excels\\Company.xlsx");
		System.out.println(data);
	}

	public static List<List<String>> parse(String fileName) {
		System.out.println("File Name :"+fileName);
		List<List<String>> data = new ArrayList<List<String>>();
		try {
			InputStream inStream = new FileInputStream(fileName);
			data = parse(inStream);
		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
		return data;
	}
	
	public static List<List<String>> parse(InputStream inStream) {
		List<List<String>> data = new ArrayList<List<String>>();
		try {
			Workbook wb = WorkbookFactory.create(inStream);
			Sheet sheet = wb.getSheetAt(0);
			Row row;
			Cell cell;

			int rows; // No of rows
			rows = sheet.getPhysicalNumberOfRows();

			int cols = 0; // No of columns
			int tmp = 0;

			// This trick ensures that we get the data properly even if it
			// doesn't start from first few rows
			for (int i = 0; i < 10 || i < rows; i++) {
				row = sheet.getRow(i);
				if (row != null) {
					tmp = sheet.getRow(i).getPhysicalNumberOfCells();
					if (tmp > cols)
						cols = tmp;
				}
			}

			for (int r = 0; r < rows; r++) {
				List<String> dataRow = new ArrayList<String>();
				row = sheet.getRow(r);
				if (row != null) {
					for (int c = 0; c < cols; c++) {
						cell = row.getCell((short) c);
						if (cell != null) {
							// Your code here
							cell.setCellType(1);
							System.out.print(cell + "\t");
							dataRow.add(cell.toString());
						}
					}
					System.out.println();
					data.add(dataRow);
				}
			}
		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
		return data;
	}
}
