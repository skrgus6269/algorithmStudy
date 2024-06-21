/*
언어: javascript
사용한 알고리즘: dfs
1차 시도 : 메모리 초과 
node.js로는 풀 수 없다네요..
*/
// let input = require('fs').readFileSync('예제.txt').toString().trim().split('\r\n');
let input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

const length = Number(input[0]);

//소수 검증 
const checkPrime = (number) => { 
    if (number === 1) return false;

    for (let i = 2; i < Math.sqrt(number); i++) {
        if (number % i === 0) {
            return false;
        }
    }
    return true;
} 

const dfs = (number) => { 
    if (String(number).length === length) {
        console.log(number);
        return ;
    }
    //2번째 자리부터는 1,3,7,9 만 올 수 있음
    if (checkPrime(Number(String(number)  + '1'))) dfs(Number(String(number)  + '1'))  
    if (checkPrime(Number(String(number)  + '3'))) dfs(Number(String(number)  + '3'))  
    if (checkPrime(Number(String(number)  + '7'))) dfs(Number(String(number)  + '7')) 
    if (checkPrime(Number(String(number)  + '9'))) dfs(Number(String(number)  + '9')) 
}
 
//첫자리는 소수인 2,3,5,7만 올 수 있음
dfs(2) 
dfs(3) 
dfs(5) 
dfs(7)   