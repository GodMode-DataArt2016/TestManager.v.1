package org.GodMode.TestManager.service;

import org.GodMode.TestManager.entity.Variant;

import java.util.List;

public interface VariantService {

    public void save(Variant variant);

    public void updateVariant(Variant variant);


    public Variant findVariantById(Long id);

    public List<Variant> fiandAllVariants();

    void remove(Long id);
}
