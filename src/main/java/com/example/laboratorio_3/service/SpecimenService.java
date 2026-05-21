package com.example.laboratorio_3.service;


import com.example.laboratorio_3.domain.dto.request.CreateSpecimenRequest;
import com.example.laboratorio_3.domain.dto.request.UpdateSpecimenRequest;
import com.example.laboratorio_3.domain.dto.response.PageableResponse;
import com.example.laboratorio_3.domain.dto.response.SpecimenResponse;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.UUID;

public interface SpecimenService {
    SpecimenResponse createSpecimen(CreateSpecimenRequest request);
    PageableResponse<SpecimenResponse> getAllSpecimens(Pageable pageable);

    @Transactional(readOnly = true)
    PageableResponse<SpecimenResponse> getAllSpecimens(org.springframework.data.domain.Pageable pageable);

    SpecimenResponse getSpecimenById(UUID id);
    SpecimenResponse updateSpecimen(UUID id, UpdateSpecimenRequest request);
    void deleteSpecimen(UUID id);
}