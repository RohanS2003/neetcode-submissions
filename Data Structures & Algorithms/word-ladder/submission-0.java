class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int length = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                if (word.equals(endWord)) {
                    return length;
                }

                char[] chars = word.toCharArray();

                for (int pos = 0; pos < chars.length; pos++) {
                    char originalChar = chars[pos];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[pos] = ch;
                        
                        String nextWord = new String(chars);

                        if (wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                            visited.add(nextWord);
                            queue.offer(nextWord);
                        }
                    }
                    chars[pos] = originalChar;
                }
            }
            length++;
        }
        return 0;
    }
}
