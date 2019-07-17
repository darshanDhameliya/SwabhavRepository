export class employee{
    constructor(private id:number,private name:string,private address:object)
    {
    }
    public get Id(){
        return this.id;
    }
    public set Id(id:number)
    {
        if(id>0)
            this.id=id;
    }
}
export class address{
    constructor(private area:string,private city:string,private state:string)
    {}
}