package com.c823.consorcio.controller;

import com.c823.consorcio.enums.Issue;
import com.c823.consorcio.service.IReportService;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import com.c823.consorcio.dto.ReportDTO;
import com.c823.consorcio.entity.ReportEntity;
import com.c823.consorcio.service.Impl.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
//@CrossOrigin(origins = "aca va la url local")
public class ReportController {
    @Autowired
    private IReportService reportService;

    @PostMapping("/create")
    public ResponseEntity<ReportDTO> createReport(@RequestBody ReportDTO reportDTO){
        ReportDTO report = this.reportService.saveReport(reportDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(report);
    }



}
