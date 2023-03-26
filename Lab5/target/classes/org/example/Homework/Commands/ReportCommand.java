package org.example.Homework.Commands;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.example.Homework.Catalog;


import freemarker.template.Configuration;
import org.example.Homework.InvalidDataOrCommandException;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class ReportCommand extends Command{

    private String templatePath;
    private String templateFile;
    private String outputFile;

    public ReportCommand(String templatePath, String templateFile, String outputFile) {
        this.templatePath = templatePath;
        this.templateFile = templateFile;
        this.outputFile = outputFile;
    }

    public String getTemplateFile() {
        return templateFile;
    }

    public void setTemplateFile(String templateFile) {
        this.templateFile = templateFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    /**
     * Creaza un fisier .html ce contine informatiile catalogului
     * @param catalog
     */
    @Override
    public void exeCmd(Catalog catalog) {

        if(catalog.getDocuments().size() == 0)
            throw new InvalidDataOrCommandException("Catalogul nu contine niciun document");

        Configuration configuration = new Configuration();

        try {
            //setez folder-ul unde se afla template-ul
            configuration.setDirectoryForTemplateLoading(new File(templatePath));
            configuration.setDefaultEncoding("UTF-8");
            configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

            //incarc template-ul din fisierul templateFile
            Template template = configuration.getTemplate(templateFile);

            //creez fisier-ul unde va fi report-ul
            Writer writer = new FileWriter(new File(outputFile));

            //creez un map pentru date
            Map<String, Object> input = new HashMap<>();
            input.put("documents", catalog.getDocuments());

            //generez report-ul
            template.process(input, writer);

            //deschid report-ul in browser
            Desktop.getDesktop().browse(new File(outputFile).toURI());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }
}
