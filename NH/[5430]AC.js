/*
알고리즘: 문자열
메모리: 35356KB
시간: 4184ms
*/
const T = Number(input.splice(0, 1)[0]);

//테스트 케이스 개수만큼 실행
for (let p = 0; p < T * 3; p+=3) {
    let reverseState = false;
    const command = input[p];
    let array = input[p + 2].substring(1, input[p + 2].length - 1).split(',')
    let flag = 1;
    for (let str of command) {
        if (str === 'R') {
            reverseState = !reverseState;
        } else {
           if (array.length === 0 || array[0] === '') {
            console.log('error');
            flag = 0 ;
            break;
           }

           if (!reverseState) array.splice(0, 1);
           if (reverseState) array.pop();
        }
    } 

    if (flag) {
        if (reverseState) console.log('[' + array.reverse().join(',') + ']')
        else console.log('[' + array.join(',') + ']') 
    }
}