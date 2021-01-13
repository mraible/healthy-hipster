package com.okta.developer.repository;

import com.okta.developer.domain.BloodPressure;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the BloodPressure entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BloodPressureRepository extends JpaRepository<BloodPressure, Long> {
    @Query("select bloodPressure from BloodPressure bloodPressure where bloodPressure.user.login = ?#{principal.preferredUsername}")
    List<BloodPressure> findByUserIsCurrentUser();
}
