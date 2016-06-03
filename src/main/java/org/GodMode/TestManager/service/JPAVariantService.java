package org.GodMode.TestManager.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.GodMode.TestManager.dao.VariantRepository;
import org.GodMode.TestManager.entity.Variant;

@Service
public class JPAVariantService implements VariantService {

    @Autowired
    private VariantRepository variantRepository;

    @Override
    @Transactional
    public void save(Variant variant) {
        variantRepository.save(variant);
    }

    @Override
    @Transactional
    public void updateVariant(Variant variant) {
        variantRepository.updateVariant(variant);
    }

    @Override
    public Variant findVariantById(Long id) {
        return variantRepository.findVariantById(id);
    }

    @Override
    public List<Variant> fiandAllVariants() {
        return variantRepository.fiandAllVariants();
    }

    @Override
    @Transactional
    public void remove(Long id) {
        variantRepository.remove(id);
    }

}
