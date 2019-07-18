import { Component } from '@angular/core';

@Component({
    selector: 'welcome-app',
    templateUrl: './welcome.component.html'
})
export class WelcomeComponent {
    private message: string;
    constructor() {
        this.message = "welcome component";
    }
}