'use strict';
let EventEmitter = require('events');
class account extends EventEmitter {

    constructor(accountName, accountNumber, balance) {
        super();
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.MIN_BALANCE = 500;
    }
    displayInfo() {
        console.log('Account Name :- ' + this.accountName);
        console.log('Account Number :- ' + this.accountNumber);
        console.log('Account Balance :- ' + this.balance);
    };
    deposit(amount) {
        console.log("--------------------");
        console.log("Old Balance :- " + this.balance);
        this.balance += amount;
        console.log("Deposit :- " + amount);
        this.emit('balanceChanged', this.balance);
    };
    withdraw(amount) {
        console.log("--------------------");
        if (this.checkMinimumBalance(amount)) {
            console.log("Old Balance :- " + this.balance);
            this.balance -= amount;
            console.log("Withdraw :- " + amount);
            this.emit('balanceChanged', this.balance);
            return;
        }
        console.log('Not Withdraw');
    };
    checkMinimumBalance(amount) {
        if (this.balance - amount < this.MIN_BALANCE)
            return false;
        return true;
    };
}
module.exports = account;