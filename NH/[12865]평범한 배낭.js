/*
알고리즘: dp
메모리: 10680KB
시간: 208ms
*/ 
const [N, K] = input.splice(0, 1)[0].split(' ').map(Number);

const array = input.map((item) => item.split(' ').map(Number));

const dp = new Array(K + 1).fill(0);

for (let arrays of array) {
    const [w, v] = arrays;

    for (let i = K; i >= w; i--) {
        if (dp[i - w] + v > dp[i]) {
            dp[i] = dp[i - w] + v;
        }
    }
}

console.log(dp[K])