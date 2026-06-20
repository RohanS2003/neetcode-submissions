class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        // Not ArrayList because we fetch by name:
        // map.get("JFK"), not graph.get(0)
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            map.putIfAbsent(from, new PriorityQueue<>());
            map.get(from).add(to);
        }

        LinkedList<String> res = new LinkedList<>();

        dfs(res, map, "JFK");

        return res;
    }

    private void dfs(
        LinkedList<String> res,
        Map<String, PriorityQueue<String>> map,
        String airport
    ) {
        PriorityQueue<String> dest = map.get(airport);

        while (dest != null && !dest.isEmpty()) {
            String next = dest.poll();
            dfs(res, map, next);
        }

        res.addFirst(airport);
    }
}