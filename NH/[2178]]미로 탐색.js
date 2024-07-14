/*
알고리즘: bfs
메모리: 12276KB
시간: 176ms
*/

const [N, M] = input.splice(0,1)[0].split(' ').map(Number);

let visited = new Array(N).fill(0).map(() => new Array(M).fill(false));

const x = [0, 0 ,1, -1];
const y = [1, -1, 0, 0];

const bfs = () => {
    const queue= [];

    if (input[0][1] == 1){ queue.push([0, 1, 2]);}
    if (input[1][0] == 1) queue.push([1, 0, 2]);

    while (queue.length) { 
        const node = queue.shift();
         
        if (node[0] === N - 1 && node[1] === M - 1) {
            console.log(node[2]);
            return;
        }

        if (visited[node[0]][node[1]]) continue;
        
        visited[node[0]][node[1]] = true;

        for (let i = 0; i < 4; i++) {
            const dx = node[0] + x[i];
            const dy = node[1] + y[i];

            if (dx < 0 || dy < 0 || dx >= N || dy >= M ) continue;
 
            if (input[dx][dy] == 1) {
                queue.push([dx, dy, node[2] + 1]);  
            }
        }
    }
}

bfs() 
