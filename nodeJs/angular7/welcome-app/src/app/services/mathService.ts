export class MathService{
    cubeEventNumber(no):string{
        if(no%2==0)
            return Math.pow(no,3).toString();
        return "not Even number";
    }
}