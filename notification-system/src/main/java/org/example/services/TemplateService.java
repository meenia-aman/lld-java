package org.example.services;

import org.example.dtos.CreateTemplateRequest;
import org.example.models.Template;
import org.example.repository.template.TemplateRepository;

/**
 * TemplateService
 */
public class TemplateService {

    private TemplateRepository templateRepository;

    public TemplateService(TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    Template create(CreateTemplateRequest data) {
        Template t = new Template(
            data.userId(),
            data.name(),
            data.title(),
            data.message(),
            data.type(),
            data.channelType(),
            data.dynamicVariables()
        );

        System.out.println(" Template create successfully ");
        System.out.println("Name : " + t.getName());
        System.out.println("Title : " + t.getTitle());
        System.out.println("Message : " + t.getMessage());
        System.out.println("Type : " + t.getType());
        System.out.println("Channel : " + t.getChannel());

        return templateRepository.add(t);
    }

    Template getTemplateById(String id) {
        return templateRepository.getById(id);
    }
}
