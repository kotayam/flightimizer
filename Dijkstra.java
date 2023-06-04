import java.util.*;

public class Dijkstra {

    private AdjacencyList adjList;

    // the number of city (vertices) included in the graph
    private final int numCity = 25;

    private float[] dist;

    private int[] parent;

    private boolean[] queue;

    public Dijkstra(AdjacencyList adjList) {
        this.adjList = adjList;
        this.dist = new float[numCity];
        this.parent = new int[numCity];
        this.queue = new boolean[numCity];
    }

    public boolean allChecked(boolean[] queue) {
        boolean bool = true;
        for (int i = 0; i < queue.length; i++) {
            bool = bool && queue[i];
        }
        return bool;
    }
    public void dijkstra(int srcCityId) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[srcCityId] = 0;
        Arrays.fill(parent, -1);

        int src = srcCityId;
        int count = 1;
        while (!allChecked(queue) && src != -1) {
            if (adjList.containsKey(src)) {
                for (Tuple t : adjList.get(src)) {
                    int destCityId = t.getId();
                    float duration = t.getDuration();

                    float totalDur = dist[src] + duration;
                    // if it is a shorter path, update
                    if (totalDur < dist[destCityId]) {
                        dist[destCityId] = totalDur;
                        parent[destCityId] = src;
                    }
                }
            }
            // .out.println(String.format("Iteration: %d \nthe src we are looking at is %d", count, src));
            queue[src] = true;
            count++;

            // get the cityId with smallest distance
            int minIdx = -1;
            float min = Integer.MAX_VALUE;
            for (int i = 0; i < dist.length; i++) {
                // System.out.println(String.format("Distance for city %d is %f", i, dist[i]));
                if (!queue[i] && dist[i] < min) {
                    minIdx = i;
                    min = dist[minIdx];
                }
            }
            src = minIdx;
            // System.out.println(String.format("the next city we are looking at is %d", src));
        }


    }

    public List<Integer> getShortestPath(int destCityId) {
        boolean tracing = true;
        List<Integer> route = new LinkedList<>();
        route.add(destCityId);
        int prevCityId = parent[destCityId];
        while (tracing) {
            // if no parent, or we reached the source
            if (prevCityId == -1 || dist[prevCityId] == 0) {
                tracing = false;
            } else {
                route.add(prevCityId);
                prevCityId = parent[prevCityId];
            }
        }
        Collections.reverse(route);
        return route;
    }

    public float getDuration(int destCityId) {
        return dist[destCityId];
    }
}
