

import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import java.util.*;

public class DictionaryManagement {
//    protected Dictionary dictionary = new Dictionary();
    protected Map<String, Pair<String, Integer>> mp = new HashMap<>();
    private Trie trie = new Trie();

    public String dictionaryLookup(String t) {
//        System.out.println(mp.get(t));
        return mp.get(t).getKey();
    }
    public void insertFromCommandline(Dictionary dictionary) {
        File f = new File("/Users/lehung/Documents/OOP/Dictionary1/src/dictionary.txt");
        try {
            List<String> allText = Files.readAllLines(f.toPath(), StandardCharsets.UTF_8);
            for (String line : allText) {
                String[] word = line.split("\t");
                String t = word[0];
                String e = word[1];
                Word w = new Word(t, e);
                mp.put(t, new Pair(e, dictionary.size()));
                dictionary.add(w);
            }
            addAllTrie(dictionary);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dictionaryAdd(Dictionary dictionary, String t, String e, String path) {
        mp.put(t, new Pair(e, dictionary.size()));
        Word w = new Word(t, e);
        dictionary.add(w);
        trie.insert(t);
        dictionaryExportToFile(dictionary, path);
    }

    public void dictionaryUpdate(Dictionary dictionary, String t, String e, String path) {
        int tmp = mp.get(t).getValue();
        mp.replace(t, new Pair(e, tmp));
        dictionary.get(tmp).setWord_explain(e);
        dictionaryExportToFile(dictionary, path);
    }

    public void dictionaryRemove(Dictionary dictionary, String t, String path) {
        int tmp = mp.get(t).getValue();
        dictionary.remove(dictionary.get(tmp));
        mp.remove(t);
        dictionaryExportToFile(dictionary, path);
    }

    public void dictionaryExportToFile(Dictionary dictionary, String path) {
        try {
            PrintWriter pw = new PrintWriter("/Users/lehung/Documents/OOP/Dictionary1/src/dictionary.txt","UTF-8");
            for (Word w:dictionary) {
                pw.println(w.getWord_target() + "\t" + w.getWord_explain());
            }
            pw.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addAllTrie(Dictionary dictionary) {
        try {
            for (Word w : dictionary) {
                trie.insert(w.getWord_target());
            }
        } catch (NullPointerException e) {
            System.out.println("Dictionary is blank!");
        }
    }

    public List<String> dictionarySearcher(Dictionary dictionary, String t) {
        List<String> list = trie.searchWithPrefix(t);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < Math.min(10, list.size()); i++) {
            result.add(list.get(i));
        }
        return result;
    }
}