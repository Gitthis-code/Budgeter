package com.olivers_budgethanterare.java27.model;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import static com.olivers_budgethanterare.java27.model.Transactions.newTransactions;

public class Repository {

    private static final String homeFolder = System.getProperty("user.home");
    private static final Path homePath = Path.of(homeFolder);
    private static final Path savePath = homePath.resolve("Budgeter");

    static void main() throws IOException {

        IO.println("-------------------");
        Path ssss = createFile("murger");
    }

    public static Path checkForFile(String user){
        int nav = 0;

        while(nav != 1 && nav != 2) {
            IO.println("Har filen ett standard namn eller egengjort namn?");
            IO.println("1. Standard");
            IO.println("2. Egengjort");
            try{
                nav = Integer.parseInt(IO.readln());
            }catch(NumberFormatException e){
                nav = 0;
            }
        }

        if(nav == 1){
            Path filePath = savePath.resolve(user + ".txt");
            if(Files.exists(filePath)){
                IO.println("Hittade fil");
                return filePath;
            }
        }
        else{
            String filename = IO.readln("Skriv in namnet på din fil");
            Path filePath = savePath.resolve(filename + ".txt");
            if(Files.exists(filePath)){
                IO.println("Hittade fil");
                return filePath;
            }
        }
        IO.println("Hittade ingen fil med matchande namn");
        return null;

    }


    public static Path createFile(String user) throws IOException {
        Files.createDirectories(savePath);
        int nav = 0;
        Path fileName;
        while (nav != 1 && nav != 2) {
            IO.println("Vill du välja ett eget namn på filen?");
            IO.println("1. Ja");
            IO.println("2. Nej");
            try{
                nav = Integer.parseInt(IO.readln());
            }catch(NumberFormatException e) {
                nav = 0;
            }
        }
        if(nav == 1 ) {
            fileName = createFileWithCustomName();
        }
        else{
            fileName = savePath.resolve(user + ".txt");
            try {
                Files.createFile(fileName);
            } catch (FileAlreadyExistsException e) {
                IO.println("Fil " + fileName + " finns redan");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return fileName;
    }

    private static Path createFileWithCustomName(){
        Path fileName = savePath.resolve(IO.readln() + ".txt");

        try {
            Files.createFile(fileName);
        } catch (FileAlreadyExistsException e) {
            IO.println("Fil " + fileName + " finns redan");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileName;
    }

    public static void insertTransactionsArrayIntoFile(Path filePath) {
        if (newTransactions.getFirst() == null) {

            IO.println("Det finns inga transaktioner att spara");

        }else {

            newTransactions.forEach(transaction ->
            {
                try {
                    Files.writeString(filePath, transaction.toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

        }
    }

}
