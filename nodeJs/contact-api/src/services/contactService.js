let fs = require('fs');
class ContactService {
    constructor() {
        this.contactList = [];
        this.data = [];
    }

    addContact(contact) {
        return new Promise((resolve, reject) => {

            this.readData()
                .then(
                    (result) => {
                        this.contactList = JSON.parse(result);
                        this.contactList.push(contact);
                        let data = JSON.stringify(this.contactList);
                        this.writeData(data);
                        resolve('success');
                    }
                ).catch(
                    (error) => {
                        reject('error');
                    }
                );
        });
    }

    writeData(data) {
        fs.writeFileSync('./repository/contactData.json', data, 'utf8');
    }

    readData() {
        return new Promise((resolve, reject) => {
            fs.readFile('./repository/contactData.json', (error, data) => {
                if (data) {
                    resolve(data);
                }
                reject(error);
            })
        })
    }

    deleteContact(id) {
        return new Promise((resolve, reject) => {
            this.readData().then(
                (data) => {
                    this.contactList = JSON.parse(data);
                    for (let index = 0; index < this.contactList.length; index++) {
                        if (this.contactList[index]._id == id) {
                            this.contactList.splice(index, 1);
                        }

                    }
                    this.writeData(JSON.stringify(this.contactList));
                    resolve('success');
                }
            ).catch(
                (error) => {
                    rejecct('failed');
                }
            );
        });
    }


    printData() {
        console.log(this.contactList);
    }


    // getContact(id) {
    //     for (const contact of this._contactList) {
    //         if (contact._id == id)
    //             return contact;
    //     }
    // }
    // editContact(id, newContact) {
    //     console.log(id);
    //     console.log(newContact);

    //     for (let index = 0; index < this._contactList.length; index++) {
    //         if (this._contactList[index]._id == id) {
    //             this._contactList[index]._name = newContact._name;
    //             this._contactList[index]._contactNumber = newContact._contactNumber;
    //         }
    //     }
    //     this.fileService.write(this._contactList);
    // }
}

let service = new ContactService();

module.exports = service;