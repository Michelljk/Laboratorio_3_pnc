package com.example.laboratorio_3.controller;

import com.example.laboratorio_3.domain.dto.request.CreateSpecimenRequest;
import com.example.laboratorio_3.domain.dto.request.UpdateSpecimenRequest;
import com.example.laboratorio_3.domain.dto.response.GeneralResponse;
import com.example.laboratorio_3.domain.dto.response.PageableResponse;
import com.example.laboratorio_3.domain.dto.response.SpecimenResponse;
import com.example.laboratorio_3.service.SpecimenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/specimens")
@RequiredArgsConstructor
public class SpecimenController {

    private final SpecimenService specimenService;

    @PostMapping
    public ResponseEntity<GeneralResponse<SpecimenResponse>> createSpecimen(
            @Valid @RequestBody CreateSpecimenRequest request,
            HttpServletRequest httpServletRequest) {
        SpecimenResponse response = specimenService.createSpecimen(request);
        return buildResponse("Specimen registered successfully", HttpStatus.CREATED, response, httpServletRequest);
    }

    @GetMapping
    public ResponseEntity<GeneralResponse<PageableResponse<SpecimenResponse>>> getAllSpecimens(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder,
            HttpServletRequest httpServletRequest) {

        Sort sort = sortOrder.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);

        PageableResponse<SpecimenResponse> response = specimenService.getAllSpecimens(pageable);
        return buildResponse("Specimens retrieved successfully", HttpStatus.OK, response, httpServletRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneralResponse<SpecimenResponse>> getSpecimenById(
            @PathVariable UUID id,
            HttpServletRequest httpServletRequest) {
        SpecimenResponse response = specimenService.getSpecimenById(id);
        return buildResponse("Specimen found", HttpStatus.OK, response, httpServletRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneralResponse<SpecimenResponse>> updateSpecimen(
            @PathVariable UUID id,
            @RequestBody UpdateSpecimenRequest request,
            HttpServletRequest httpServletRequest) {
        SpecimenResponse response = specimenService.updateSpecimen(id, request);
        return buildResponse("Specimen updated successfully", HttpStatus.OK, response, httpServletRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GeneralResponse<Void>> deleteSpecimen(
            @PathVariable UUID id,
            HttpServletRequest httpServletRequest) {
        specimenService.deleteSpecimen(id);
        return buildResponse("Specimen deleted successfully", HttpStatus.OK, null, httpServletRequest);
    }

    private <T> ResponseEntity<GeneralResponse<T>> buildResponse(String message, HttpStatus status, T data, HttpServletRequest request) {
        GeneralResponse<T> response = GeneralResponse.<T>builder()
                .message(message)
                .status(status.value())
                .timestamp(LocalDateTime.now())
                .path(request.getRequestURI())
                .data(data)
                .build();
        return new ResponseEntity<>(response, status);
    }
}

