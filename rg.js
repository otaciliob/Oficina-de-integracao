var num = [1,3,6,8,0,6,4,6];

function validar(){
    let result = 0;
    for(let i = 0;i < num.length;i++){
        result = result + (num[i] * (2+i));
        //console.log(result);
    }
    console.log(result);
    return result;
}

var mod = validar() % 11;
console.log(mod)

console.log(11 - mod)
