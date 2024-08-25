let input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
 
const N = Number(input.shift());

const room = input.map((item) => item.split(' ').map(Number));
 
room.sort((a, b) => {
    if (a[1] > b[1]) return 1;
    else if (a[1] < b[1]) return -1;
    else {
        if (a[0] > b[0]) return 1;
        return -1;
    }
})
 
let end = room[0][1];
let result = 1;

for (let i = 1; i < room.length; i++) {
    const [from, to] = room[i];

    if (from >= end) {
        end = to;
        result ++;
    }
}

console.log(result)