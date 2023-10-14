package DictionaryCmdLine;

import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DictionaryManagement {
    protected Dictionary dictionary = new Dictionary();
    protected Map<String,String> mp = new HashMap<>();

//    public void insertFromCommandline1() {
////        Scanner sn = new Scanner(System.in);
////        int n = StdIn.readInt();
//        while (!StdIn.isEmpty()) {
//            String a = StdIn.readLine();
//            String b = StdIn.readLine();
//            Word w = new Word(a, b);
//            mp.put(a,b);
//            dictionary.add(w);
//        }
//    }

    public void dictionaryLookup() {
        Scanner sc0 = new Scanner(System.in);
        System.out.println("Nhap target: ");
        String t = sc0.next();
        System.out.println(mp.get(t));
    }
    public void insertFromCommandline2() {
        File f = new File("/Users/lehung/Documents/OOP/OOP_Dictionary/Dictionary_Project/src/main/resources/Utils/dictionary.txt");
        try {
            List<String> allText = Files.readAllLines(f.toPath(), StandardCharsets.UTF_8);
            for (String line : allText) {
                String[] word = line.split("\t");
                String t = word[0];
                String e = word[1];
                mp.put(t, e);
                Word w = new Word(t, e);
                dictionary.add(w);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dictionaryAdd() {
//        StdOut.println("Nhap target: ");
//        String t = StdIn.readLine();
//        StdOut.println("Nhap explain: ");
//        String e = StdIn.readLine();
//        mp.put(t, e);
//        Word w = new Word(t, e);
//        dictionary.add(w);
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Nhap target: ");
        String t = sc1.nextLine();
        System.out.println("Nhap explain: ");
        String e = sc1.nextLine();
        mp.put(t, e);
        Word w = new Word(t, e);
        dictionary.add(w);
    }

    public void dictionaryUpdate() {
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Nhap target: ");
        String t = sc2.nextLine();
        System.out.println("Nhap explain can sua: ");
        String e = sc2.nextLine();
        mp.replace(t, e);
        for (Word w:dictionary) {
            if (w.getWord_target().equals(t)) {
                w.setWord_explain(e);
                return;
            }
        }
    }

    public void dictionaryRemove() {
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Nhap target cua word can xoa: ");
        String t = sc3.nextLine();
        mp.remove(t);
        for (Word w:dictionary) {
            if (w.getWord_target().equals(t)) {
                dictionary.remove(w);
                return;
            }
        }
    }

    public void dictionaryExportToFile() {
        try {
            PrintWriter pw = new PrintWriter("/Users/lehung/Documents/OOP/OOP_Dictionary/Dictionary_Project/src/main/resources/Utils/dictionary.txt","UTF-8");
            for (Word w:dictionary) {
                pw.println(w.getWord_target() + "\t" + w.getWord_explain());
            }
            pw.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
