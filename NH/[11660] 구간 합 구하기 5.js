/*
사용한 알고리즘
1차 : 브루트 포스 (시간 초과)
2차 : 누적합 알고리즘
*/

let input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

const [N, M] = input.splice(0, 1)[0].split(' ').map(Number);

const board = input.splice(0, N).map((item) => item.split(' ').map(Number));
const test = input.map((item) => item.split(' ').map(Number)); 
const newBoard = [... new Array(N + 1)].fill(0).map(() => new Array(N + 1).fill(0));
  
//새로운 배열에 각 위치까지 모든 값을 더한 값을 넣어준다.
for (let i = 1; i <= N; i++) {
   for (let j = 1; j <= N; j++) {
    newBoard[i][j] = newBoard[i - 1][j] + newBoard[i][j - 1] - newBoard[i - 1][j - 1] +  board[i - 1][j - 1]; 
   }
} 

//구간에 해당하는 값의 차를 구해준다.
test.forEach(([x1, y1, x2, y2]) => {
    console.log(newBoard[x2][y2] - newBoard[x1 - 1][y2] - newBoard[x2][y1 - 1] + newBoard[x1 - 1][y1 - 1]);
}) 

