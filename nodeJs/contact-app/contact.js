class contact {
    constructor() {
        this._id = null;
        this._name = null;
        this._contactNumber = null;
    }
    set id(id) {
        this._id = id;
    }
    set name(name) {
        this._name = name;
    }
    set contactNumber(contactNumber) {
        this._contactNumber = contactNumber;
    }
    get id() {
        return this._id;
    }
    get name() {
        return this._name;
    }
    get contactNumber() {
        return this._contactNumber;
    }
}
module.exports = contact;