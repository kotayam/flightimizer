import java.io.*;
import java.util.*;


/**
 * This class extends HashMap and creates a AdjacencyList based on an Edge List
 */
public class AdjacencyList extends HashMap {

    // HashMap which represents the Adjacency List
    private HashMap<Integer, List<Tuple>> adjList;

    // filename of file containing the edge list
    private String filename;

    /**
     * Constructor of Adjacency List
     * @param filename filename of file which contains edge list
     */
    public AdjacencyList(String filename){
        adjList = new HashMap<>();
        this.filename = filename;
    }

    /**
     * Creates an Adjacency List from an edge list.
     * @throws FileNotFoundException when file is not found
     * @throws IOException for BufferedReader
     */
    public void create() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while (line != null) {
            String[] sl = line.split(" ");
            int srcCityId = Integer.parseInt(sl[0]);
            int destCityId = Integer.parseInt(sl[1]);
            float duration = Float.parseFloat(sl[2]);
            if (!adjList.containsKey(srcCityId)) {
                List<Tuple> nodes = new LinkedList<>();
                Tuple tuple = new Tuple(destCityId, duration);
                nodes.add(tuple);
                adjList.put(srcCityId, nodes);
            } else {
                Tuple tuple = new Tuple(destCityId, duration);
                adjList.get(srcCityId).add(tuple);
            }
            line = br.readLine();
        }
        br.close();
    }

    public void setDuration(int src, int dest, float newDur) {
        List<Tuple> dests = adjList.get(src);
        for (Tuple t : dests) {
            if (t.getId() == dest) {
                t.setDuration(newDur);
            }
        }
    }
    /**
     * Get the number of edges in the Adjacency List.
     * @return number of edges in the Adjacency List
     */
    public int getNumberOfEdges() {
        int counter = 0;
        for (Map.Entry<Integer, List<Tuple>> entry : adjList.entrySet()) {
            counter += entry.getValue().size();
        }
        return counter;
    }

    @Override
    public int size() {
        return adjList.size();
    }

    @Override
    public List<Tuple> get(Object key) {
        return adjList.get(key);
    }

    @Override
    public boolean containsKey(Object key) {
        return adjList.containsKey(key);
    }

    @Override
    public  boolean containsValue(Object value) {
        for (Map.Entry<Integer, List<Tuple>> entry : adjList.entrySet()) {
            List<Tuple> v = entry.getValue();
            if (v.contains(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<Map.Entry<Integer, List<Tuple>>> entrySet() {
        return adjList.entrySet();
    }
}
