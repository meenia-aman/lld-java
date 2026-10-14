package org.example.models;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.example.enums.NotificationType;

/**
 * Preference
 */
public class Preference {

    private final String id;
    private final String recipientId;
    private boolean globalOptOot;
    private Set<NotificationType> opt_outs = new HashSet<>();

    public Preference(String recipientId) {
        this.id = UUID.randomUUID().toString();
        this.recipientId = recipientId;
    }

    public String getId() {
        return id;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public boolean isGlobalOptOot() {
        return globalOptOot;
    }

    public void setGlobalOptOot(boolean globalOptOot) {
        this.globalOptOot = globalOptOot;
    }

    public Set<NotificationType> getOpt_outs() {
        return opt_outs;
    }

    public void setOpt_outs(Set<NotificationType> opt_outs) {
        this.opt_outs = opt_outs;
    }

    public void addOpt_outs(NotificationType type) {
        this.opt_outs.add(type);
    }
}
