import { Component } from '@angular/core';

@Component({
    selector: 'welcome-app',
    templateUrl: './welcome.component.html'
})
export class WelcomeComponent {
    private message: string;
    private toggleData:number;
    constructor() {
        this.message = "welcome component";
    }
    getToggleData(e) {
        this.toggleData=e;
        console.log(e);    
    }
}