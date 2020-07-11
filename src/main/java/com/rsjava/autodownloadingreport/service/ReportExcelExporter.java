package com.rsjava.autodownloadingreport.service;

import com.rsjava.autodownloadingreport.model.Car;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportExcelExporter {
    private final CarService carService;
    private XSSFWorkbook workbook;
    private XSSFSheet sheetCars;
    private XSSFSheet sheetDogs;

    private void writeHeaderRow() {
        String[] columnsHeadings = {"Id", "Marka", "Model", "Kolor", "Czy jest używany", "Data produkcji"};

        //styl komórek
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);

        //rząd nagłówkowy o indeksie zero
        Row headerRow = sheetCars.createRow(0);

        //wpisuje nazyy do rzędu nagówkowego i uzupełniam style
        for (int i = 0; i < columnsHeadings.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columnsHeadings[i]);
            cell.setCellStyle(headerCellStyle);
        }
        for (int i = 0; i < columnsHeadings.length; i++) {
            sheetCars.autoSizeColumn(i);
        }
    }

    private void writeDataRows() {
        List<Car> carList = carService.getCars();
        //indeks 2 wiersza
        int rowNum = 1;

        //iteruję sie po liście i zapisuję poszczególne obiekty w kolejne komórki,
        //za każdą iteracją wiersz schodzi o jeden niżej
        for (Car car : carList) {
            Row row = sheetCars.createRow(rowNum ++);

            //kolumna zero w pierwszuym wierszu
            row.createCell(0).setCellValue(car.getId());
            //kolumna 2
            row.createCell(1).setCellValue(car.getBrand());
            row.createCell(2).setCellValue(car.getModel());
            row.createCell(3).setCellValue(car.getColor());
            row.createCell(4).setCellValue(car.getIsUsed());
            row.createCell(5).setCellValue(getFormattedDate(car.getBuildDate()));
            for (int i = 0; i < 6; i++) {
                sheetCars.autoSizeColumn(i);
            }
        }
    }

    public void export(HttpServletResponse response) {
        String fileName = "cars.xlsx";

        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachement; filename=" + fileName;
        response.setHeader(headerKey, headerValue);

        workbook = new XSSFWorkbook();
        sheetCars = workbook.createSheet("Cars");
        sheetDogs = workbook.createSheet("Dogs");

        writeHeaderRow();
        writeDataRows();

        try {
            ServletOutputStream outputStream = response.getOutputStream();
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private String getFormattedDate(LocalDate localDate){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateTimeFormatter.format(localDate);
    }
}
