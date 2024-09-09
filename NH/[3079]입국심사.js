const [N, M] = input.splice(0, 1)[0].split(' ').map(Number);

const door = input.map(Number).sort((a, b) => a - b);

let left = BigInt(1);
let right = BigInt(door[door.length - 1] * M);

while (left <= right) {
    const mid = BigInt((BigInt(left) + BigInt(right)) / BigInt(2));

    const count = door.reduce((prev, cur) => {
        return prev + BigInt(BigInt(mid) / BigInt(cur));
    }, BigInt(0));

    if (count < M) {
        left = mid + 1n;
    } else {
        right = mid - 1n;
    }
}

console.log(String(left)); 