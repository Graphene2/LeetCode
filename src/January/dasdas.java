package January;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-20
 * Time: 15:34
 */
public class dasdas {
        private Set<String> validExpressions = new HashSet<String>();
        private void recurse(String s, int index, int leftCount, int rightCount,
                             int leftRem, int rightRem, StringBuilder expression) {
            if (index == s.length()) {
                if (leftRem == 0 && rightRem == 0) {
                    this.validExpressions.add(expression.toString());
                }
            } else {
                char character = s.charAt(index);
                int length = expression.length();
                if ((character == '(' && leftRem > 0) || (character == ')' && rightRem > 0)) {
                    this.recurse(s, index + 1, leftCount, rightCount,
                            leftRem - (character == '(' ? 1 : 0), rightRem - (character == ')' ? 1 : 0), expression);
                }
                expression.append(character);
                if (character != '(' && character != ')') {
                    this.recurse(s, index + 1, leftCount, rightCount, leftRem, rightRem, expression);
                } else if (character == '(') {
                    this.recurse(s, index + 1, leftCount + 1, rightCount, leftRem, rightRem, expression);
                } else if (rightCount < leftCount) {
                    this.recurse(s, index + 1, leftCount, rightCount + 1, leftRem, rightRem, expression);
                }
                expression.deleteCharAt(length);
            }
        }

        public List<String> removeInvalidParentheses(String s) {
            int left = 0, right = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    left++;
                } else if (s.charAt(i) == ')') {
                    right = left == 0 ? right + 1 : right;
                    left = left > 0 ? left - 1 : left;
                }
            }
            this.recurse(s, 0, 0, 0, left, right, new StringBuilder());
            return new ArrayList<String>(this.validExpressions);
        }

}
