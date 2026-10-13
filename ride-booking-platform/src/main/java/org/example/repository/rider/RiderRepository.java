package org.example.repository.rider;

import org.example.models.Rider;

/**
 * RiderRepository
 */
public interface RiderRepository {
    Rider add(Rider d);
    Rider update(Rider d);
    Rider getById(String id);
}
