library(network)
library(igraph)
library(readr)

Sys.setenv(lang="en")

dict = list("Atlanta", "Dallas", "Denver", "Chicago", "Los Angeles",
         "Orlando", "Phoenix", "New York", "San Francisco", "Boston",
         "Houston", "Seattle", "Miami", "Washington", "Charlotte",
         "Newark", "Philadelphia", "Las Vegas", "Cleveland", "Minneapolis",
         "Austin", "San Diego", "Aspen", "Detroit", "Salt Lake City")

# read in data into a dataframe 
edgeframe <-read_table("edgelist.txt")

head(edgeframe, 10)

edgeframe$src = character(nrow(edgeframe))
edgeframe$dest = character(nrow(edgeframe))

for (i in 1:nrow(edgeframe)) {
  src = as.integer(edgeframe$`22`[i]) + 1
  dest = as.integer(edgeframe$`0`[i]) + 1
  edgeframe$src[i] = dict[src]
  edgeframe$dest[i] = dict[dest]
}

edgeframe$src = as.character(edgeframe$src)
edgeframe$dest = as.character(edgeframe$dest)

head(edgeframe, 10)

edgeframe$`22` = NULL
edgeframe$`0` = NULL
edgeframe$`193.0344827586207` = NULL

# take sample
sub_size = round(0.2*nrow(edgeframe))

sample = sample(1:nrow(edgeframe), size = sub_size, replace = FALSE)

sub = edgeframe[sample, ]

# Convert the edgelist into a matrix of communications
edgematrix <-as.matrix(sub)

# create a network object for analysis
orgnetwork <- graph_from_edgelist(edgematrix, directed=TRUE)

net = simplify(orgnetwork, remove.multiple=T, remove.loops=T)

# visualize the network
par(bg="azure")
plot(net, layout=layout_with_fr, edge.arrow.size = 0.2, vertex.size=1, 
     edge.color="tomato", vertex.label.color="gray20", vertex.color="tomato", 
     vertex.frame.color="#ffffff", vertex.shape="none", vertex.label.font=1, 
     vertex.label.cex=1.5, edge.curved=0.1)

