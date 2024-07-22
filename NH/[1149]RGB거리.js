/*
알고리즘: 문자열
메모리: 9784KB
시간: 100ms
*/ 
const N = Number(input.splice(0, 1));

const array = input.map((item) => item.split(' ').map(Number));

let dp = new Array(N).fill(0).map(() => new Array(3).fill(0));

dp[0] = array[0];

for (let i = 1 ; i < array.length; i++) {
    const [R, G, B] = array[i];
 
    dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + R;
    dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + G;
    dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + B;
}

console.log(Math.min(...dp[dp.length - 1]));
