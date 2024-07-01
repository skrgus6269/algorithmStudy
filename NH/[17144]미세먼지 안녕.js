/*
알고리즘: 구현
메모리: 16524KB
시간: 484ms
*/
const [R, C, T] = input.splice(0, 1)[0].split(' ').map(Number);

let array = input.map((item) => item.split(' ').map(Number));

const x = [1, -1, 0, 0];
const y = [0, 0, 1, -1];

//확산
const spread = () => {
    const board = array.map((item) => item.slice(0));
    
    for (let i = 0; i < R; i++) {
        for (let j = 0 ; j < C; j++) {
            if (board[i][j] && board[i][j] >= 5) {
                for (let k = 0; k < 4; k++) {
                    if (i + x[k] >= R || i + x[k] < 0 || j + y[k] >= C || j + y[k] < 0) continue; 
                    if (board[i + x[k]][j + y[k]] === - 1) continue;
                    board[i + x[k]][j + y[k]] += Math.floor(array[i][j] / 5);
                    board[i][j] -=  Math.floor(array[i][j] / 5);
                }
            }
        }
    }
    array = board
}

const check_air_conditioner_location = () => {
    for (let i = 0 ; i < array.length; i++) {
        for (let j = 0; j < array[0].length; j++) {
            if (array[i][j] === -1) return [i, j];
        }
    }
}

//공기 청정기 작동
const air_conditioner = (air_x, air_y) => {
    let new_board = array.map((item) => item.slice(0)); 
    //위
    //위의 아래 
    for (let i = 1; i < C; i++) { 
        if (new_board[air_x][i - 1] === -1) {
            new_board[air_x][i] = 0
            continue;
        }
        new_board[air_x][i] = array[air_x][i - 1];
    }   
    //위의 오른쪽
    for (let i = 0; i < air_x; i++) {
        new_board[i][C - 1] = array[i + 1][C - 1];
    } 
    //위의 위쪽
    for (let i = 0; i < C - 1; i++) {
        new_board[0][i] = array[0][i + 1];
    }
    //위의 왼쪽
    for (let i = 1; i < air_x; i++) {
        new_board[i][0] = array[i - 1][0];
    } 
    //아래
    //아래의 위
    for (let i = 1 ; i < C ; i++) {
        if (i === 1) {
            new_board[air_x + 1][i] = 0;
            continue;
        }
        new_board[air_x + 1][i] = array[air_x + 1][i - 1]; 
    } 
    //아래의 오른쪽
    for (let i = air_x + 2; i < R; i++) {
        new_board[i][C - 1] = array[i - 1][C - 1];
    }
    //아래의 아래
    for (let i = 0; i < C - 1; i++) {
     
        new_board[R - 1][i] = array[R - 1][i + 1];
    }
    //아래의 왼쪽
    for (let i = air_x + 2; i < R - 1; i++) {
        new_board[i][0] = array[i + 1][0];
    }
    array = new_board
}

const [air_x, air_y] = check_air_conditioner_location();

for (let i = 0; i < T; i++) {
    spread();  
    air_conditioner(air_x, air_y);  
}

const calculate = () => {
    let sum = 0; 
    for (let i = 0; i < array.length; i++) {
        for (let j = 0 ; j < array[0].length; j++) {
            sum += array[i][j];
        }
    }
    console.log(sum + 2)
}

calculate();