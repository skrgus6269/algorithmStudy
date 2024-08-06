/*
알고리즘: 문자열
메모리: 11828KB
시간: 192ms
특이사항: for문 안에 substring()을 사용하려고 했는데, O(n*n)으로 시간 초과가 났다. 그래서 변수를 활용해 O(n)으로 해결했다. 
*/
const N = Number(input[0]);

const M = Number(input[1]);

const string = input[2];

let answer = 0;
let string_count = 0;

for (let i = 1; i < M - 1; i++) {
   if (string[i - 1] === 'I' && string[i] === 'O' && string[i + 1] === 'I') {
    string_count++;
    if (string_count === N) {
        string_count --;
        answer++;
    }
    i++;
   } else {
    string_count = 0;
   }
}

console.log(answer);