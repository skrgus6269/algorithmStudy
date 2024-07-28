/*
알고리즘: dp
메모리: 24768KB
시간: 248ms
*/

const first_array = input[0];
const second_array = input[1];

const dp = new Array(first_array.length + 1).fill(0).map(() => new Array(second_array.length + 1).fill(0));

for (let i = 1 ; i < dp.length; i++) {
    for (let j = 1 ; j < dp[0].length; j++) {
        if (first_array[i - 1] === second_array[j - 1]) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
    }
}

console.log(dp[dp.length - 1][dp[0].length - 1])