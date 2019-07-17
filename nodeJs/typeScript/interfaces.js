function printManyStudents(students) {
    for (var _i = 0, students_1 = students; _i < students_1.length; _i++) {
        var student = students_1[_i];
        console.log(student);
    }
}
printManyStudents([{ rollNo: 101, name: "darshan", age: 19, cpi: 7.00 },
    { rollNo: 102, name: "vivek", age: 20, cpi: 8.70 },
    { rollNo: 103, name: "hiren", age: 21, cpi: 8.75 }]);
