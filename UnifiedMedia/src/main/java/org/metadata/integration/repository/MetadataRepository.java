package org.metadata.integration.repository;

import org.metadata.integration.model.Metadata;
import java.util.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import javax.transaction.*;

public interface MetadataRepository extends JpaRepository<Metadata,Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Metadata e WHERE e.title = :title")
    void deleteByTitle(@Param("title") String title);

    @Transactional
    @Modifying
    @Query("update Metadata e SET e.release_date = :rdate, e.description = : desc WHERE e.title = :title")
    void update(@Param("rdate") String rdate, @Param("desc") String desc, @Param("title") String title);
}
