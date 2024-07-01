/*
알고리즘: 구현
메모리: 45908KB
시간: 1148ms
*/ 

let input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
// let input = require('fs').readFileSync('예제.txt').toString().trim().split('\r\n');
//  
const [N, M, R] = input.splice(0, 1)[0].split(' ').map(Number);

let board = input.map((item) => item.split(' ').map(Number));

const rotate = () => {
    const new_board = board.map((item) => item.slice(0));  
    for (let depth = 0; depth < Math.min(N, M) / 2; depth++) {
            //위
            for (let i = depth; i < M - depth - 1; i++) {
                new_board[depth][i] = board[depth][i + 1];
            } 
              //왼
            for (let i = depth + 1; i < N - depth; i++) {
                new_board[i][depth] = board[i - 1][depth];``
            }  
              //아래
            for (let i = depth + 1; i < M - depth ; i++) {  
                new_board[N - depth - 1][i] = board[N - depth - 1][i - 1]; 
            }  
              //오
            for (let i = depth ; i < N - depth - 1; i++) {
                new_board[i][M - depth - 1] = board[i + 1][M - depth - 1];  
            }  
    }
     return new_board
}
 
    for (let j = 0; j < R; j++) { 
        board = rotate();
    }

board.forEach((item) => {
    console.log(item.join(' '));
})