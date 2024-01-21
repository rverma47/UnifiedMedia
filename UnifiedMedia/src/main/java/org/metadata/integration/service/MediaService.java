package org.metadata.integration.service;

import org.metadata.integration.model.AccessControl;
import org.metadata.integration.model.Crew;
import org.metadata.integration.model.Metadata;
import org.metadata.integration.repository.AccessControlRepository;
import org.metadata.integration.repository.CrewRepository;
import org.metadata.integration.repository.MetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MediaService {

    private final MetadataRepository metadataRepository;
    private final AccessControlRepository accessControlRepository;

    private final CrewRepository crewRepository;



    @Autowired
    public MediaService(MetadataRepository metadataRepository, AccessControlRepository accessControlRepository, CrewRepository crewRepository) {
        this.metadataRepository = metadataRepository;
        this.accessControlRepository = accessControlRepository;
        this.crewRepository = crewRepository;
    }

    public void processMetadata(List<Metadata> metadata) {
        for(Metadata meta:metadata){
            metadataRepository.save(meta); // Save the metadata entity

        }
    }

    public void deleteMetadata(Metadata metadata) {
        metadataRepository.deleteByTitle(metadata.getTitle());
    }

    public void updateMetadata(Metadata metadata) {
        metadataRepository.update(metadata.getRelease_date(),metadata.getDescription(),metadata.getTitle());
    }

    public List<Metadata> getMetadata(String role) {
        List<Metadata> data= metadataRepository.findAll();
        List<String> fieldsToReturn = new ArrayList<String>();
        List<Metadata> output = new ArrayList<Metadata>();

        for(Metadata meta:data){
            Metadata out=new Metadata();
            out.setTitle(meta.getTitle());
            out.setRelease_date(meta.getRelease_date());
            if(role.equalsIgnoreCase("admin")) {
                fieldsToReturn = meta.getAccess_control().getAdmin();
            }else if(role.equalsIgnoreCase("editor")){
                fieldsToReturn = meta.getAccess_control().getEditor();
            }else if(role.equalsIgnoreCase("viewer")){
                fieldsToReturn = meta.getAccess_control().getViewer();
            }
            setfields(meta,out,fieldsToReturn);
            output.add(out);
        }

        return metadataRepository.findAll();
    }

    public void setfields(Metadata meta,Metadata out,List<String> fieldsToReturn){
        if(fieldsToReturn.contains("description")){
            out.setDescription(meta.getDescription());
        }if(fieldsToReturn.contains("cast")){
            out.setCast(meta.getCast());
        }if(fieldsToReturn.contains("crew")){
            out.setCrew(meta.getCrew());
        }if(fieldsToReturn.contains("genres")){
            out.setGenres(meta.getGenres());
        }
    }
}
