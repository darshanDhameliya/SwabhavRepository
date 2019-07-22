import { Component, Injectable} from "@angular/core";
import { NumberApiService } from '../services/numberApiService';

@Injectable()
@Component({
    selector:'swabhav-number-api',
    templateUrl:'./numberApi.component.html'
})
export class NumberApiComponent{
    private fact:any;

    constructor(private service:NumberApiService)
    {
    }
    getFact(number)
    {
        var promise=this.service.getFact(number);
        promise.then(
            (response)=>{this.fact=response;}
        ).catch(
            (error)=>{console.log("error :- "+error);
            this.fact=error;}
        )
    }
}