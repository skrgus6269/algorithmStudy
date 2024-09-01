const N = Number(input.splice(0, 1)[0]);

const bridge = input[0].split(' ').map(Number);

let dp = new Array(N + 1).fill(0);

dp[0] = 0;
dp[1] = Math.abs(bridge[1] - bridge[0]) + 1;

for (let i = 2; i < N; i++) {
    let minPower = Number.MAX_SAFE_INTEGER; // JavaScript에서의 안전한 최대 정수값
    let idx = -1; // 최솟값 인덱스
    for (let j = 0; j < i; j++) {
        let power = (i - j) * (Math.abs(bridge[i] - bridge[j]) + 1);
        power = Math.max(power, dp[j]); // 최솟값을 power로 설정
        // 가장 작은 값을 d[i]로 설정
        if (minPower >= power) {
            minPower = power;
            idx = j;
        }
    }
    dp[i] = minPower;
}  

console.log(dp[N - 1]);