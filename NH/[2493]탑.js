/*
알고리즘: 스택
메모리: 120188KB
시간: 484ms
*/

const N = Number(input.shift());
const array = input[0].split(' ').map(Number);
const stack = [];
const answer = [];

for (let i = 0; i < N; i++) { 

    //스택 맨 위 값이 타워보다 작다면 계속 pop 해준다.
    while (stack.length && array[stack[stack.length - 1]] < array[i]) {
        stack.pop();
    }

    //스택이 비어있다면 0 출력
    if (!stack.length) {
        answer.push(0)
    } else { 
        answer.push(stack[stack.length - 1] + 1)
    }

    stack.push(i);
}

console.log(answer.join(' '));