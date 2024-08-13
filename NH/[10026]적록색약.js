let input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n'); 
// let input = require('fs').readFileSync('예제.txt').toString().trim().split('\r\n');
 
const N = Number(input.splice(0, 1)[0]);

const map = input.map((item) => item.split(''));

const x_move = [1, 0, 0, -1];
const y_move = [0, 1, -1, 0];

const ill_map = map.map((item) => item.slice().map((items) => {
    if (items === 'R') return 'G';
    return items; 
}));

let visited = new Array(N).fill(0).map(() => new Array(N).fill(false));

const bfs = (start, maps) => {
    const queue = [start];

    while (queue.length) { 
        const [x, y] = queue.pop();

        if (visited[x][y]) continue;
        
        visited[x][y] = true;

        for (let i = 0; i < 4; i++) {
            const dx = x + x_move[i];
            const dy = y + y_move[i];

            if (dx < 0 || dy < 0 || dx >= N || dy >= N) continue;

            if (!visited[dx][dy] && maps[dx][dy] === maps[x][y]) {
                queue.push([dx, dy]);
            }
        }
    }
}


let ill_count = 0;
let healthy_count = 0;

for (let i = 0; i < N; i++) {
    for (let j = 0 ; j < N; j++) {
        if (!visited[i][j]) {
            bfs([i, j], ill_map) 
            ill_count++;
        }
       
    }
}

visited = new Array(N).fill(0).map(() => new Array(N).fill(false));

for (let i = 0; i < N; i++) {
    for (let j = 0 ; j < N; j++) {
        if (!visited[i][j]) {
            bfs([i, j], map) 
            healthy_count++;
        }
    }
}

console.log(healthy_count, ill_count); 