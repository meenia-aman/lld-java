package org.example.repository.preference;

import org.example.models.Preference;

/**
 * PreferenceRepository
 */
public interface PreferenceRepository {
    Preference add(Preference p);
    Preference update(Preference p);
    Preference getByRecipient(String id);
}
