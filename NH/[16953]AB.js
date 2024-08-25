let input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
// let input = require('fs').readFileSync('예제.txt').toString().trim().split('\r\n');

const N = Number(input.splice(0, 1)[0]);

const array = input.map((item) => item.split(' ').map(Number));

const dp = new Array(N).fill(0).map((_item,index) => new Array(index + 3).fill(0));
 
dp[0][1] = array[0][0];

for (let i = 1; i < N; i++) {
    for (let j = 1; j <= (i + 1); j++) {
        dp[i][j] = array[i][j - 1] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
    }
}

console.log(Math.max(...dp[N - 1]));
