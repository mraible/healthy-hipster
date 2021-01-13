package com.okta.developer.repository;

import com.okta.developer.domain.Weight;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Weight entity.
 */
@SuppressWarnings("unused")
@Repository
public interface WeightRepository extends JpaRepository<Weight, Long> {
    @Query("select weight from Weight weight where weight.user.login = ?#{principal.preferredUsername}")
    List<Weight> findByUserIsCurrentUser();
}
