/*
알고리즘: 문자열
메모리: 18544KB
시간: 6612ms
*/ 
const N = Number(input.splice(0, 1));

let array = input.map((item) => item.split(' ').map(Number));

let min = Infinity;

const calculate = (stack) => {
    let sum = 0; 

    for (let i = 1 ; i < stack.length; i++) { 
        sum += array[stack[i - 1]][stack[i]];

        if (array[stack[i - 1]][stack[i]] === 0) {
            return Infinity;
        }
    }
    
    return sum;
}

const dfs = (stack) => {
    if (stack.length === N) {
        min = Math.min(min, calculate([...stack, stack[0]])); 
    }

    for (let i = 0; i < N; i++) {
        if (!stack.includes(i)) {
            dfs([...stack, i]);
        }
    }
}

for (let i = 0 ; i < N; i++) {
    dfs([i])
}

console.log(min)