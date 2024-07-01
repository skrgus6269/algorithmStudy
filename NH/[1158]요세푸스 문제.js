/*
언어: node.js
알고리즘: 반복문
메모리: 10388KB
시간: 1972ms
*/

let input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

const [N, K] = input[0].split(' ').map(Number);

const visited = [...new Array(N)].fill(false);


const answer = [];

let i = 0 ;
let count = 0;

while (answer.length < N) {    
    if (visited[i]) {
        i =((i + 1) % (N))
        continue;
    }
    count ++;
    //만족 시 
    if (count === K) {
    answer.push(i + 1);
    visited[i] = true;
    count = 0;
    }
    i =  ((i + 1) % (N)) ;
}

console.log('<' + answer.join(', ') + '>')