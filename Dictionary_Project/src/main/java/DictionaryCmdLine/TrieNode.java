package DictionaryCmdLine;

class TrieNode {
    private TrieNode[] children;
    private boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[127]; // 26 chữ cái trong tiếng Anh
        isEndOfWord = false;
    }

    public boolean containsKey(char ch) {
        return children[ch - ' '] != null;
    }

    public TrieNode get(char ch) {
        return children[ch - ' '];
    }

    public void put(char ch, TrieNode node) {
        children[ch - ' '] = node;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean isEnd) {
        isEndOfWord = isEnd;
    }
}
