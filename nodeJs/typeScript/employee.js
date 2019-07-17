"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var employee = /** @class */ (function () {
    function employee(id, name, address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    Object.defineProperty(employee.prototype, "Id", {
        get: function () {
            return this.id;
        },
        set: function (id) {
            if (id > 0)
                this.id = id;
        },
        enumerable: true,
        configurable: true
    });
    return employee;
}());
exports.employee = employee;
var address = /** @class */ (function () {
    function address(area, city, state) {
        this.area = area;
        this.city = city;
        this.state = state;
    }
    return address;
}());
exports.address = address;
