let input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n'); 
// let input = require('fs').readFileSync('예제.txt').toString().trim().split('\r\n');
 
let eratos = new Array(Number(input[0]) + 1).fill(1);

const target = Number(input[0]);

const prime = [];

let answer = 0;

// 소수 판별
const checkPrime = (num) => {
    for (let i = 2; i < Math.sqrt(num); i++) {
        if (num % i === 0) {
            return false;
        }
    }
    return true;
}

//소수 추출
const makeEratos = () => {
    for (let i = 2; i < target + 1; i++) {
        if (eratos[i] && checkPrime(i)) {
            prime.push(i);
            for (let j = i * i; j < target + 1; j += i) {
                eratos[j] = 0;
            }
        }
    }
}

const getSum = (start, end) => {
    let sum = 0;
    for (let i = start; i < end; i++) {
        sum += prime[i];
    }
    return sum;
}


const calculate = () => {
    let left = 0;
    let right = 0;

    while (left < target && right < target) {
        const sum = getSum(left, right);

        if (sum === target) { 
            answer++;
            right++;
        } else if (sum <= target) {
            right ++;
        } else {
            left++;
        }   
    }
}

makeEratos();
calculate(); 

console.log(answer)