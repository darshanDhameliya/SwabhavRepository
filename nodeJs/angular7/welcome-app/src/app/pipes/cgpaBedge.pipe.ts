import  {Pipe, PipeTransform } from '@angular/core';
@Pipe({name:'cgpaBedge'})
export class CgpaBedge implements PipeTransform{
    transform(cgpa: number):string {
        if(cgpa<4)
            return "red";
        if(cgpa<6)
            return "yellow";
        return "green";
    }
}