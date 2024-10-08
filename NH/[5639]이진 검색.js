    const input = [];
    const stack = [];
    const result = [];
    
    stack.push([0, input.length - 1]);
    while (stack.length) {
      const [start, end] = stack.pop();
      if (start > end) {
        continue;
      }
 
      let pivot;
      for (let i = start + 1; i <= end; i++) {
        if (input[i] < input[start]) {
          continue;
        }
        pivot = i;
        break;
      }
 
      if (pivot) { 
        stack.push([start + 1, pivot - 1]); 
        stack.push([pivot, end]);
      } else { 
        stack.push([start + 1, end]);
      } 
      result.unshift(input[start]);
    }
    console.log(result.join('\n')); 