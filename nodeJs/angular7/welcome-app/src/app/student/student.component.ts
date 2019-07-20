
import { Component, Injectable } from '@angular/core';
import { IStudent } from './IStudent';
import { MathService } from '../services/mathService';
@Injectable()
@Component({
    selector: 'swabhav-student',
    templateUrl: './student.component.html'
})
export class StudentComponent {
    student: IStudent;
    studentList: IStudent[];
    imageMinHeight: number = 100;
    imageMinWidth: number = 150;
    cubeAnswer:string;
    constructor(private service:MathService) {
        this.student = {
            name: "darshan",
            cgpa: 5.21,
            doj: "01-08-2016",
            location: "surat",
            profilePic: "assets/studentImage/student1.jpg"
        };
    }
    displayStudentList() {
        this.studentList = [{
            name: "hiren",
            cgpa: 9.21,
            doj: "01-08-2016",
            location: "surat",
            profilePic: "assets/studentImage/student2.jpg"
        }, {
            name: "vivek",
            cgpa: 9.21,
            doj: "01-08-2016",
            location: "surat",
            profilePic: "assets/studentImage/student3.jpg"
        }];
    }
    onNameChange(newName){
        this.student.name=newName;
    }
    findCube(number)
    { 
        this.cubeAnswer=this.service.cubeEventNumber(number);
    }
}
