let input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n'); 
// let input = require('fs').readFileSync('예제.txt').toString().trim().split('\r\n');
 
const array = input[0].split(''); 
let bomb = input[1];
const stack = [];

array.forEach((item) => {  
    if (stack.slice(stack.length - bomb.length + 1).join('') + item === bomb) {
        for (let i = 0; i < bomb.length - 1; i++) stack.pop();
    } else stack.push(item); 
})

console.log(stack.length?stack.join(''):'FRULA');
 