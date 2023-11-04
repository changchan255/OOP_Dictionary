
public class test {
    public static void main(String[] args) {
        Dictionary dic = new Dictionary();
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        String path = "/Users/lehung/Documents/OOP/Dictionary1/src/dictionary.txt";
        dictionaryManagement.insertFromCommandline(dic);
        System.out.println(dictionaryManagement.dictionarySearcher(dic,"a"));
    }
}
