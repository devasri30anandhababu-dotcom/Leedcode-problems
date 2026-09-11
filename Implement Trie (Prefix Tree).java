class Trie {

    Trie[] child;
    boolean eow;

    public Trie() {
        child = new Trie[26];
        eow = false;
    }

    public void insert(String word) {

        Trie curr = this;

        for (int i = 0; i < word.length(); i++) {

            int idx = word.charAt(i) - 'a';

            if (curr.child[idx] == null) {
                curr.child[idx] = new Trie();
            }

            curr = curr.child[idx];
        }

        curr.eow = true;
    }

    public boolean search(String word) {

        Trie curr = this;

        for (int i = 0; i < word.length(); i++) {

            int idx = word.charAt(i) - 'a';

            if (curr.child[idx] == null)
                return false;

            curr = curr.child[idx];
        }

        return curr.eow;
    }

    public boolean startsWith(String prefix) {

        Trie curr = this;

        for (int i = 0; i < prefix.length(); i++) {

            int idx = prefix.charAt(i) - 'a';

            if (curr.child[idx] == null)
                return false;

            curr = curr.child[idx];
        }

        return true;
    }
}
