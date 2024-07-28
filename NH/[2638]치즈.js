/*
알고리즘: bfs / dfs
메모리: 14448KB
시간: 588ms
*/

const [N, M] = input.splice(0, 1)[0].split(' ').map(Number);

let array = input.map((item) => item.split(' ').map(Number)); 
  
const x_sam = [1,0,0,-1];
const y_sam = [0,1,-1,0];

const bfs = () => {
    
    const queue = [[0, 0]];

    while (queue.length) {
        const [x, y] = queue.shift();

        if (array[x][y]) continue;
        array[x][y] = 2;

        for (let i = 0 ; i < 4; i++) {
            const dx = x + x_sam[i];
            const dy = y + y_sam[i];

            if (dx < 0 || dy < 0 || dx >= N || dy >= M) continue;
            queue.push([dx, dy]);
        } 
    }
}
 
const delete_array = () => {
    for (let i = 0 ; i < array.length; i++) {
        for (let j = 0 ; j < array[0].length; j++) {
            if (array[i][j] === 1) {
                let count = 0;
                for (let k = 0 ; k < 4; k++) {
                    const dx = i + x_sam[k];
                    const dy = j + y_sam[k];

                    if (dx < 0 || dy < 0 || dx >= N || dy >= M) continue;

                    if (array[dx][dy] === 2) count++;
                } 
                if (count >= 2) array[i][j] = 0;
            }
        }
    } 

    for (let i = 0; i < N; i++) {
        for (let j = 0; j < M; j++) {
            if (array[i][j] === 2) {
                array[i][j] = 0;
            }
        }
    }
}

let i = 0;

while (array.some((item) => item.some((items) => items === 1))) {
    //끝나는 조건 (1이 모두 사라졌을 때) 
    bfs();
    delete_array();
    i++; 
}
   
console.log(i)