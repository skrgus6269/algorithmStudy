/* 
알고리즘: 브루트 포스를 활용
*/ 
let input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

const N = input.splice(0,1)[0];

const recipe = input.map((item) => item.split(' ').map(Number))
 let min = 999999999;

const calculate = (array) => {
    let sum = 0;
    let mul = 1; 
    array.forEach((item) => {
        const [a, b] = recipe[item];
        sum += b;
        mul *= a;
    }) 
    min = Math.min(Math.abs(sum - mul), min) 
}

const dfs = (index, array) => {
    calculate(array);
    if (array.length === N) return ;
    for (let i = index + 1; i < N; i++) {
        dfs(i ,[...array, i]);
        dfs(i , array);
    }
}

for (let i = 0; i <= N - 1; i++) {
    dfs(i, [i])
}

console.log(min)
     