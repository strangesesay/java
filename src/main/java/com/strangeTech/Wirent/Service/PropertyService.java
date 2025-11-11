package com.strangeTech.Wirent.Service;
import com.strangeTech.Wirent.Entity.PropertyEntity;
import java.util.List;
import java.util.Optional;


public interface PropertyService  {


    // Retrieve all properties
    List<PropertyEntity> getAllProperty();

    // Find one property by ID
    Optional<PropertyEntity> findPropertiesById(Long id);

    // Find all properties by landlord ID
    List<PropertyEntity> findByLandlordId(Long landlordId);

    // Save or update property
    PropertyEntity addProperty(PropertyEntity property);

    // Delete property by ID
    void deleteById(Long id);

    // Count all properties
    long countProperties();
}
