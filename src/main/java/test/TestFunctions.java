package test;



import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestFunctions {

  @Test
  public void reverseString() {
    char[] s ={ 'h', 'e', 'l', 'l', 'o' };
    int length = s.length;
    helper(s, 0 , s.length -1);
  }

  public void helper(char[] s, int left, int right) {
    if (left >= right) return;
    char tmp = s[left];
    s[left++] = s[right];
    s[right--] = tmp;
    helper(s, left, right);
    System.out.println(s);
  }

  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


}
