package test;

import java.io.*;
import static java.lang.System.*;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException {
        out.println("Répertoire courant : " + System.getProperty("user.dir"));
        File rep = new File(".");
        out.println("Chemin relatif : " + rep.getPath());
        out.println("Chemin absolu : " + rep.getCanonicalPath());

        File[] roots = File.listRoots();
        for (File root : roots) {
            out.println("Racine : " + root);
        }

        File[] directories = rep.listFiles(File::isDirectory);
        out.println("Liste des répertoires qui existent dans le répertoire courant:");
        
        
        for (File directory : directories) {
            out.println(directory.getName());
        }

        File[] files = rep.listFiles(File::isFile);
        out.println("Liste des fichiers qui existent dans le répertoire courant:");
        for (File file : files) {
            out.print(file.getName() + "\t");
            if (file.getName().length() < 8) out.print("\t");
            out.printf("%tc\t%10d octets\n", new Date(file.lastModified()), file.length());
        }

        // Affichage des répertoires commençant par la lettre 'b'
        out.println("Liste des répertoires commençant par la lettre 'b':");
        File[] filteredDirectories = rep.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.startsWith("b");
            }
        });
        for (File dir : filteredDirectories) {
            out.println(dir.getName());
        }
    }
}
