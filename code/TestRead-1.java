import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.lang.NumberFormatException;

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
        // See TODOs below to see what to do with "games_played".
        List<Integer> games_played = new ArrayList<Integer>();
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
                    System.out.println("Reading " + row.get(2) + " (" + row.get(1) + ")" + ", " + row.get(6));
            
                    /* TODO 
                       Try adding the games played for the given row to the printout above.
                       Next, see if you can put that value in the "games_played" list that I
                       created above.
                       Then, at the end of the program (after it prints out "Read ..."), 
                       see if you can create a loop and print out the contents of the games_played
                       list.  It should print out just a bunch of numbers (one on each line).
                    */
                    int gp = safeIntegerParse(row.get(6));
                    int year = safeIntegerParse(row.get(1));
                    //System.out.println(gp);
                    if (gp > -1 && year == 1984) {
                        games_played.add(gp);
                    }
                    /*if (games_played > 10) {
                        return int games_played / 10
                        
                        } else {
                            return int games_played
                        } */
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
        
        // TODO - create a loop (for loop, with bounds of games_played.size()) that 
        //        prints out each value
        
        //MODIFY PROGRAM TO ONLY count the year i did in the google sheets and cover each number
        
        for (int i = 0; i < games_played.size(); i++) {
            int gp = games_played.get(i);
            boolean is_one = false;
            System.out.println(gp);
            if ( gp >= 10 ) {
                //System.out.println("Greater than 10");
                if (gp / 10 == 1) {
                    one++;
                    is_one = true;
                } else {
                    //System.out.println("Not starting with 3");
                }
            }
            else {
                //System.out.println("Less than 10");
                if (gp == 1) {
                    one++;
                    is_one = true;
                }
                else {
                    //System.out.println("Not 3");
                }
            }
            
            if (is_one) {
                System.out.println(gp + " is 1");
            }
            else {
                System.out.println(gp +  "is NOT 1");
            }
            
            
            
            if (gp == -1) {
                System.out.println("Uh-oh");
                return;
            }
            //System.out.println(gp);
        }         
        
        for (int i = 0; i < games_played.size(); i++) {
            int gp = games_played.get(i);
            boolean is_two = false;
            System.out.println(gp);
            if ( gp >= 10 ) {
                //System.out.println("Greater than 10");
                if (gp / 10 == 2) {
                    two++;
                    is_two = true;
                } else {
                    //System.out.println("Not starting with 3");
                }
            }
            else {
                //System.out.println("Less than 10");
                if (gp == 2) {
                    two++;
                    is_two = true;
                }
                else {
                    //System.out.println("Not 3");
                }
            }
            
            if (is_two) {
                System.out.println(gp + " is 2");
            }
            else {
                System.out.println(gp +  "is NOT 2");
            }
            
            
            
            if (gp == -1) {
                System.out.println("Uh-oh");
                return;
            }
            //System.out.println(gp);
        }         
        
        for (int i = 0; i < games_played.size(); i++) {
            int gp = games_played.get(i);
            boolean is_three = false;
            System.out.println(gp);
            if ( gp >= 10 ) {
                //System.out.println("Greater than 10");
                if (gp / 10 == 3) {
                    three++;
                    is_three = true;
                } else {
                    //System.out.println("Not starting with 3");
                }
            }
            else {
                //System.out.println("Less than 10");
                if (gp == 3) {
                    three++;
                    is_three = true;
                }
                else {
                    //System.out.println("Not 3");
                }
            }
            
            if (is_three) {
                System.out.println(gp + " is 3");
            }
            else {
                System.out.println(gp +  "is NOT 3");
            }
            
            
            
            if (gp == -1) {
                System.out.println("Uh-oh");
                return;
            }
            //System.out.println(gp);
        } 
 
        for (int i = 0; i < games_played.size(); i++) {
            int gp = games_played.get(i);
            boolean is_four = false;
            System.out.println(gp);
            if ( gp >= 10 ) {
                //System.out.println("Greater than 10");
                if (gp / 10 == 4) {
                    four++;
                    is_four = true;
                } else {
                    //System.out.println("Not starting with 3");
                }
            }
            else {
                //System.out.println("Less than 10");
                if (gp == 4) {
                    four++;
                    is_four = true;
                }
                else {
                    //System.out.println("Not 3");
                }
            }
            
            if (is_four) {
                System.out.println(gp + " is 4");
            }
            else {
                System.out.println(gp +  "is NOT 4");
            }
            
            
            
            if (gp == -1) {
                System.out.println("Uh-oh");
                return;
            }
            //System.out.println(gp);
        } 
        
        for (int i = 0; i < games_played.size(); i++) {
            int gp = games_played.get(i);
            boolean is_five = false;
            System.out.println(gp);
            if ( gp >= 10 ) {
                //System.out.println("Greater than 10");
                if (gp / 10 == 5) {
                    five++;
                    is_five = true;
                } else {
                    //System.out.println("Not starting with 3");
                }
            }
            else {
                //System.out.println("Less than 10");
                if (gp == 5) {
                    five++;
                    is_five = true;
                }
                else {
                    //System.out.println("Not 3");
                }
            }
            
            if (is_five) {
                System.out.println(gp + " is 5");
            }
            else {
                System.out.println(gp +  "is NOT 5");
            }
            
            
            
            if (gp == -1) {
                System.out.println("Uh-oh");
                return;
            }
            //System.out.println(gp);
        }         
        
        for (int i = 0; i < games_played.size(); i++) {
            int gp = games_played.get(i);
            boolean is_six = false;
            System.out.println(gp);
            if ( gp >= 10 ) {
                //System.out.println("Greater than 10");
                if (gp / 10 == 6) {
                    six++;
                    is_six = true;
                } else {
                    //System.out.println("Not starting with 3");
                }
            }
            else {
                //System.out.println("Less than 10");
                if (gp == 6) {
                    six++;
                    is_six = true;
                }
                else {
                    //System.out.println("Not 3");
                }
            }
            
            if (is_six) {
                System.out.println(gp + " is 6");
            }
            else {
                System.out.println(gp +  "is NOT 6");
            }
            
            
            
            if (gp == -1) {
                System.out.println("Uh-oh");
                return;
            }
            //System.out.println(gp);
        }         
        
        for (int i = 0; i < games_played.size(); i++) {
            int gp = games_played.get(i);
            boolean is_seven = false;
            System.out.println(gp);
            if ( gp >= 10 ) {
                //System.out.println("Greater than 10");
                if (gp / 10 == 7) {
                    seven++;
                    is_seven = true;
                } else {
                    //System.out.println("Not starting with 3");
                }
            }
            else {
                //System.out.println("Less than 10");
                if (gp == 7) {
                    seven++;
                    is_seven = true;
                }
                else {
                    //System.out.println("Not 3");
                }
            }
            
            if (is_seven) {
                System.out.println(gp + " is 7");
            }
            else {
                System.out.println(gp +  "is NOT 7");
            }
            
            
            
            if (gp == -1) {
                System.out.println("Uh-oh");
                return;
            }
            //System.out.println(gp);
        }            
        
        for (int i = 0; i < games_played.size(); i++) {
            int gp = games_played.get(i);
            boolean is_eight = false;
            System.out.println(gp);
            if ( gp >= 10 ) {
                //System.out.println("Greater than 10");
                if (gp / 10 == 8) {
                    six++;
                    is_eight = true;
                } else {
                    //System.out.println("Not starting with 3");
                }
            }
            else {
                //System.out.println("Less than 10");
                if (gp == 8) {
                    eight++;
                    is_eight = true;
                }
                else {
                    //System.out.println("Not 3");
                }
            }
            
            if (is_eight) {
                System.out.println(gp + " is 8");
            }
            else {
                System.out.println(gp +  "is NOT 8");
            }
            
            
            
            if (gp == -1) {
                System.out.println("Uh-oh");
                return;
            }
            //System.out.println(gp);
        }            
        
        for (int i = 0; i < games_played.size(); i++) {
            int gp = games_played.get(i);
            boolean is_nine = false;
            System.out.println(gp);
            if ( gp >= 10 ) {
                //System.out.println("Greater than 10");
                if (gp / 10 == 9) {
                    nine++;
                    is_nine = true;
                } else {
                    //System.out.println("Not starting with 3");
                }
            }
            else {
                //System.out.println("Less than 10");
                if (gp == 9) {
                    nine++;
                    is_nine = true;
                }
                else {
                    //System.out.println("Not 3");
                }
            }
            
            if (is_nine) {
                System.out.println(gp + " is 9");
            }
            else {
                System.out.println(gp +  "is NOT 9");
            }
            
            
            
            if (gp == -1) {
                System.out.println("Uh-oh");
                return;
            }
            //System.out.println(gp);
        }            
        
        System.out.println("One => " +  one);
        System.out.println("Two => " +  two);
        System.out.println("Three => " +  three);
        System.out.println("Four => " + four);
        System.out.println("Five => " +  five);
        System.out.println("Six => " +  six);
        System.out.println("Seven => " +  seven);
        System.out.println("Eight => " +  eight);
        System.out.println("Nine => " +  nine);
        
        /* TODO BONUS - we will need the values in games_played to be numbers, 
                        not strings.  Change the data type to Integer, and when 
                        you call games_played.add, do the cast to an int using
                        the Integer.parseInt function.
                        
                        Hint:  You'll get a NumberFormatException on some of the lines.
                        This is because some of the lines have a blank value for games
                        played, and Integer.parseInt fails.
                        
                        You can use the safeIntegerParse function at the top of the file
                        INSTEAD of Integer.parseInt to handle this - but be careful not
                        to actually add -1 to the list!  Try saving it in a temporary variable
                        and only put it in the games_played list if the value is greater
                        or equal to 0.
        */
    }
}