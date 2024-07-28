/*
알고리즘: bfs
메모리: 15776KB
시간: 596ms
*/

const [N, M] = input[0].split(' ').map(Number);
  
const visited = new Array(100001).fill(0);
const answer = new Array(100001).fill(0);

const bfs = (start) => {
    const queue = [start];

    answer[start] = 1;

    while (queue.length) {  
        const node = queue.shift();

        for (let vw of [node - 1, node + 1, node *2]) {
            if (vw < 0 || vw > 100000) continue;
             
            if (!visited[vw]) {
                queue.push(vw);
                visited[vw] = visited[node] + 1
                answer[vw] += answer[node];
            } else if (visited[vw] === visited[node] + 1) {
                answer[vw] += answer[node]
            }
        }
    }
}

bfs(N, M)

if (N === M) {
    console.log(0);
    console.log(1);
    return ;
}

console.log(visited[M]);
console.log(answer[M]);
 