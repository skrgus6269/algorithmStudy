/*
알고리즘: 이분 탐색
메모리: 12324KB
시간: 220ms
*/
let [_N, K] = input.splice(0, 1)[0].split(' ').map(Number);

const array = input.map((item) => Number(item)); 

const checking = (divider) => {
    let sum = 0;
    for (let num of array) {
        sum += Math.floor(num / divider);
    }
    return sum;
}

let left = 0;
let right = Math.max(...array);
let answer = 0;

while (left <= right) {
    const mid = Math.floor((left + right) / 2);
    const count = checking(mid);
    
    if (count < K) {
        right = mid - 1;
    } else { 
        answer = Math.max(mid, answer);
        left = mid + 1;
    }
}

console.log(answer);