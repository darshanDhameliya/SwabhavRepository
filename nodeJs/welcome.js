console.log("Welcome to nodeJs");
// console.log(window);
console.log(global);

console.log(this);

console.log(typeof global);

f1();

function f1() {
    console.log("inSide function f1");
}
var foo = "hello";
console.log(this == global);