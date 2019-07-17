"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var employee_1 = require("./employee");
var address1 = new employee_1.address('varachha', 'surat', 'gujarat');
var employee1 = new employee_1.employee(101, 'darshan', address1);
console.log(employee1.Id);
employee1.Id = 1001;
console.log(employee1);
