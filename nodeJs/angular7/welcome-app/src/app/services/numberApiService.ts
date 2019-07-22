import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class NumberApiService{
    constructor(private http:HttpClient)
    {
    }
    getFact(no){
        return this.http.get("http://numbersapi.com/"+no,{responseType:"text"}).toPromise();
    }
}