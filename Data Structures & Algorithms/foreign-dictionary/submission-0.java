class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph=new HashMap<>();
        Map<Character, Integer> indegree=new HashMap<>();

        //init every char
        for(String w:words){
            for(char ch:w.toCharArray()){
                graph.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch,0);
            }
        }

        //build graph
        for(int i=0;i<words.length-1;i++){
            String s1=words[i];
            String s2=words[i+1];

            if(s1.length()>s2.length() && s1.startsWith(s2)){
                return "";
            }

            int len=Math.min(s1.length(), s2.length());

            for(int j=0;j<len;j++){
                char parent=s1.charAt(j);
                char child=s2.charAt(j);

                if (parent != child) {
                    if (!graph.get(parent).contains(child)) {
                        graph.get(parent).add(child);
                        indegree.put(child, indegree.get(child) + 1);
                    }

                    // Only the first different character matters
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();

        for (char ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                queue.offer(ch);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            result.append(curr);

            for (char next : graph.get(curr)) {
                indegree.put(next, indegree.get(next) - 1);

                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }

        if (result.length() != indegree.size()) {
            return "";
        }

        return result.toString();
    }
}
