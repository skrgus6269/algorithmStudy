/*
알고리즘: 분할 정복
메모리: 10540KB
시간: 176ms
*/
const N = Number(input.shift());
const array = input.map((item) => item.split('').map(Number));


const answer = [];

const check = (num, x, y) => {
    let sum = 0;

    for (let i = 0; i < num; i++) {
        for (let j = 0; j < num; j++) { 
            sum += array[x + i][y + j];  
        }
    }

    return sum;
}

const divider = (num, x, y) => { 
    if (check(num, x, y) === 0) {
        answer.push(0);
    }
    else if (check(num, x, y) === num * num) {
        answer.push(1);
    } else { 
        if (num === 1) return ;
        num /= 2;
        answer.push('(');
        divider(num, x, y);
        divider(num, x, y + num);
        divider(num, x + num, y);
        divider(num, x + num, y + num);
        answer.push(')');
    }
}

divider(N, 0, 0);

console.log(answer.join(''));