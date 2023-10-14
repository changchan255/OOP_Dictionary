package DictionaryCmdLine;
//import edu.princeton.cs.algs4.StdIn;
//import edu.princeton.cs.algs4.StdOut;
import java.util.*;

public class DictionaryCommandline extends DictionaryManagement {

    public void showAllWords() {
        String s = "";
        s += "No\t|\t\tEnglish\t\t|\t\tVietnamese \n";

        int n = 1;
        TreeMap<String, String> sorted = new TreeMap<String, String>(mp);
        Set<Map.Entry<String, String>> mappings = sorted.entrySet();
        for (Map.Entry<String, String> mapping : mappings) {
            s += n + "\t|\t\t" + mapping.getKey() + "\t\t|\t\t" + mapping.getValue() + "\n";
            n++;
        }
        System.out.println(s);
    }
//    public void dictionaryBasic() {
//        insertFromCommandline1();
//        showAllWords();
//    }

    public void dictionarySearcher() {
        Scanner sc4 = new Scanner(System.in);
        System.out.println("Nhap tu can tim: ");
        String s = sc4.nextLine();
        for (Word x:dictionary) {
            if ( s.equals(x.getWord_target().substring(0,s.length()))) {
                System.out.println(x.getWord_target());
            }
        }
    }

    public void dictionaryAdvanced() {


        while (true) {
            System.out.println("Welcome to My Application!");
            System.out.println("[0] Exit");
            System.out.println("[1] Add");
            System.out.println("[2] Remove");
            System.out.println("[3] Update");
            System.out.println("[4] Display");
            System.out.println("[5] Lookup");
            System.out.println("[6] Search");
            System.out.println("[7] Game");
            System.out.println("[8] Import from file");
            System.out.println("[9] Export to file");
            System.out.println("Your action:");
            Scanner sc5 = new Scanner(System.in);
            int choice = sc5.nextInt();
            if (choice == 0) {
                break;
            }
            else if (choice == 1) {
                this.dictionaryAdd();
            }
            else if (choice == 2) {
                this.dictionaryRemove();
            }
            else if (choice == 3) {
                this.dictionaryUpdate();
            }
            else if (choice == 4) {
                showAllWords();
            }
            else if (choice == 5) {
                this.dictionaryLookup();
            }
            else if (choice == 6) {
                dictionarySearcher();
            }
            else if (choice == 7) {
                System.out.println("game");
            }
            else if (choice == 8) {
                this.insertFromCommandline2();
            }
            else if (choice == 9) {
                this.dictionaryExportToFile();
            }
            else {
                System.out.println("Action not supported");
                break;
            }
        }
    }
}
