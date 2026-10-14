package org.example.repository.template;

import java.util.HashMap;
import java.util.Map;
import org.example.models.Template;

/**
 * InMemoryTemplateRepository
 */
public class InMemoryTemplateRepository implements TemplateRepository {

    private Map<String, Template> templates = new HashMap<>();

    @Override
    public Template add(Template t) {
        this.templates.put(t.getId(), t);
        return t;
    }

    @Override
    public Template update(Template t) {
        this.templates.put(t.getId(), t);
        return t;
    }

    @Override
    public Template getById(String id) {
        return this.templates.getOrDefault(id, null);
    }
}
