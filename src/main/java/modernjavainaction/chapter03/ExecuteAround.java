package modernjavainaction.chapter03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {
    private static final String FILE = ExecuteAround.class.getResource("./data.txt").getFile();



    public static void main(String[] args) throws IOException {
        String result = processFileLimited();
        System.out.println(result);
        System.out.println("---");
        String oneLine = processFile(BufferedReader::readLine);
        System.out.println(oneLine);
        String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
        System.out.println(twoLines);
    }

    public static String processFileLimited() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE))) {
            return bufferedReader.readLine();
        }
    }

    public static String processFile(BufferedReaderProcessor processor) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE))) {
            return processor.process(bufferedReader);
        }
    }

    public interface BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }
}






