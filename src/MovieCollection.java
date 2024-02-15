import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class MovieCollection {


    private ArrayList<Movie> movieCollection;
    private Scanner scan;


    public MovieCollection() {
        movieCollection = new ArrayList<>();
        scan = new Scanner(System.in);
        readData();
        start();
    }


    public void start() {
        System.out.println("Welcome to the movie collection!");
        String menuOption = "";


        while (!menuOption.equals("q")) {
            System.out.println("------------ Main Menu ----------");
            System.out.println("- search (t)itles");
            System.out.println("- search (c)ast");
            System.out.println("- (q)uit");
            System.out.print("Enter choice: ");
            menuOption = scan.nextLine();


            if (menuOption.equals("t")) {
                searchTitles();
            } else if (menuOption.equals("c")) {
                searchCast();
            } else if (menuOption.equals("q")) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }


    private void readData() {
        try {
            File myFile = new File("src//movies_data.csv");
            Scanner fileScanner = new Scanner(myFile);
            fileScanner.nextLine();
            while (fileScanner.hasNext()) {
                String data = fileScanner.nextLine();
                String[] splitData = data.split(",");
                String title = splitData[0];
                String cast = splitData[1];
                String director = splitData[2];
                String overview = splitData[3];
                int runtime = Integer.parseInt(splitData[4]);
                double userRating = Double.parseDouble(splitData[5]);
                Movie movie = new Movie(title, cast, director, overview, runtime, userRating);
                movieCollection.add(movie);
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }


    public void searchTitles() {
        String search = "";
        int movieNum = 0;
        ArrayList<Movie> matches = new ArrayList<>();
        System.out.print("Enter a title search term: ");
        search = scan.nextLine();
        for (int i = 0; i < movieCollection.size(); i++) {
            if (movieCollection.get(i).getTitle().toLowerCase().contains(search)) {
                matches.add(movieCollection.get(i));
            }
        }
        if (matches.size() == 0) {
            System.out.println("No movie titles match that search term!");
            start();
        } else {
            Sort.insertionSortWordList(matches);
            for (int i = 0; i < matches.size(); i++) {
                System.out.println((i + 1) + ". " + matches.get(i).getTitle());
            }
        }
        System.out.println("Which movie would you like to learn more about?");
        System.out.print("Enter a number: ");
        movieNum = scan.nextInt();
        scan.nextLine();
        System.out.println("Title: " + matches.get(movieNum - 1).getTitle() + "\n" +
                "Runtime: " + matches.get(movieNum - 1).getRuntime() + "\n" +
                "Directed by: " + matches.get(movieNum - 1).getDirector() + "\n" +
                "Cast: " + matches.get(movieNum - 1).getCast() + "\n" +
                "Overview: " + matches.get(movieNum - 1).getOverview() + "\n" +
                "User rating: " + matches.get(movieNum - 1).getUserRating());
    }


    public void searchCast() {
        String search = "";
        int answer = 0;
        int movieNum = 0;
        ArrayList<String> matches = new ArrayList<>();
        ArrayList<Movie> movieMatches = new ArrayList<>();
        System.out.print("Enter a person to search for (first or last name): ");
        search = scan.nextLine();
        for (int i = 0; i < movieCollection.size(); i++) {
            if (movieCollection.get(i).getCast().toLowerCase().contains(search)) {
                String actors = movieCollection.get(i).getCast();
                String[] actorList = actors.split("\\|");
                for (int j = 0; j < actorList.length; j++) {
                    if (actorList[j].toLowerCase().contains(search) && !matches.contains(actorList[j])) {
                        matches.add(actorList[j]);
                    }
                }
            }
        }
        if (matches.size() == 0) {
            System.out.println("No results match your search");
            start();
        } else {
            Sort.insertionSortWordList2(matches);
            for (int i = 0; i < matches.size(); i++) {
                System.out.println((i + 1) + ". " + matches.get(i));
            }
        }
        System.out.print("Which would you like to see all movies for?\nEnter number: ");
        answer = scan.nextInt();
        String castMember = matches.get(answer - 1);
        for (int i = 0; i < movieCollection.size(); i++) {
            if (movieCollection.get(i).getCast().contains(castMember)) {
                movieMatches.add(movieCollection.get(i));
            }
        }
        Sort.insertionSortWordList3(movieMatches);
        for (int i = 0; i < movieMatches.size(); i++) {
            System.out.println((i + 1) + ". " + movieMatches.get(i).getTitle());
        }

        System.out.print("Which movie would you like to learn more about?\nEnter number: ");
        movieNum = scan.nextInt();
        System.out.println("Title: " + movieMatches.get(movieNum - 1).getTitle() + "\n" +
                "Runtime: " + movieMatches.get(movieNum - 1).getRuntime() + "\n" +
                "Directed by: " + movieMatches.get(movieNum - 1).getDirector() + "\n" +
                "Cast: " + movieMatches.get(movieNum - 1).getCast() + "\n" +
                "Overview: " + movieMatches.get(movieNum - 1).getOverview() + "\n" +
                "User rating: " + movieMatches.get(movieNum - 1).getUserRating());
    }



}

