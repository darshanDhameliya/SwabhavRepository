interface Istudent{
    rollNo:number,
    name:string,
    age:number,
    cpi:number
}

function printManyStudents(students:Istudent[])
{
    for(let student of students)
    {
        console.log(student);   
    }
}
printManyStudents([{rollNo:101,name:`darshan`,age:19,cpi:7.00},
                    {rollNo:102,name:`vivek`,age:20,cpi:8.70},
                    {rollNo:103,name:`hiren`,age:21,cpi:8.75}]);