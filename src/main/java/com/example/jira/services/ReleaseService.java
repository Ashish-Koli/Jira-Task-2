package com.example.jira.services;

import com.example.jira.dto.ReleaseDTO;
import com.example.jira.models.Release;
import com.example.jira.models.Sprint;
import com.example.jira.repositories.ReleaseRepository;
import com.example.jira.repositories.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReleaseService {

    @Autowired
    private ReleaseRepository releaseRepository;

    @Autowired
    private SprintRepository sprintRepository;

    public Release createRelease(ReleaseDTO releaseDTO){
        Sprint sprint = sprintRepository.findById(releaseDTO.getSprint()).orElseThrow();
        Release release = new Release();
        release.setReleaseName(releaseDTO.getReleaseName());
        release.setSprint(sprint);
        return releaseRepository.save(release);
    }

    public List<Release> getAllRelease(){
        return releaseRepository.findAll();
    }

    public Release getRelease(int id){
        return releaseRepository.findById(id).orElseThrow();
    }

    public Release updateRelease(ReleaseDTO releaseDTO, int id){
        Release updateRelease = releaseRepository.findById(id).orElseThrow();
        updateRelease.setReleaseName(releaseDTO.getReleaseName());
        Sprint updateSprint = sprintRepository.findById(releaseDTO.getSprint()).orElseThrow();
        updateRelease.setSprint(updateSprint);
        return releaseRepository.save(updateRelease);
    }

    public void deleteRelease(int id){
        releaseRepository.deleteById(id);
    }
}
