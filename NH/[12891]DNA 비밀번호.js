/*
1차 : 브루트 포스 (시간 포과)
2차 : 슬라이딩 윈도우
메모리 12304KB
시간 196ms
*/
let input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

const [S, P] = input.splice(0, 1)[0].split(' ').map(Number);

const string = input[0];

const [A, C, G, T] = input[1].split(' ').map(Number);

const charCounts = [0, 0, 0, 0];

const check = () => { 
    if (charCounts[0] >= A && charCounts[1] >= C && charCounts[2] >= G && charCounts[3] >= T) return true;
    return false;
}

const charToIndex = (str) => {
    if (str === 'A') return 0;
    if (str === 'C') return 1;
    if (str === 'G') return 2;
    if (str === 'T') return 3; 
}

for (let i = 0; i < P; i++) charCounts[charToIndex(string[i])] += 1;

let count = 0;

count = check()? count + 1: count;     

for (let i = 0; i < S - P; i++) {
    charCounts[charToIndex(string[i])] -= 1;
    charCounts[charToIndex(string[i + P])] += 1;
    count = check()? count + 1: count;    
}

console.log(count);