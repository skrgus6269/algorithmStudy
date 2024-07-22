/*
알고리즘: 문자열
메모리: 12580KB
시간: 792ms
*/
const N = Number(input.splice(0, 1));

const array = input.map((item) => item.split(' ').map(Number));
 
let answer = 0;

if (array[N - 1][N - 1]) {
    console.log(0);
    return ;
}

const bfs = () => {
    const queue = [[0, 1, '가로']];
 
    while (queue.length) {  
        const [x, y, previous] = queue.pop(); 
         
        if (x === N - 1 && y === N - 1) { 
            answer++;
            continue;
        }

        if (previous === '가로') {
            //대각선, 가로만 가능
            if (x + 1 < N && y + 1 < N  && !array[x + 1][y + 1] && !array[x][y + 1] && !array[x + 1][y]) queue.push([x + 1, y + 1, '대각선']);
            if (y + 1 < N && !array[x][y + 1]) queue.push([x, y + 1, '가로']);
        }
        if (previous === '세로') {
            //대각선, 세로만 가능
            if (x + 1 < N && y + 1 < N  && !array[x + 1][y + 1]  && !array[x][y + 1]  && !array[x + 1][y] ) queue.push([x + 1, y + 1, '대각선']);
            if (x + 1 < N && !array[x + 1][y]) queue.push([x + 1, y, '세로']);
        }       
        if (previous === '대각선') {
            //세로, 가로, 대각선 가능
            if (x + 1 < N  && !array[x + 1][y] ) queue.push([x + 1, y, '세로']);
            if (y + 1 < N  && !array[x][y + 1] ) queue.push([x, y + 1, '가로']);
            if (x + 1 < N && y + 1 < N && !array[x + 1][y + 1]  && !array[x][y + 1]  && !array[x + 1][y] ) queue.push([x + 1, y + 1, '대각선']);
        }
    }
}

bfs()

console.log(answer);