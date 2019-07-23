let account = require('./classExports');
let account1 = new account('darshan', '120000111222010', 2000);
account1.displayInfo();

account1.on('balanceChanged', (newBalance) => {
    console.log('Balance Changed');
    console.log(newBalance);
});
account1.deposit(600);
account1.withdraw(1200);