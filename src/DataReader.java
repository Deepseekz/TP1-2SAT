import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataReader
{
    public void SatReader(String path) throws IOException {
        int numberOfVars = 0;
        int numberOfClauses  =0;
        String comment = "";
        try {
            for (String line : Files.readAllLines(Paths.get(path))) {
                if (line.startsWith("c"))
                {
                    comment = line.split(" ")[1];
                }
                else if (line.startsWith("p"))
                {
                    numberOfVars = Integer.parseInt(line.split(" ")[2]);
                    numberOfClauses = Integer.parseInt(line.split(" ")[3]);
                }
                else
                {
                    for (String litteral : line.split(" ")) {
                        Integer.parseInt(litteral);
                    }
                }
            }

        }
        catch (IOException exception)
        {
            throw exception;
        }
    }
}
