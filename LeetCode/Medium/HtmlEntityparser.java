import java.util.HashMap;

class Trie {
  HashMap<Character, Trie> hm;
  String str = null;
  boolean isEnd;

  public Trie(String str) {
    str = this.str;
    hm = new HashMap<>();
    isEnd = false;
  }
}

public class HtmlEntityparser {
  private Trie createTrie() {
    String[] entityArr = { "&quot;", "&apos;", "&amp;", "&gt;", "&lt;", "&frasl;" };
    String[] charArr = { "\"", "\'", "&", ">", "<", "/" };
    int N = entityArr.length;

    Trie head = new Trie(null);
    for (int i = 0; i < N; i++) {
      Trie root = head;
      Trie newTrie = new Trie(null);
      for (int j = 0; j < entityArr[i].length(); j++) {
        char curChar = entityArr[i].charAt(j);
        if (root.hm.containsKey(curChar)) {
          root = root.hm.get(curChar);
        } else {
          newTrie = new Trie(null);
          if (j == entityArr[i].length() - 1) {
            newTrie.str = charArr[i];
          }
          root.hm.put(curChar, newTrie);
          root = root.hm.get(curChar);
        }
      }
      newTrie.str = charArr[i];
      newTrie.isEnd = true;
    }
    return head;
  }

  public String entityParser(String text) {
    int N = text.length();
    Trie head = createTrie();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      if (text.charAt(i) == '&') {
        Trie root = head;
        int j = i;

        while (j < N && root.hm.containsKey(text.charAt(j))) {
          root = root.hm.get(text.charAt(j));
          j++;
        }
        if (root.isEnd) {
          sb.append(root.str);
          i = j - 1;
        } else {
          sb.append(text.charAt(i));
        }

      } else {
        sb.append(text.charAt(i));
      }
    }

    System.out.println(sb);
    return sb.toString();
  }

  public static void main(String[] args) {
    HtmlEntityparser ht = new HtmlEntityparser();
    // String str = "&amp; is an HTML entity but &ambassador; is not.";
    String str = "and I quote: &quot;...&quot;";

    ht.entityParser(str);
  }

}
