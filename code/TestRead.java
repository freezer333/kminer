import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.lang.NumberFormatException;

import Benford.StatsGrouper;
import Benford.Numbers;

class TestRead {
    
    // This is to use when reading integers from the CSV.  Java
    // will throw an error if you try to cast a string to a number, and 
    // the string is NOT a number.  String that can't be numbers are things 
    // like "hello", "kevin", and blank strings...
    // Returns -1 if the string isn't a number.  Most NBA statistics
    // can't possibly be negative, so we always would know that something
    // went wrong if the returned value is negative.
    private static Integer safeIntegerParse(String v) {
        try {
            return Integer.parseInt(v);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    
    /* Takes a list of numbers, and a digit value, and returns
       how many numbers start with the digit value given.
    */
    
    private static Integer countStartsWith(List<Integer> stats, int digit) {
        int count = 0;
        for (int i = 0; i < stats.size(); i++) {
            int number = stats.get(i);
            
            int leading = Numbers.get_leading_digit(number);
            if ( leading == digit) {
                count++;
            }
        }  
        
        return count;
        
    }
    
    // This takes one line of a CSV and splits it into a list 
    // of columns
    private static List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
    
    
    public static void main(String [] args) {
        
        
        
        
        // TODO - first analysis was done on games_played.
        List<Integer> games_played = new ArrayList<Integer>();
        
        // TODO - NOW, analysis needs to be done on sg.total()
        StatsGrouper sg = new StatsGrouper();
        
        int one = 0, two = 0, four = 0, five = 0, six = 0, seven = 0, eight = 0, nine = 0;
        int three=0;
        
        // Using this as a flag to remember if we've read our first row.
        // The first row is the table headers (column names), and we don't
        // want to process this one.  So in the loop below, we skip
        // processing if this flag is still false (and set it to true).
        boolean read_first = false;
        
        System.out.println("Loading ../data/Seasons_Stats.csv");
        
        // Create a list of lists. 
        // List (rows) of List (columns)
        List<List<String>> stats = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("../data/Seasons_Stats.csv"))) {
            while (scanner.hasNextLine()) {
                if (read_first) {
                    // Calls the function above, which returns a list for a single row.
                    // Each column is an entry in the list.  View the CSV file in a spreadsheet
                    // view, the first column is entry 0, second is 1, etc.  So row.get(2) is the 
                    // player's name.
                    List<String> row = getRecordFromLine(scanner.nextLine());
                
                    int gp = safeIntegerParse(row.get(6));
                    int year = safeIntegerParse(row.get(1));
                    
                    String player = row.get(2);
                    
                    if (gp > -1) {
                        games_played.add(gp);
                        // Use the stats grouper - calling "record" will record gp, 
                        // by adding it to the career total for the "player".
                        sg.record(player, gp);
                    }
                    stats.add(row);
                } else {
                    // Read the first line, but don't do anything with it...
                    // it's just the column names.
                    scanner.nextLine();
                    // Read the first line, so set the flag.
                    read_first = true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Read " + stats.size() + " lines from CSV file");
        
        one = countStartsWith(games_played, 1);
        two = countStartsWith(games_played, 2);
        three = countStartsWith(games_played, 3);
        four = countStartsWith(games_played, 4);
        five = countStartsWith(games_played, 5);
        six = countStartsWith(games_played, 6);
        seven = countStartsWith(games_played, 7);
        eight = countStartsWith(games_played, 8);
        nine = countStartsWith(games_played, 9);
        
        
        double total = one + two + three + four + five + six + seven + eight + nine;
        
        System.out.println("One => " +  one/total);
        System.out.println("Two => " +  two/total);
        System.out.println("Three => " +  three/total);
        System.out.println("Four => " + four/total);
        System.out.println("Five => " +  five/total);
        System.out.println("Six => " +  six/total);
        System.out.println("Seven => " +  seven/total);
        System.out.println("Eight => " +  eight/total);
        System.out.println("Nine => " +  nine/total);
        
        // TODO:  sg now has the career totals of every player.
        // KEVIN - do the same analysis as we did above with games_played, but 
        // now with career_games_played
        List<Integer> career_games_played = sg.totals();
        
        for (int i =0 ; i < career_games_played.size(); i++ ) {
            // gp is career games played by on person.
            int gp = career_games_played.get(i);
            System.out.println(career_games_played.get(i));
        }

        // TODO:  Do the same analysis as you did with games_played, but now with
        //        with career_games_played.  You will need to use the logic you 
        //        created for handling bigger numbers.
        //        You can call your function by calling Numbers.get_leading_digit("some integer");
        
        /*abc = Numbers.get_leading_digit(career_games_played, digit)
        System.out.println( abc + " => " + abc/sg)*/
    }
}