import { Component } from '@angular/core';
import { NavigationExtras, Router } from '@angular/router';
import { AuthService } from '../auth-service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  constructor(private router: Router, private authService: AuthService) {}

  isLoggedIn(): boolean {
    return this.authService.isLoggedIn();
  }


  logout(): void {

    localStorage.clear();

    const navigationExtras: NavigationExtras = {
      replaceUrl: true
    };
    this.authService.setLoggedIn(false);
    this.router.navigate(['home'], navigationExtras);

  }
}


