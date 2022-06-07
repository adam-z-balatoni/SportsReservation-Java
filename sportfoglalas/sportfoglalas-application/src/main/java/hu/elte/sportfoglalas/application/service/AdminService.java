package hu.elte.sportfoglalas.application.service;

import hu.elte.sportfoglalas.application.webdomain.CourtDTO;
import hu.elte.sportfoglalas.domain.Coach;
import hu.elte.sportfoglalas.domain.Court;
import hu.elte.sportfoglalas.domain.SportCategory;
import hu.elte.sportfoglalas.repository.CoachRepository;
import hu.elte.sportfoglalas.repository.CourtRepository;
import hu.elte.sportfoglalas.repository.SportCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired private CourtRepository courtRepository;
    @Autowired private SportCategoryRepository sportCategoryRepository;
    @Autowired private CoachRepository coachRepository;


    public Iterable<SportCategory> findAllSportCategories() {
        return sportCategoryRepository.findAll();
    }


    public void save(Court court) {
        courtRepository.save(court);
    }

    public void convertToCourt(CourtDTO courtDTO) {
        Court court = new Court();
        court.setName(courtDTO.getName());

        Iterable<SportCategory> sportCategories = findAllSportCategories();
        for (SportCategory s : sportCategories) {
            if (s.getName().equals(courtDTO.getSport())) {
                court.setSportCategory(s);
            }
        }
        save(court);
    }

    public List<Coach> findAllCoaches() {
        return (List<Coach>) coachRepository.findAll();
    }

    public void modifyCoach(Integer id) {
        Coach coach = findCoachById(id);
        coach.setAvailable(!coach.isAvailable());
        coachRepository.save(coach);
    }

    private Coach findCoachById(Integer id) {
        return coachRepository.findById(id).get();
    }
}
