var person = require('./classExports');

console.log('class exports');

var person1 = new person('darshan', 'dhameliya');

console.log(person1.fullName());