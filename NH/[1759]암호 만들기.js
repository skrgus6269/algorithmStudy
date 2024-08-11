let input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n'); 
// let input = require('fs').readFileSync('예제.txt').toString().trim().split('\r\n');

const [L, C] = input.splice(0, 1)[0].split(' ').map(Number);

const array = input[0].split(' ');

const sorted_array = array.sort();
 
const check = (array) => {
    let 자음 = 0;
    let 모음 = 0;

    for (let str of array) {
        if (['a', 'e', 'i', 'o', 'u'].indexOf(str) !== -1) {
            모음++;
        } else {
            자음 ++;
        }
    }

    if (자음 >= 2 && 모음 >= 1) return true;
    return false;
}

const dfs = (index, array) => {
    if (array.length === L) {
        if (check(array)) console.log(array.join('')); 
        return ;
    }

    for (let i = index + 1; i < C; i++) {
        dfs(i, [...array, sorted_array[i]]);
    }
}

for (let i = 0; i < C - L + 1; i++) {
    dfs(i, [sorted_array[i]]);
}