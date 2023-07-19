import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Locker {
    String[] combinations = {"", "", "", "", ""};
    int currentCombination = 0;
    int lockerNumber = 0;
    String[] contents = {""};

    public Locker(int combinationLockerNumber) {
        lockerNumber = combinationLockerNumber;
        int[] combinationNumbers = {0, 0, 0};
        for (int i = 0; i < combinations.length; i++) {
            for (int j = 0; j < 3; j++) {
                Random rand = new Random();
                int combinationNumber = rand.nextInt(50);
                combinationNumbers[j] = combinationNumber;
            }
            combinations[i] = combinationNumbers[0]
                    + "-" + combinationNumbers[1]
                    + "-" + combinationNumbers[2];
        }
    }

    public String getCombination() {
        return combinations[currentCombination];
    }

    public void nextCombination() {
        if (currentCombination == 4) {
            currentCombination = 0;
        } else {
            currentCombination++;
        }
    }

    public void addItem(String content) {
        String[] oldContents = contents;
        contents = new String[oldContents.length + 1];
        contents[0] = content;
        System.arraycopy(oldContents, 0, contents, 1, contents.length - 1);
    }


    public String getContents() {
        String contentsInOneLine = "";
        for (int i = 0; i < contents.length; i++) {
            contentsInOneLine = contents[i] + ", " + contentsInOneLine;
        }
        return contentsInOneLine;
    }

    public void removeItem(String removeContent) {
        for (int i = 0; i < contents.length; i++) {
            if (Objects.equals(contents[i], removeContent)) {
                String[] oldContents = contents;
                contents = new String[oldContents.length - 1];
                int tracker = 0;
                for (int j = 0; j < contents.length; j++) {
                    if (!Objects.equals(oldContents[j], removeContent)) {
                        contents[tracker] = oldContents[j];
                        tracker++;
                    }
                }
            }
        }
    }


    public String toString() {
        String lockerInformation = "Locker: " + lockerNumber;
        String[] ABCDE = {"A: ", "B: ", "C: ", "D: ", "E: "};
        for (int i = 0; i < combinations.length; i++) {
            lockerInformation = lockerInformation + "\n" + ABCDE[i] + combinations[i];
        }
        lockerInformation = lockerInformation + "\nContents: " + getContents();
        return lockerInformation;
    }

}
