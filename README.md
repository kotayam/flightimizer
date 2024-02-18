# Project Name: Flightimizer
## Owner: Kota Yamamoto, Esther Amao

<img src="flightimizer.png" alt="thumbnail"/>

### Description:
Flightimizer will assist users in finding the shortest domestic flight from a source to a
destination city.
We created a graph where cities are vertices and flights are edges. We created an edge list in Python, created an adjacency list in Java, and visualized the graph in R. The edges are weighted by the average actual elapsed time. The average actual elapsed time is calculated by taking the average of the actual elapsed time for the same combination of source and destination city in the dataset.
Dijkstra's Algorithm is used to find the shortest flight from the source to destination.

### Dataset:
https://www.kaggle.com/datasets/levimjoseph/us-domestic-carrier-on-time-performance-2022?resource=download&select=On_Time_Reporting_Carrier_On_Time_Performance_%281987_present%29_2022_5.csv

- The dataset has been deleted from Kaggle.

### Running Instructions:
Step 1. Compile Main.java ("javac Main.java")
Step 2. Run Main.java using the following schema: "java Main x, y, z "

- where x is a number corresponding to a source location and y is a number corresponding to a destination location (See dictionary in Appendix)
- z is an optional argument specifying whether to only run Dijkstra’s on indirect flights (we found that this shows more interesting results). For indirect flights, type in "indirect" for z.
- Here’s an example of checking for the fastest indirect flight from Philadelphia to los Angeles: "java Main 16 4 indirect"

### Appendix:
Dictionary of locations and corresponding numbers:
{ 0: "Atlanta, GA", 1: "Dallas/Fort Worth, TX", 2: "Denver, CO", 3: "Chicago, IL", 4: "Los Angeles, CA", 5: "Orlando, FL", 6: "Phoenix, AZ", 7: "New York, NY", 8: "San Francisco, CA", 9: "Boston, MA", 10: "Houston, TX", 11: "Seattle, WA", 12: "Miami, FL", 13: "Washington, DC", 14: "Charlotte, NC", 15: "Newark, NJ", 16: "Philadelphia, PA", 17: "Las Vegas, NV", 18: "Cleveland, OH", 19: "Minneapolis, MN", 20: "Austin, TX", 21: "San Diego, CA", 22: "Aspen, CO", 23: "Detroit, MI", 24: "Salt Lake City, UT" }
