package com.rsjava.autodownloadingreport.controller;

import com.rsjava.autodownloadingreport.service.ReportExcelExporter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/")
public class ReportController {

    private final ReportExcelExporter reportExcelExporter;

    @GetMapping("reports/cars")
    public void getReport(HttpServletResponse response){
        reportExcelExporter.export(response);
    }

}
