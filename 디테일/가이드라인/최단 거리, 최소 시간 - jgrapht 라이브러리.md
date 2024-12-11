
- 최단 거리
```java
import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class SubwayShortestPath {
    public static void main(String[] args) {
        // 그래프 생성
        WeightedMultigraph<String, DefaultWeightedEdge> graph =
                new WeightedMultigraph<>(DefaultWeightedEdge.class);

        // 지하철역 추가
        graph.addVertex("교대역");
        graph.addVertex("강남역");
        graph.addVertex("역삼역");
        graph.addVertex("남부터미널역");
        graph.addVertex("양재역");
        graph.addVertex("양재시민의숲역");
        graph.addVertex("매봉역");

        // 2호선 구간 추가 (가중치: 거리 기준)
        graph.setEdgeWeight(graph.addEdge("교대역", "강남역"), 2);
        graph.setEdgeWeight(graph.addEdge("강남역", "역삼역"), 2);

        // 3호선 구간 추가
        graph.setEdgeWeight(graph.addEdge("교대역", "남부터미널역"), 3);
        graph.setEdgeWeight(graph.addEdge("남부터미널역", "양재역"), 6);
        graph.setEdgeWeight(graph.addEdge("양재역", "매봉역"), 1);

        // 신분당선 구간 추가
        graph.setEdgeWeight(graph.addEdge("강남역", "양재역"), 2);
        graph.setEdgeWeight(graph.addEdge("양재역", "양재시민의숲역"), 10);

        // 최단 거리 계산 예제
        getShortestPath(graph, "교대역", "매봉역"); // 교대역에서 매봉역까지 최단 거리
        getShortestPath(graph, "강남역", "양재시민의숲역"); // 강남역에서 양재시민의숲역까지 최단 거리
    }

    public static void getShortestPath(Graph<String, DefaultWeightedEdge> graph, String source, String target) {
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath(source, target).getVertexList();
        double weight = dijkstraShortestPath.getPathWeight(source, target);

        System.out.println(source + "에서 " + target + "까지 최단 경로: " + shortestPath);
        System.out.println("총 거리: " + weight + "km\n");
    }
}

```

- 최소 시간
```java
import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class SubwayShortestTime {
    public static void main(String[] args) {
        // 그래프 생성
        WeightedMultigraph<String, DefaultWeightedEdge> graph =
                new WeightedMultigraph<>(DefaultWeightedEdge.class);

        // 지하철역 추가
        graph.addVertex("교대역");
        graph.addVertex("강남역");
        graph.addVertex("역삼역");
        graph.addVertex("남부터미널역");
        graph.addVertex("양재역");
        graph.addVertex("양재시민의숲역");
        graph.addVertex("매봉역");

        // 2호선 구간 추가 (가중치: 시간 기준)
        graph.setEdgeWeight(graph.addEdge("교대역", "강남역"), 3);
        graph.setEdgeWeight(graph.addEdge("강남역", "역삼역"), 3);

        // 3호선 구간 추가
        graph.setEdgeWeight(graph.addEdge("교대역", "남부터미널역"), 2);
        graph.setEdgeWeight(graph.addEdge("남부터미널역", "양재역"), 5);
        graph.setEdgeWeight(graph.addEdge("양재역", "매봉역"), 1);

        // 신분당선 구간 추가
        graph.setEdgeWeight(graph.addEdge("강남역", "양재역"), 8);
        graph.setEdgeWeight(graph.addEdge("양재역", "양재시민의숲역"), 3);

        // 최소 시간 경로 계산 예제
        getShortestTime(graph, "교대역", "매봉역"); // 교대역에서 매봉역까지 최소 시간
        getShortestTime(graph, "강남역", "양재시민의숲역"); // 강남역에서 양재시민의숲역까지 최소 시간
    }

    public static void getShortestTime(Graph<String, DefaultWeightedEdge> graph, String source, String target) {
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath(source, target).getVertexList();
        double weight = dijkstraShortestPath.getPathWeight(source, target);

        System.out.println(source + "에서 " + target + "까지 최소 시간 경로: " + shortestPath);
        System.out.println("총 소요 시간: " + weight + "분\n");
    }
}

```