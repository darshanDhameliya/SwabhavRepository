import{employee,address}from './employee';
let address1=new address('varachha','surat','gujarat');
let employee1=new employee(101,'darshan',address1);
console.log(employee1.Id);
employee1.Id=1001;
console.log(employee1);