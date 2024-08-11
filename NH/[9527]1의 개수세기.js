//시간초과...

let input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n'); 
// let input = require('fs').readFileSync('예제.txt').toString().trim().split('\r\n');

const [A, B] = input[0].split(' ').map(Number);

const dp = [0, 1, 1, 2, 1, 2, 2];

const getDivider = (num) => {
    for (let i = 1; i < num; i++) {
        if (2**i > num) {
            return 2**(i - 1);
        }
    }
}

for (let i = 3; i <= B; i++) {
    const divider = getDivider(i); 
    if (divider === i) {
        dp[i] = 1;
        continue;
    }
    dp[i] = dp[i - divider] + 1;
}

let sum = 0;

for (let i = A; i <= B; i++) {
    sum += dp[i];    
}

console.log(sum)