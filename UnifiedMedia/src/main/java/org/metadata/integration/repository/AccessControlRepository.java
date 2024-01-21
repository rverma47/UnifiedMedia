package org.metadata.integration.repository;

import org.metadata.integration.model.AccessControl;
import java.util.*;
import org.springframework.data.jpa.repository.*;

public interface AccessControlRepository extends JpaRepository<AccessControl,Long> {

}
