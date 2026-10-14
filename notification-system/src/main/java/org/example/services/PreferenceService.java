package org.example.services;

import org.example.enums.NotificationType;
import org.example.models.Preference;
import org.example.repository.preference.PreferenceRepository;

/**
 * PreferenceService
 */
public class PreferenceService {

    private PreferenceRepository preferenceRepository;

    public PreferenceService(PreferenceRepository preferenceRepository) {
        this.preferenceRepository = preferenceRepository;
    }

    public Preference addPreference(String id, NotificationType type) {
        Preference p = preferenceRepository.getByRecipient(id);

        if (p == null) {
            p = new Preference(id);
        }

        p.addOpt_outs(type);

        preferenceRepository.update(p);

        return p;
    }

    public Preference removePreference(String id, NotificationType type) {
        Preference p = preferenceRepository.getByRecipient(id);
        if (p == null) {
            System.out.println("Preference not found for user with id " + id);
            return null;
        }
        p.getOpt_outs().remove(type);

        return preferenceRepository.update(p);
    }

    public boolean getGlobalOptOutStatus(String id) {
        Preference p = preferenceRepository.getByRecipient(id);
        if (p == null) {
            System.out.println("Preference not found for user with id " + id);
            return false;
        }

        return p.isGlobalOptOot();
    }

    public boolean canSend(String id, NotificationType type) {
        Preference p = preferenceRepository.getByRecipient(id);
        if (p == null) {
            System.out.println("Preference not found for user with id " + id);
            return false;
        }

        if (p.getOpt_outs().contains(type)) return false;
        return true;
    }

    public Preference getById(String id) {
        return preferenceRepository.getByRecipient(id);
    }
}
