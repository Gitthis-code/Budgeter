package com.olivers_budgethanterare.java27.model;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Repository {

    private static final String homeFolder = System.getProperty("user.home");
    private static final Path homePath = Path.of(homeFolder);
    private static final Path savePath = homePath.resolve("Budgeter");

    static void main() throws IOException {

        /*String homeFolder = System.getProperty("user.home");
        Path homePath = Path.of(homeFolder);
        Path savePath = homePath.resolve("java26");

        IO.println(savePath);
        Files.createDirectories(savePath);
        IO.println(Files.exists(savePath));
        IO.println("Is directory: " + Files.isDirectory(savePath));
        IO.println("Is file: " + Files.isRegularFile(savePath));
        Path filePath = savePath.resolve("file.txt");
        IO.println(Files.exists(filePath));
        IO.println("Is directory: " + Files.isDirectory(filePath));
        IO.println("Is file: " + Files.isRegularFile(filePath));
        try {
            Files.createFile(filePath);
        } catch (FileAlreadyExistsException e) {
            IO.println("File " + filePath + " already exists");
        }
        Files.writeString(filePath, "I'm fine åäö ûü");
        */

        IO.println("-------------------");
        createStoragePath("murger");
    }

    public static Path createStoragePath(String user) throws IOException {
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


}
