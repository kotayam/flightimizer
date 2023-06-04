import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filename = "edgeList.txt";
        AdjacencyList adjList = new AdjacencyList(filename);
        try {
            adjList.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // System.out.println(String.format("# edges: %d \n# Source City: %d\n", adjList.getNumberOfEdges(), adjList.size()));

        String[] dict = {"Atlanta, GA", "Dallas/Fort Worth, TX", "Denver, CO", "Chicago, IL", "Los Angeles, CA",
                "Orlando, FL", "Phoenix, AZ", "New York, NY", "San Francisco, CA", "Boston, MA",
                "Houston, TX", "Seattle, WA", "Miami, FL", "Washington, DC", "Charlotte, NC",
                "Newark, NJ", "Philadelphia, PA", "Las Vegas, NV", "Cleveland, OH", "Minneapolis, MN",
                "Austin, TX", "San Diego, CA", "Aspen, CO", "Detroit, MI", "Salt Lake City, UT"};

        // dict = {0: "Atlanta, GA", 1: "Dallas/Fort Worth, TX", 2: "Denver, CO", 3: "Chicago, IL", 4: "Los Angeles, CA",
        //        5: "Orlando, FL", 6: "Phoenix, AZ", 7: "New York, NY", 8: "San Francisco, CA", 9: "Boston, MA",
        //        10: "Houston, TX", 11: "Seattle, WA", 12: "Miami, FL", 13: "Washington, DC", 14: "Charlotte, NC",
        //        15: "Newark, NJ", 16: "Philadelphia, PA", 17: "Las Vegas, NV", 18: "Cleveland, OH", 19: "Minneapolis, MN",
        //        20: "Austin, TX", 21: "San Diego, CA", 22: "Aspen, CO", 23: "Detroit, MI", 24: "Salt Lake City, UT"}

        // read user input in terminal. default Philly to LA
        int src = -1;
        int dest = -1;

        // check if src and dest are entered in terminal
        try {
            src = Integer.parseInt(args[0]);
            dest = Integer.parseInt(args[1]);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error: please choose a source and destination.");
        }

        // check if src and dest are the same city
        if (src == dest) {
            throw new IllegalArgumentException("Error: please choose a different city for the source and destination.");
        }

        // check if the city is in the dictionary
        try {
            String a = dict[src];
            String b = dict[dest];
        } catch (Exception e) {
            throw new IllegalArgumentException("Error: please choose a city from the given list.");
        }

        String c = "";
        try {
            c = args[2];
        } catch(Exception e) {
            c = "direct";
        }
        if (c.equals("indirect")) {
            adjList.setDuration(src, dest, Integer.MAX_VALUE);
        }

        Dijkstra dijkstra = new Dijkstra(adjList);
        dijkstra.dijkstra(src);
        List<Integer> route = dijkstra.getShortestPath(dest);
        float duration = dijkstra.getDuration(dest);

        String result = String.format("The fastest %s flight from %s to %s is: \n%s ", c, dict[src], dict[dest], dict[src]);
        for (int id : route) {
            result += String.format("--> %s ", dict[id]);
        }
        result += String.format("\nwith total travel time: %f min", duration);
        System.out.println(result);

    }
}