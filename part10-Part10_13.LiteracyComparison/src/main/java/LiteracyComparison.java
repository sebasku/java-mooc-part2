
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        try {
            list = Files.lines(Paths.get("literacy.csv"))
                    .map(row -> row.split(","))
                    .sorted((row1, row2) -> {return Double.valueOf(row1[5]).compareTo(Double.valueOf(row2[5]));})
                    .map(parts -> parts[3] + " (" + parts[4] + ")" + "," + parts[2].replace(" (%)", "") + ", " + parts[5])
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            Logger.getLogger(LiteracyComparison.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.stream().forEach(row -> System.out.println(row));
    }
}
