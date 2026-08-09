class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder candidate = new StringBuilder();

        for (int j = 0; j < strs[0].length(); j++) {
            char letter = strs[0].charAt(j);

            for (int i = 1; i < strs.length; i++) {
                if (j >= strs[i].length() || strs[i].charAt(j) != letter) {
                    return candidate.toString();
                }
            }

            candidate.append(letter);
        }

        return candidate.toString();
    }
}