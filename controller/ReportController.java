package com.example.laundry.controller;

import com.example.laundry.model.Report;
import com.example.laundry.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReportController {

    private final ReportService ReportService;

    @Autowired
    public ReportController(ReportService ReportService) {
        this.ReportService = ReportService;
    }

    @PostMapping("/Reports")
    public ResponseEntity<Report> createReport(@Valid @RequestBody Report Report) {
        Report createdReport = ReportService.saveReport(Report);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReport);
    }

    @GetMapping("/Reports")
    public ResponseEntity<List<Report>> getAllReports() {
        List<Report> Reports = ReportService.getAllReports();
        return ResponseEntity.ok(Reports);
    }

    @GetMapping("/Reports/{id}")
    public ResponseEntity<Optional<Report>> getReportById(@PathVariable(value = "id") Long id) {
        Optional<Report> Report = ReportService.getReportById(String.valueOf(id));
        if (Report.isPresent()) {
            return ResponseEntity.ok(Report);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/Reports/{id}")
    public ResponseEntity<Report> updateReport(@PathVariable(value = "id") Long id, @RequestBody Report ReportDetails) {
        Report updatedReport = ReportService.updateReport(String.valueOf(id), ReportDetails);
        return ResponseEntity.ok(updatedReport);
    }

    @DeleteMapping("/Reports/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable(value = "id") Long id) {
        ReportService.deleteReport(String.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}
