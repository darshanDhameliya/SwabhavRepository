let fileService = require('./fileService');
class contactService {
    constructor(fileName) {
        this.fileServiceObject = new fileService(fileName);
        this._contactList = this.fileServiceObject.read();
        if (this._contactList == null)
            this._contactList = [];
    }
    addContact(contact) {
        this._contactList.push(contact);
        this.fileServiceObject.write(this._contactList);
    }
    deleteContact(id) {
        for (let index = 0; index < this._contactList.length; index++) {

            if (this._contactList[index]._id == id)
                this._contactList.splice(index, 1);
        }
        this.fileServiceObject.write(this._contactList);
    }
    getContactList() {
        return this._contactList;
    }
    getContact(id) {
        for (const contact of this._contactList) {
            if (contact._id == id)
                return contact;
        }
    }
    editContact(id, newContact) {
        console.log(id);
        console.log(newContact);

        for (let index = 0; index < this._contactList.length; index++) {
            if (this._contactList[index]._id == id) {
                this._contactList[index]._name = newContact._name;
                this._contactList[index]._contactNumber = newContact._contactNumber;
            }
        }
        this.fileServiceObject.write(this._contactList);
    }
}
module.exports = contactService;