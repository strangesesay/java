package com.strangeTech.Wirent.Service;
import com.strangeTech.Wirent.Entity.PropertyEntity;
import com.strangeTech.Wirent.Repository.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class PropertyManager implements PropertyService{
        @Autowired
        PropertyRepo propertyRepo;


  @Override
 public PropertyEntity addProperty(PropertyEntity propertyEntity){
     return propertyRepo.save(propertyEntity);
 }


}
