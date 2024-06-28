/*
알고리즘: dfs
메모리: 20296KB
시간: 256ms
*/
const N = Number(input.splice(0, 1));

if (N === 1) {
    console.log(0);
    return ;
}

const array = input.map((item) => item.split(' ').map(Number));
 
const graph = new Array(N + 1).fill(0).map(() => []);

const visited = new Array(N + 1).fill(false);

array.forEach(([from, to, distance]) => {
    graph[from].push({go: to, distance}) 
    graph[to].push({go: from, distance}) 
});

let max = {node: 0, distance: 0};

const dfs = (start, sum) => { 
    if (max.distance < sum) {
        max = {node: start, distance: sum};
    }  
    for (let i = 0; i < graph[start].length; i++) {
        if (!visited[graph[start][i].go]) { 
            visited[graph[start][i].go] = true;
            dfs(graph[start][i].go, graph[start][i].distance + sum);
        }    
    }
}

//루트에서 가장 먼 노드 찾기
visited[1] = true;
dfs(1, 0);
visited.fill(false);

visited[max.node] = true;
dfs(max.node, 0);
console.log(max.distance)