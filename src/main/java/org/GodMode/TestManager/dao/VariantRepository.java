package org.GodMode.TestManager.dao;

import java.util.List;

import org.GodMode.TestManager.entity.Variant;

public interface VariantRepository {

    public void save(Variant variant);

    public void updateVariant(Variant variant);

    public Variant findVariantById(Long id);

    public List<Variant> fiandAllVariants();

    void remove(Long id);
}
