package org.metadata.integration.controller;

import org.metadata.integration.model.Metadata;
import org.metadata.integration.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MediaController {
    private final MediaService mediaService;

    @Autowired
    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @PostMapping("/ingest")
    public ResponseEntity<String> ingestMetadata(@RequestBody List<Metadata> metadata) {
        mediaService.processMetadata(metadata);
        return new ResponseEntity<>("Saved", HttpStatus.CREATED);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteMetadata(@RequestBody Metadata metadata) {
        mediaService.deleteMetadata(metadata);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateMetadata(@RequestBody Metadata metadata) {
        mediaService.updateMetadata(metadata);
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }

    @GetMapping("/retrieve")
    public ResponseEntity<List<Metadata>> getMetadata(@RequestParam String role) {
        List<Metadata> out=mediaService.getMetadata(role);
        return new ResponseEntity<>(out, HttpStatus.OK);
    }
}
