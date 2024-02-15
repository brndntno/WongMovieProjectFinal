import java.util.ArrayList;

public class Sort {

    public static void insertionSortWordList(ArrayList<Movie> words) {
        int count = 0;
        for (int j = 1; j < words.size(); j++) {
            Movie temp = words.get(j);
            int possibleIndex = j;
            while (possibleIndex > 0 && temp.getTitle().compareTo(words.get(possibleIndex - 1).getTitle()) < 0) {
                count++;
                words.set(possibleIndex, words.get(possibleIndex - 1));
                possibleIndex--;
            }
            words.set(possibleIndex, temp);
        }
        System.out.println("INSERTION SORT: Number of loop iterations: " + count);
    }

    public static void insertionSortWordList2(ArrayList<String> words) {
        int count = 0;
        for (int j = 1; j < words.size(); j++) {
            String temp = words.get(j);
            int possibleIndex = j;
            while (possibleIndex > 0 && temp.compareTo(words.get(possibleIndex - 1)) < 0) {
                count++;
                words.set(possibleIndex, words.get(possibleIndex - 1));
                possibleIndex--;
            }
            words.set(possibleIndex, temp);
        }
        System.out.println("INSERTION SORT: Number of loop iterations: " + count);
    }

    public static void insertionSortWordList3(ArrayList<Movie> words) {
        int count = 0;
        for (int j = 1; j < words.size(); j++) {
            Movie temp = words.get(j);
            int possibleIndex = j;
            while (possibleIndex > 0 && temp.getTitle().compareTo(words.get(possibleIndex - 1).getTitle()) < 0) {
                count++;
                words.set(possibleIndex, words.get(possibleIndex - 1));
                possibleIndex--;
            }
            words.set(possibleIndex, temp);
        }
        System.out.println("INSERTION SORT: Number of loop iterations: " + count);
    }

}
