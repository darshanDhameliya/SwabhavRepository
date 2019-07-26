"use strict";
class Player {
    constructor() {
        this._name = null;
        this._mark = null;
    }
    set name(name) {
        this._name = name;
    }
    set mark(mark) {
        this._mark = mark;
    }
    get name() {
        return this._name;
    }
    get mark() {
        return this._mark;
    }
}
module.exports = Player;