# api-random-graph-generator
This is an api capable of generating some types of graphs at random.
This api accepts only the GET requests.

# 1-Generate a simple random graph
you can generate a simple random graph through the url https://apirest-graphs.herokuapp.com/graphs/simple/{v}/{e}. Just change the {v} to a integer number that  represents the number of vertices, and change the {e} to a integer number that represents the number of edges. The api will return a random simple graph.

# 2-Generate a random tree
you can generate a random tree through the url https://apirest-graphs.herokuapp.com/graphs/tree/{v}. Just change the {v} to a integer number that represents the number of vertices. The api will return a random tree.

# 3-Generate a random partial grid
you can generate a random partial grid through the url https://apirest-graphs.herokuapp.com/graphs/partialgrid/{n}/{m}/{p}. Just change {n} and {m} to two integer numbers that represents the dimensions of the grid, and change {p} to a integer number between 0 and 100. The {p} represents the percent of  chance that a edge has to apear between two vertex of graph. The api will return a random partial grid.

# 4-Generate a random bipartite graph 
you can generate a random bipartite graph through the url https://apirest-graphs.herokuapp.com/graphs/bipartite/{v}/{p}. Just change {v} to a integer number that represents the number of vertices, and change the {p} to a integer number between 0 and 100. The {p} represents the percent of chance that a edge has to apear between two vertex of graph. The api will return a random bipartite graph. 
