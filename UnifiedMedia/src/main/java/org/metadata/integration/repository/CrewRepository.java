package org.metadata.integration.repository;

import org.metadata.integration.model.AccessControl;
import org.metadata.integration.model.Crew;
import org.metadata.integration.model.Metadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrewRepository extends JpaRepository<Crew,Long> {
}
