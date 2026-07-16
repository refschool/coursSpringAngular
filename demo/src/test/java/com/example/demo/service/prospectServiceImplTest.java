package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.example.demo.entities.commercial;
import com.example.demo.entities.prospect;
import com.example.demo.repository.commercialRepository;
import com.example.demo.repository.prospectRepository;

class prospectServiceImplTest {

    @Test
    void updateProspect_shouldReloadExistingEntityAndApplyChanges() {
        prospectRepository prospectRepository = mock(prospectRepository.class);
        commercialRepository commercialRepository = mock(commercialRepository.class);
        prospectServiceImpl service = new prospectServiceImpl(prospectRepository, commercialRepository);

        prospect existing = new prospect();
        existing.setIdProspect(7);
        existing.setNom("Ancien nom");

        commercial commercialEntity = new commercial();
        commercialEntity.setIdCommercial(1);

        prospect incoming = new prospect();
        incoming.setIdProspect(7);
        incoming.setNom("Nouveau nom");
        incoming.setCommercial(commercialEntity);

        when(prospectRepository.findById(7)).thenReturn(Optional.of(existing));
        when(commercialRepository.findById(1)).thenReturn(Optional.of(commercialEntity));
        when(prospectRepository.save(any(prospect.class))).thenAnswer(invocation -> invocation.getArgument(0));

        prospect result = service.updateprospect(incoming);

        assertEquals("Nouveau nom", result.getNom());
        assertEquals(commercialEntity, result.getCommercial());
        verify(prospectRepository).findById(7);
        verify(prospectRepository).save(existing);
    }
}
