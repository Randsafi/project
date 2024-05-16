package com.Online_Recruitment_System.web.services;

import com.Online_Recruitment_System.web.models.vacant;
import com.Online_Recruitment_System.web.repositories.VacantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class VacantService {
    private VacantRepository VacantRepository;

    public VacantService(com.Online_Recruitment_System.web.repositories.VacantRepository vacantRepository) {
        this.VacantRepository = vacantRepository;
    }

    public List<vacant> getAll(){
        List<vacant> vacants = this.VacantRepository.findAll();
        return  vacants;
    }

    public vacant getOne(Long id){
        Optional<vacant> vacant = Optional.of(this.VacantRepository.getById(id));
        if (vacant.isPresent())
        return  vacant.get();

        return null;
    }
}
