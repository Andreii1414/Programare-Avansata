package org.example.Homework;

import org.example.Homework.Commands.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Catalog catalog = new Catalog();

        Document doc1 =
                new Document("D1", "Text Document", "C:\\Users\\andrei14\\Documents\\test.txt",
                        Stream.of(
                                new Tag("Titlu", "A"),
                                new Tag("An", "2023")
                        ).collect(Collectors.toList()), true);

        Document doc2 =
                new Document("D2", "What kind of creatures are we?", "https://ro.scribd.com/book/470859969/What-Kind-of-Creatures-Are-We",
                        Stream.of(
                                new Tag("Autor", "Noam Chomsky"),
                                new Tag("An", "2015")
                        ).collect(Collectors.toList()), false);

        Command addCmd = new AddCommand(doc1);
        addCmd.exeCmd(catalog);
        ((AddCommand) addCmd).setDocument(doc2);
        addCmd.exeCmd(catalog);

        Command toStringCmd = new ToStringCommand();
        toStringCmd.exeCmd(catalog);

        System.out.println();

        Command saveCmd = new SaveCommand("catalog.json");
        saveCmd.exeCmd(catalog);

        Command loadCmd = new LoadCommand("catalog.json");
        loadCmd.exeCmd(catalog);

        Command listCmd = new ListCommand();
        listCmd.exeCmd(catalog);

        Command viewCmd = new ViewCommand("D2");
        viewCmd.exeCmd(catalog);

        Command reportCmd = new ReportCommand("C:\\Users\\andrei14\\Desktop\\PA\\Lab5\\Templates","report_template.ftl", "report.html");
        reportCmd.exeCmd(catalog);

        //java -jar C:\Users\andrei14\Desktop\PA\Lab5\out\artifacts\Lab5_jar\Lab5.jar
    }
}