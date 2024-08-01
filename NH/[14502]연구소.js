/*
알고리즘: bfs / 브루트포스
메모리: 37296KB
시간: 580ms
*/
const [N, M] = input.splice(0, 1)[0].split(' ').map(Number);

const map = input.map((item) => item.split(' ').map(Number));

const zero_location = [];
const selected_zero_location = [];
const two_location = [];
let max = 0;

//0 위치 찾기
const find_zero_and_two = () => {
    for (let i = 0 ; i < N; i++) {
        for (let j = 0; j < M; j++) { 
            if (!map[i][j]) zero_location.push([i, j])
            if (map[i][j] === 2) two_location.push([i, j])
        }
    }
}

//0 위치 3개 고르기
const select_zero = (index, zero_array) => {
    if (zero_array.length === 3) {
        selected_zero_location.push(zero_array);
        return ;
    }
    for (let i = index + 1; i < zero_location.length; i++) {
        select_zero(i, [...zero_array, zero_location[i]])
    }
}

const x_move = [1, 0, 0, -1];
const y_move = [0, 1, -1, 0];

//바이러스 퍼뜨리기
const spread_virus = (array) => {
    const new_map = map.map((item) => item.slice(0));

    array.forEach((item) => {
        new_map[item[0]][item[1]] = 1;
    });

    const queue = [...two_location]; 
    while (queue.length) {
        const [x, y] = queue.shift();

        for (let i = 0; i < 4; i++) {
            const dx = x + x_move[i];
            const dy = y + y_move[i];

            if (dx < 0 || dy < 0 || dx >= N || dy >= M) continue;

            if (new_map[dx][dy] === 0) {
                queue.push([dx, dy]);
                new_map[dx][dy] = 2;
            }
        }
    }
   return new_map;
}

//안전지대 세기
const get_answer = (new_map) => {
    let count = 0;
    for (let i = 0; i < new_map.length; i++) {
        for (let j = 0; j < new_map[0].length; j++) {
            if (new_map[i][j] === 0) count++;
        }
    }
    return count;
}

find_zero_and_two(); 
select_zero(-1, []);

selected_zero_location.forEach((item) => {
    const new_map = spread_virus(item); 
    max = Math.max(max, get_answer(new_map));
})

console.log(max);


