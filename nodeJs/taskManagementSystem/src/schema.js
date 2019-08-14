let mongoose = require('mongoose');
let subTask = new mongoose.Schema({
    tittle: String,
    description: String,
    startDate: Date,
    dueDate: Date,
    assignee: String,
    isComplated: Boolean
})
let task = new mongoose.Schema({
    tittle: String,
    description: String,
    startDate: Date,
    dueDate: Date,
    assignee: String,
    priority: {
        type: String,
        enum: ['important', 'idel']
    },
    isComplated: Boolean,
    createDate: Date,
    subTask: [subTask]
});
module.exports = new mongoose.Schema({
    firstName: {
        type: String,
        lowercase: true,
        required: [true, "can't be blank"],
        match: [/^[a-zA-Z0-9]+$/, 'is invalid'],
        index: true
    },
    lastName: {
        type: String,
        lowercase: true,
        required: [true, "can't be blank"],
        match: [/^[a-zA-Z0-9]+$/, 'is invalid'],
        index: true
    },
    gender: {
        type: String,
        enum: ['male', 'female', 'other']
    },
    birthOfDate: Date,
    contactInfo: {
        contactNo: {
            type: Number,
            validate: {
                validator: function(v) {
                    return /\d{10}/.test(v);
                },
                message: '{VALUE} is not a valid 10 digit number!'
            }
        },
        address: {
            country: String,
            state: String,
            city: String,
            street: String,
            houseNumber: String
        },
        emailId: {
            type: String,
            lowercase: true,
            required: [true, "can't be blank"],
            match: [/\S+@\S+\.\S+/, 'is invalid'],
            index: true
        }
    },
    password: String,
    isDelete: Boolean,
    task: [task]
});