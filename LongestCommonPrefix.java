/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        if (strs.length == 1){
            return prefix;
        }
        for (int i = 1; i < strs.length; i++) {
            int shortLen = Math.min(strs[i].length(), prefix.length());
            int j;
            for (j = 0; j < shortLen; j++) {
                if (j == 0 && prefix.charAt(j) != strs[i].charAt(j)) {
                    return "";
                }
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    }
}
