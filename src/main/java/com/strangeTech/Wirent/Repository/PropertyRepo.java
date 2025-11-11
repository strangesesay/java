package com.strangeTech.Wirent.Repository;

import com.strangeTech.Wirent.Entity.PropertyEntity;
import org.hibernate.mapping.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepo extends JpaRepository<Property, Long> {
    List<PropertyEntity> findByLandlordId(Long landlordId);
}
