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
    displayContact() {
        console.log(this._contactList);
    }
}
module.exports = contactService;