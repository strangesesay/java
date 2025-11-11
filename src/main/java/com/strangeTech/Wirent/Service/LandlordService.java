package com.strangeTech.Wirent.Service;

import com.strangeTech.Wirent.Entity.LandlordEntity;

import java.util.List;
import java.util.Optional;

public interface LandlordService {

List<LandlordEntity> findAll();
    Optional<LandlordEntity> findById(Long id);
    LandlordEntity save(LandlordEntity landlord);
    void deleteById(Long id);
}
