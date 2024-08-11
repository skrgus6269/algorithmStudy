let input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n'); 
// let input = require('fs').readFileSync('예제.txt').toString().trim().split('\r\n');
 
const [N, M] = input.splice(0, 1)[0].split(' ').map(Number);
 
const array = input.map((item) => item.split(' ').map(Number));

const graph = new Array(N + 1).fill(0).map(() => [])
const inDegrees = Array(N + 1).fill(0);

array.forEach((item) => {
    const [prev, next] = item;
    graph[prev].push(next);
    inDegrees[next] ++;
})

const queue = [];

for (let i = 1; i <= N; i++) {
    if (!inDegrees[i]) queue.push(i);
}

const result = [];

while (queue.length) {
    const n = queue.shift();
    result.push(n);
    graph[n].forEach((item) => {
        inDegrees[item]--;
        if (!inDegrees[item]) {
            queue.push(item);
        }
    })
}

console.log(result.join(' '))