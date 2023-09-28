import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Application {

    private final String path = ".\\WebinarP2\\src\\resources\\";

    //surchargé expetion
    static class checkFilesExceptions extends Exception {
        checkFilesExceptions(String s) {
            super(s);
        }
    }

    static void checkLine(String file) throws checkFilesExceptions {
        if(file == null) {
            throw new checkFilesExceptions("Le fichier est vide");
        } else {
            System.out.println(file);
        }
    }

    public void readFile()  {
        //Remplacer le nom du fichier à lire ici
        String fileToRead = "emptyFile";
        String completePath  = path + fileToRead;

        try{
            // Création d'un fileReader pour lire le fichier
            FileReader fileReader = new FileReader(completePath);
            // Création d'un bufferedReader qui utilise le fileReader
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            checkLine(line);
        } catch (checkFilesExceptions | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        Application application = new Application();
        application.readFile();
    }
}
