const n = parseInt(input[0]);
const fruit = input[1].split(' ').map(Number);

let left = 0, right = 1;
let kind = [fruit[0]];
let answer = 0;
let next_left = 0;

while (right < n) {
    if (kind.length === 1) {
        if (!kind.includes(fruit[right])) {
            kind.push(fruit[right]);
        }
    } else {
        if (!kind.includes(fruit[right])) {
            answer = Math.max(answer, right - left);
 
            for (let i = 0; i < kind.length; i++) {
                if (kind[i] !== fruit[next_left]) {
                    kind.splice(i, 1);
                    break;
                }
            }

            kind.push(fruit[right]);
            left = next_left;
        }
    }

    if (fruit[right - 1] !== fruit[right]) {
        next_left = right;
    }
    right++;
}

answer = Math.max(answer, n - left);
console.log(answer);
