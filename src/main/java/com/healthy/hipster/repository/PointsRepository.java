package com.healthy.hipster.repository;

import com.healthy.hipster.domain.Points;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Points entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PointsRepository extends JpaRepository<Points, Long> {

    @Query("select points from Points points where points.user.login = ?#{principal.preferredUsername}")
    List<Points> findByUserIsCurrentUser();

}
