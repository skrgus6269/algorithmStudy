/*
알고리즘: bfs
메모리: 64648KB
시간: 3204ms
특이사항: 비어있지는 않은데 시작점이 없는 예외처리를 안해서 자꾸 틀림
*/
const [M, N, H] = input.splice(0, 1)[0].split(' ').map(Number);

const array = input.map((item) => item.split(' ').map(Number));

const tomato_map = [];

const z_sample = [0, 0, 0, 0, 1, -1];
const x_sample = [0, 1, -1, 0, 0, 0];
const y_sample = [1, 0, 0, -1, 0, 0];

//층마다 토마토 맵 생성
while (array.length) {
    tomato_map.push(array.splice(0, N));
};

const bfs = (start) => {
    const queue = [start];
 
    while (queue.length) {  
        const [z, y, x] = queue.shift();

        for (let j = 0; j < 6; j++) {
            const dx = x + x_sample[j];
            const dy = y + y_sample[j];
            const dz = z + z_sample[j];

            if (dx < 0 || dy < 0 || dz < 0 || dx >= M || dy >= N || dz >= H || tomato_map[dz][dy][dx] === -1) continue;
            
            //값이 0보다 큰 값이 있는 경우
            if (tomato_map[dz][dy][dx] > 0) {
                //있는 값이 기존 값 + 1 보다 작다면 대입
                if (tomato_map[dz][dy][dx] > tomato_map[z][y][x] + 1) {
                    tomato_map[dz][dy][dx] = tomato_map[z][y][x] + 1; 
                    queue.push([dz, dy, dx]);  
                }
            } 
            //값이 0인 경우
            else { 
                tomato_map[dz][dy][dx] = tomato_map[z][y][x] + 1;
                queue.push([dz, dy, dx]);  
            }
        } 
    }
};

let no_start = true;
let no_start_but_tomato_exist = true;

const check_start = () => {
    for (let i = 0; i < H; i++) {
        for (let j = 0; j < N; j++) {
            for (let k = 0; k < M; k++) {
                if (tomato_map[i][j][k] === 1) {
                    bfs([i, j ,k]);
                    no_start = false;
                    no_start_but_tomato_exist = false;
                }
                if (tomato_map[i][j][k] === 0) {
                    no_start_but_tomato_exist = false;
                }
            }
        }
    }
}

const check_answer = () => {
    let max = 0;

    for (let i = 0; i < H; i++) {
        for (let j = 0; j < N; j++) {
            for (let k = 0; k < M; k++) {
                if (tomato_map[i][j][k] === 0) { 
                    return -1;
                }
                if (max < tomato_map[i][j][k]) {
                    max = tomato_map[i][j][k];
                }

            }
        }
    }
    return max - 1;
}

check_start();

if (no_start) {
    if (!no_start_but_tomato_exist) {
        console.log(-1);
        return ;
    }
    console.log(0);
    return;
}

if (no_start_but_tomato_exist) {
    console.log(-1);

}
// console.log(tomato_map)
console.log(check_answer()); 