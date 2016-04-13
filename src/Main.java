import java.io.*;

/**
 * Created by vitaly on 14.04.16.
 */
public class Main {

    private final static String FILE_NAME = "input.txt";

    public static void main(String[] args){

        Digit[] result = new Digit[10];
        char[] keyWord = "onetwotrip".toCharArray();

        String directory = System.getProperty("user.dir");

        File inputFile = new File(String.format("%s/%s", directory, FILE_NAME));

        int m, n;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line = br.readLine();

            int trimer = line.indexOf(' ');
            m = new Integer(line.substring(0, trimer));
            n = new Integer(line.substring(trimer+1));

            int lineNumber = 0;
            char currentChar;
            int charCounter = 0;

            while ((line = br.readLine()) != null) {

                for (int i = 0; i < n; ++i){
                    currentChar = line.charAt(i);

                    for (int j = 0; j < 10; ++j){
                        if (keyWord[j] == Character.toLowerCase(currentChar)){
                            result[j] = new Digit(currentChar, lineNumber, i);
                            keyWord[j] = '\n';
                            ++charCounter;
                            break;
                        }
                    }
                }
                if (charCounter == 10){
                    break;
                }

                ++lineNumber;

            }

            for (int i = 0; i < 10; i++){
                System.out.println(String.format("%s - (%d, %d);", result[i].getSymbol(), result[i].getLine(), result[i].getColumn()));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Impossible");

    }

}
