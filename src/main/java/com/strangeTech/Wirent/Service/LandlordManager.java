package com.strangeTech.Wirent.Service;


import com.strangeTech.Wirent.Entity.LandlordEntity;
import com.strangeTech.Wirent.Repository.LandlordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LandlordManager implements LandlordService {

    @Autowired
    LandlordRepo landlordRepo;




}
