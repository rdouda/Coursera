## Exercise 1
### Output
```
0
1
4
3
2
5
```
## Exercise 2
In a disconnected graph, there are two or more separate components, each of which is a connected subgraph but not connected to the other components.
```
Disconnected Component 1       Disconnected Component 2
      0 --> 1                    start 4 --> 5
      0 --> 2                    start 4 --> 6
start 2 --> 0                          6 --> 7
start 2 --> 3                          7 --> 7
      3 --> 3
```
In this representation, we have two disconnected components: one containing vertices 0, 1, 2, and 3, and another containing vertices 4, 5, 6, and 7. These components are not connected to each other.