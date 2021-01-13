package com.okta.developer.repository;

import com.okta.developer.domain.Points;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Points entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PointsRepository extends JpaRepository<Points, Long> {
    @Query("select points from Points points where points.user.login = ?#{principal.preferredUsername}")
    List<Points> findByUserIsCurrentUser();
}
