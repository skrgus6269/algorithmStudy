const data = in2.map((el) => el.split(" ").map(Number));
const answer = [];

const bfs = (A, B) => {
  const queue = [[A, ""]];
  const isVisited = { [A]: true };

  while (queue.length) {
    const [num, order] = queue.shift();

    if (num === B) {
      answer.push(order);
      return;
    }

    const newD = (num * 2) % 10000;
    if (!isVisited[newD]) {
      queue.push([newD, order + "D"]);
      isVisited[newD] = true;
    }

    const newS = num === 0 ? 9999 : num - 1;
    if (!isVisited[newS]) {
      queue.push([newS, order + "S"]);
      isVisited[newS] = true;
    }

    const newL = (num % 1000) * 10 + Math.floor(num / 1000);
    if (!isVisited[newL]) {
      queue.push([newL, order + "L"]);
      isVisited[newL] = true;
    }

    const newR = (num % 10) * 1000 + Math.floor(num / 10);
    if (!isVisited[newR]) {
      queue.push([newR, order + "R"]);
      isVisited[newR] = true;
    }
  }
};

for (let el of data) {
  const [A, B] = el;
  bfs(A, B);
}

console.log(answer.join("\n"));