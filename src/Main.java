import java.io.*;

/**
 * Created by vitaly on 14.04.16.
 */
public class Main {

    private final static String INPUT_FILE_NAME = "input.txt";
    private final static String OUTPUT_FILE_NAME = "output.txt";

    public static void main(String[] args){

        Digit[] result = new Digit[10];
        char[] keyWord = "onetwotrip".toCharArray();

        String directory = System.getProperty("user.dir");

        File inputFile = new File(String.format("%s/%s", directory, INPUT_FILE_NAME));

        int m, n;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line = br.readLine();

            int trimmer = line.indexOf(' ');
            m = new Integer(line.substring(0, trimmer));
            n = new Integer(line.substring(trimmer+1));

            int lineNumber = 0;
            char currentChar;
            int charCounter = 0;

            while ((line = br.readLine()) != null) {

                for (int i = 0; i < n; ++i){
                    currentChar = line.charAt(i);

                    for (int j = 0; j < 10; ++j){
                        if (keyWord[j] == Character.toLowerCase(currentChar)){
                            result[j] = new Digit(currentChar, lineNumber, i);
                            keyWord[j] = '\n'; //Замещаем невозможным символом
                            ++charCounter;
                            break;
                        }
                    }
                }
                if (charCounter == 10){
                    StringBuilder sb = new StringBuilder();

                    for (int i = 0; i < 10; i++){
                        sb.append(String.format("%s - (%d, %d);\n", result[i].getSymbol(), result[i].getLine(), result[i].getColumn()));
                    }

                    writeResult(directory, sb.toString());
                    return;
                }
                ++lineNumber;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        writeResult(directory, "Impossible");
    }

    public static void writeResult(String directory, String result){

        File output = new File(String.format("%s/%s", directory, OUTPUT_FILE_NAME));

        try(FileOutputStream os = new FileOutputStream(output)) {
            os.write(result.getBytes());
            os.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
