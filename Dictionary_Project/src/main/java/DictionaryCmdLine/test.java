package DictionaryCmdLine;

public class test {
    public static void main(String[] args) {
        Dictionary dic = new Dictionary();
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        String path = "/Users/lehung/Documents/OOP/OOP_Dictionary/Dictionary_Project/src/main/resources/Utils/dictionary.txt";
        dictionaryManagement.insertFromCommandline(dic,path);
        System.out.println(dictionaryManagement.dictionarySearcher(dic,"a"));
        System.out.println(dictionaryManagement.dictionaryLookup("hello"));
        dictionaryManagement.dictionaryUpdate_replace(dic, "push", "nhấn", path);
    }
}
