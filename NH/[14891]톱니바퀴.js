let arr = input.slice(0, 4).map(e => e.split('').map(Number));
const N = input[4];
const command = input.slice(5).map(e => e.split(' ').map(Number));

const rotateL = (pos, dir) => {
  let result = [];
  let posBolt = arr[pos - 1];
  let leftList = arr.slice(0, pos - 1);
  for (let i = leftList.length - 1; i >= 0; i--) {
    let leftBolt = leftList[i];
    let nextCur;
    if (posBolt[6] !== leftBolt[2]) {
      if (dir === 1) {
        nextCur = [...leftBolt.slice(1), leftBolt[0]];
        posBolt = leftBolt;
        dir = -1;
        result.push([i, nextCur]);
      }
      else {
        nextCur = [leftBolt.at(-1), ...leftBolt.slice(0, 7)];
        posBolt = leftBolt;
        dir = 1;
        result.push([i, nextCur]);
      }
    } else {
      break;
    }
  }
  return result;
};

const rotateR = (pos, dir) => {
  let result = [];
  let posBolt = arr[pos - 1];
  let rightList = arr.slice(pos);
  
  for (let i = 0; i < rightList.length; i++) {
    let rightBolt = rightList[i];
    let nextCur;
    if (posBolt[2] !== rightBolt[6]) {
      if (dir === 1) {
        nextCur = [...rightBolt.slice(1), rightBolt[0]];
        posBolt = rightBolt;
        dir = -1;
        result.push([i, nextCur]);
      }
      else {
        nextCur = [rightBolt.at(-1), ...rightBolt.slice(0, 7)];
        posBolt = rightBolt;
        dir = 1;
        result.push([i, nextCur]);
      }
    } else {
      break;
    }
  }
  return result;
};

for (let i = 0; i < N; i++) {
  const [pos, dir] = command[i];
  const right = rotateR(pos, dir);
  const left = rotateL(pos, dir);
  if (right.length > 0) {
    right.forEach(e => {
      const [idx, a] = e;
      arr[pos + idx] = a;
    });
  }
  if (left.length > 0) {
    left.forEach(e => {
      const [idx, a] = e;
      arr[idx] = a;
    });
  }
  if (dir === 1) {
    arr[pos - 1] = [arr[pos - 1].at(-1), ...arr[pos - 1].slice(0,7)];
  }
  else {
    arr[pos - 1] = [...arr[pos - 1].slice(1, 8), arr[pos - 1][0]];
  }
}
console.log(`${arr.reduce((acc, cur, idx) => acc + (cur[0] === 1 ? 2 ** idx : 0), 0)}`)