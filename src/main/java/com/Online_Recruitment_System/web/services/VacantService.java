package com.Online_Recruitment_System.web.services;

import com.Online_Recruitment_System.web.dtos.CreateVacantDto;
import com.Online_Recruitment_System.web.dtos.FilterVacantDto;
import com.Online_Recruitment_System.web.dtos.UpdateVacantDto;
import com.Online_Recruitment_System.web.models.vacant;
import com.Online_Recruitment_System.web.repositories.VacantRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class VacantService {
    private final VacantRepository VacantRepository;
    private ModelMapper modelMapper;
    private EntityManager em;

    public VacantService(com.Online_Recruitment_System.web.repositories.VacantRepository vacantRepository, EntityManager em) {
        VacantRepository = vacantRepository;
//        this.modelMapper = modelMapper;      ModelMapper modelMapper,
        this.em = em;
    }

    @Autowired
    public VacantService(VacantRepository vacantRepository) {
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

    public  void create(CreateVacantDto createVacantDto){//createVacantDto.namecompany,
        vacant vacant=new vacant(
                createVacantDto.jobType,
                createVacantDto.numberYearsExperience,
                createVacantDto.workPlace,
                createVacantDto.holidays
                );
        this.VacantRepository.save(vacant);
    }

//    public List<vacant> getByJobType(String JobType){return this.VacantRepository.findByJobTypeContaining(jobType);}

    public List<vacant> filter(FilterVacantDto filterV) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<vacant> query = criteriaBuilder.createQuery(vacant.class);

        Root<vacant> root = query.from(vacant.class);

        List<Predicate> predicates= new ArrayList<Predicate>();

      if (filterV.namecompany.isPresent() && !filterV.namecompany.get().isEmpty())
          predicates.add(
                  criteriaBuilder.like(root.get("namecompany"),
                          "%" + filterV.namecompany.get() + "%")
          );

        if (filterV.job_type.isPresent() && !filterV.job_type.get().isEmpty())
            predicates.add(
                    criteriaBuilder.like(root.get("jobtype"),
                            "%" + filterV.job_type.get() + "%")
            );

        if (filterV.work_place.isPresent() && !filterV.work_place.get().isEmpty())
            predicates.add(
                    criteriaBuilder.like(root.get("work_place"),
                            "%" + filterV.work_place.get() + "%")
            );



        query.where(predicates.toArray(new Predicate[predicates.size()]));

        return em.createQuery(query).getResultList();

    }

    public void update(Long id, UpdateVacantDto updateVacantDto) {
        vacant vacant=this.modelMapper.map(updateVacantDto,vacant.class);
        vacant.setId(id);
        this.VacantRepository.save(vacant);
    }

    public void delete(Long id) {
        this.VacantRepository.deleteById(id);
    }
}
