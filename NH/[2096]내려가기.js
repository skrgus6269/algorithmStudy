/*
알고리즘: dp
특이사항: node.js 메모리 초과로 인해 문제 해결 불가능 
*/
const N = Number(input.splice(0, 1)[0]);

const array = input.map((item) => item.split(' ').map(Number));
 
let max_dp = new Array(N).fill(0).map(() => new Array(3).fill(0));
let min_dp = new Array(N).fill(0).map(() => new Array(3).fill(0));
 
max_dp[0] = array[0];
min_dp[0] = array[0];
 
for (let i = 1; i < N; i++) {
    max_dp[i][0] = Math.max(max_dp[i - 1][0], max_dp[i - 1][1]) + array[i][0];
    max_dp[i][1] = Math.max(max_dp[i - 1][0], max_dp[i - 1][1], max_dp[i - 1][2]) + array[i][1];
    max_dp[i][2] = Math.max(max_dp[i - 1][1], max_dp[i - 1][2]) + array[i][2];

    min_dp[i][0] = Math.min(min_dp[i - 1][0], min_dp[i - 1][1]) + array[i][0];
    min_dp[i][1] = Math.min(min_dp[i - 1][0], min_dp[i - 1][1], min_dp[i - 1][2]) + array[i][1];
    min_dp[i][2] = Math.min(min_dp[i - 1][1], min_dp[i - 1][2]) + array[i][2];
}

console.log(Math.max(...max_dp[N - 1]), Math.min(...min_dp[N - 1])) 