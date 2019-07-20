import { Component,OnInit,Input, Output,EventEmitter } from '@angular/core';

@Component({
    selector:'swabhav-toggle-button',
    templateUrl:'./toggleButton.component.html'
})

export class ToggleButtonComponent implements OnInit{
    private state:number=1;
    private toggleButtonColor:string;
    @Input()
    private textValue:string;
    @Input()
    private onColor:string="orange";
    @Input()
    private offColor:string="yellow";
    @Output()
    private stateChanged= new EventEmitter<number> ();

    constructor(){
        console.log("inside constructor");
        console.log(this.textValue);
    }
    ngOnInit(): void {
        console.log("inside ngOnInit");
        console.log(this.textValue);
        this.toggleButtonColor=this.onColor;
    }
    clickHandler(){
        this.stateChanged.emit(this.state);
        
        this.state?this.state=0:this.state=1;
        this.toggleButtonColor==this.onColor?this.toggleButtonColor=this.offColor:this.toggleButtonColor=this.onColor;
    }
}