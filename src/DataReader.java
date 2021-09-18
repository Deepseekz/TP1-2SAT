import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DataReader {

    public static void SatReader(String path, SatProblem problem)
    {
        try {
            for (String line : Files.readAllLines(Paths.get(path))) {
                SatDatatypeTester(line, problem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void SatDatatypeTester(String line, SatProblem problem)
    {
        if (line.startsWith("c")) {
            problem.appendComment(line.split(" ")[1] + "\n");

        } else if (line.startsWith("p")) {
            problem.setNumberOfVars(Integer.parseInt((line.split(" ")[2])));
            problem.setNumberOfClauses(Integer.parseInt((line.split(" ")[3])));

        } else problem.addClause(SatVarSeparator(line));
    }

    private static ArrayList<Integer> SatVarSeparator(String line)
    {
        ArrayList<Integer> result = new ArrayList<>();
        for (String var : line.split(" "))
        {
            result.add(Integer.parseInt(var));
        }
        return result;
    }

}
