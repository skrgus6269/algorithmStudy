/*
알고리즘: bfs
메모리: 14204KB
시간: 300ms
*/

const N = Number(input.splice(0, 1));

let array = input.map((item) => item.split(' ').map(Number));

let time = 0; //시간
let shark_size = 2; //상어 크기
let eated_fish = 0; //먹은 물고기 개수 (레벨업 하면 초기화)  
let x_sample = [1, 0, 0, -1];
let y_sample = [0, 1, -1, 0];

const check_shark_location = () => {
    let result = []
    array.forEach((item, index) => {
        item.forEach((items, indexs) => {
            if (items === 9) result = [index, indexs];
        })
    }); 
    return result;
}

let shark_location = check_shark_location();
 
let visited = new Array(N).fill(0).map(() => new Array(N).fill(false));

//끝났는지 체크 (true: 안끝남, false: 끝남)
let checkEnd = true;

//가장 가까이 있는 노드 체크
//우선순위 : 위 -> 왼
const bfs = (start) => { 
    visited = new Array(N).fill(0).map(() => new Array(N).fill(false)); 
    const queue = [start];
    const success_array = [];
    while (queue.length) {   
        const [x, y, count] = queue.shift(); 
        if (visited[x][y]) continue;

        visited[x][y] = true;

        if (count >= 1 && array[x][y] !== 0 && array[x][y] < shark_size && array[x][y] !== 9) {
            success_array.push([x, y, count]);
            continue;
        }
        
        for (let i = 0; i < 4; i++) {
            const dx = x + x_sample[i];
            const dy = y + y_sample[i];
            
            if (dx < 0 || dy < 0 || dx >= N || dy >= N ||( array[dx][dy] > shark_size && array[dx][dy] !== 9)) continue;

            queue.push([dx, dy, count + 1]);
        }
    }
    
    const sorted_success_array = success_array.sort((a,b) => {
        if (a[2] > b[2]) return 1;
        else if (a[2] < b[2]) return -1;
        else {
            if (a[0] > b[0]) return 1;
            else if (a[0] < b[0]) return - 1;
            else {
                if (a[1] > b[1]) return 1;
                else return -1;
            }
        }
    });

    if (sorted_success_array.length === 0) {
        checkEnd = false;
        console.log(time)
        return;
    } 
  
    shark_location = [sorted_success_array[0][0], sorted_success_array[0][1]];
    array[sorted_success_array[0][0]][sorted_success_array[0][1]] = 0;
    time += sorted_success_array[0][2];
    eated_fish ++;
    if (eated_fish === shark_size) {
        shark_size++;
        eated_fish = 0;
    }
}

// 상어 위치에서 시작 
while (checkEnd) {
    bfs([...shark_location, 0]);
}