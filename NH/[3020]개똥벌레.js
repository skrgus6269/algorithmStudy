/*
알고리즘: 문자열
메모리: 38328KB
시간: 312ms
*/
const [N, H] = input.splice(0, 1)[0].split(' ').map(Number);

const array = input.map(Number);

const 석순 = new Array(H + 1).fill(0);
const 종유석 = new Array(H + 1).fill(0);

for (let i = 0; i < N; i++) {
    if (i % 2 === 0) {
        종유석[array[i]]++;
    } else {
        석순[H  + 1 - array[i]]++;
    }
}

for (let i = 1; i <= H; i++) {
    석순[i] += 석순[i - 1];
    종유석[H - i] += 종유석[H - i + 1]
}

let min = Infinity;
let count = 0;

for (let i = 1; i <= H; i++) {
    const sum = 종유석[i] + 석순[i] 

    if (min > sum) {
        min = sum;
        count = 1;
    } 
    else if (min === sum) {
        count ++;
    }
}

console.log(min, count)