package com.example.laboratorio_3.service.impl;

import com.example.laboratorio_3.domain.dto.request.CreateSpecimenRequest;
import com.example.laboratorio_3.domain.dto.request.UpdateSpecimenRequest;
import com.example.laboratorio_3.domain.dto.response.PageableResponse;
import com.example.laboratorio_3.domain.dto.response.SpecimenResponse;
import com.example.laboratorio_3.domain.entity.Specimen;
import com.example.laboratorio_3.exception.ResourceNotFoundException;
import com.example.laboratorio_3.mapper.SpecimenMapper;
import com.example.laboratorio_3.repository.SpecimenRepository;
import com.example.laboratorio_3.service.SpecimenService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SpecimenServiceImpl implements SpecimenService {

    private final SpecimenRepository specimenRepository;
    private final SpecimenMapper specimenMapper;

    @Override
    @Transactional
    public SpecimenResponse createSpecimen(CreateSpecimenRequest request) {
        Specimen specimen = specimenMapper.toEntityCreate(request);
        Specimen savedSpecimen = specimenRepository.save(specimen);
        return specimenMapper.toDto(savedSpecimen);
    }

    @Override
    public PageableResponse<SpecimenResponse> getAllSpecimens(java.awt.print.Pageable pageable) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public PageableResponse<SpecimenResponse> getAllSpecimens(Pageable pageable) {
        Page<Specimen> specimenPage = specimenRepository.findAll(pageable);
        if (specimenPage.isEmpty()) {
            throw new ResourceNotFoundException("No specimens are registered in Hyrule");
        }
        return specimenMapper.toPageableResponse(specimenPage);
    }

    @Override
    @Transactional(readOnly = true)
    public SpecimenResponse getSpecimenById(UUID id) {
        Specimen specimen = specimenRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Specimen not found in Sheikah Slate records"));
        return specimenMapper.toDto(specimen);
    }

    @Override
    @Transactional
    public SpecimenResponse updateSpecimen(UUID id, UpdateSpecimenRequest request) {
        Specimen existingSpecimen = specimenRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Specimen not found in Sheikah Slate records"));

        if (request.getName() != null) existingSpecimen.setName(request.getName());
        if (request.getRegion() != null) existingSpecimen.setRegion(request.getRegion());
        if (request.getDangerLevel() != null) existingSpecimen.setDangerLevel(request.getDangerLevel());
        if (request.getIsFriendly() != null) existingSpecimen.setIsFriendly(request.getIsFriendly());

        Specimen updatedSpecimen = specimenRepository.save(existingSpecimen);
        return specimenMapper.toDto(updatedSpecimen);
    }

    @Override
    @Transactional
    public void deleteSpecimen(UUID id) {
        if (!specimenRepository.existsById(id)) {
            throw new ResourceNotFoundException("Specimen not found in Sheikah Slate records");
        }
        specimenRepository.deleteById(id);
    }
}

