/*
알고리즘: 정렬
메모리: 298492KB
시간: 2092ms
*/
const N = Number(input.splice(0, 1)[0]);

const array = input[0].split(' ').map(Number);

const index_array = array.map((item, index) => [item, index]);

const sorted_array = index_array.sort((a, b) => a[0] - b[0]);

const visited = new Array(N).fill(0);

let num = 0;

for (let i = 0; i < sorted_array.length; i++) {
    if (i !== 0 && sorted_array[i][0] === sorted_array[i - 1][0]) {
        visited[sorted_array[i][1]] = num - 1; 
        continue;
    }
    visited[sorted_array[i][1]] = num; 
    num++;
}
 

console.log(visited.join(' '));