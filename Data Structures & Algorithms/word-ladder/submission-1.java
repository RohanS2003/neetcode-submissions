class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>(wordList);
        if(!set.contains(endWord))
        return 0;

        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);

        Set<String> visited=new HashSet<>();
        visited.add(beginWord);
        int level=1;

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String curr=q.poll();
                if(curr.equals(endWord)){
                    return level;
                }

                char[] charArray=curr.toCharArray();
                for(int j=0;j<charArray.length;j++){
                    char orginalChar=charArray[j];
                    for(char ch='a';ch<='z';ch++){
                        charArray[j]=ch;

                        String nextWord=new String(charArray);
                        if(set.contains(nextWord) && !visited.contains(nextWord)){
                            q.offer(nextWord);
                            visited.add(nextWord);
                        }
                    }
                    charArray[j]=orginalChar;
                }
            }

            level++;
            
        }
        return 0;
    }
}
