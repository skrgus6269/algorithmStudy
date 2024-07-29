/*
알고리즘: bfs
메모리: 30400KB
시간: 2588ms
*/

const [N, M] = input.splice(0, 1)[0].split(' ').map(Number);

const array = input[0].split(' ').map(Number);

const sorted_array = array.sort((a, b) => a- b);

const bfs = (start) => {
    const queue = [start];
    
    while (queue.length) {  
        const node = queue.shift(); 

        if (node.length === M) {
            console.log(node.join(' '));
            continue;
        }

        for (let i = 0 ; i < N; i++) { 
            if (node.includes(sorted_array[i])) continue;
            queue.push([...node, sorted_array[i]]);
        }
    }
}

for (let i = 0 ; i < N; i++) {
    bfs([sorted_array[i]])
}