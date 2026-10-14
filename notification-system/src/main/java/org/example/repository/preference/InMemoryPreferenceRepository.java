package org.example.repository.preference;

import java.util.HashMap;
import java.util.Map;
import org.example.models.Preference;

/**
 * InMemoryPreferenceRepository
 */
public class InMemoryPreferenceRepository implements PreferenceRepository {

    private Map<String, Preference> preferences = new HashMap<>();

    @Override
    public Preference add(Preference p) {
        this.preferences.put(p.getRecipientId(), p);
        return p;
    }

    @Override
    public Preference update(Preference p) {
        this.preferences.put(p.getRecipientId(), p);
        return p;
    }

    @Override
    public Preference getByRecipient(String id) {
        return this.preferences.getOrDefault(id, null);
    }
}
