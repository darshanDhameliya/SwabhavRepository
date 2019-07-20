import { Component,OnInit, Input } from '@angular/core';

@Component({
  selector: 'swabhav-star-rating',
  templateUrl: `./star.rating.component.html`
})
export class StarRatingComponent implements OnInit{
  @Input()
  starRating:number;
  
  constructor() {
    console.log("Inside the constructor");
  }
  ngOnInit(){
    console.log(this.starRating);
  }
}