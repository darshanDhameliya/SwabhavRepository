function add(number1, number2) {
    return new Promise((resolve, reject) => {
        if (number1 < 0 || number2 < 0)
            reject({ error: 'value is negative' });
        resolve(number1 + number2);
    });
}

async function main() {
    let result1 = await add(10, 20);
    console.log("result 1 : " + result1);

    let result2 = await add(result1, result1);
    console.log("result 2 : " + result2);
}
main();
console.log('End Program');