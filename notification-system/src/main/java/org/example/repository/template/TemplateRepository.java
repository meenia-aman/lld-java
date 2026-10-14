package org.example.repository.template;

import org.example.models.Template;

/**
 * TemplateRepository
 */
public interface TemplateRepository {
    Template add(Template t);
    Template update(Template t);
    Template getById(String id);
}
