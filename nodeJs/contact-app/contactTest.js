let readlineSync = require('readline-sync');

let Contact = require('./contact');
let ContactService = require('./contactDbService');

let contactServiceObject = new ContactService('contactData.json');

let boolean = true;

while (boolean) {
    console.log('\n\n------------');

    console.log('1.Add Contact');
    console.log('2.Display Contact');
    console.log('3.Exit');
    let choice = readlineSync.question('---Enter Your Choice = ');

    switch (choice) {
        case '1':
            let contactObject = new Contact();
            contactObject.id = readlineSync.question('---Enter Id = ');
            contactObject.name = readlineSync.question('---Enter Name = ');
            contactObject.contactNumber = readlineSync.question('---Enter Contact Number = ');

            contactServiceObject.addContact(contactObject);

            break;
        case '2':
            contactServiceObject.displayContact();
            break;
        case '3':
            console.log('exit');
            boolean = false;
            break;
        default:
            console.log('enter proper choice');
    }
}