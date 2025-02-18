import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';
import { AuthService } from '../auth-service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;

  constructor(private customerService: CustomerService, private router: Router, private authService: AuthService) {}

  ngOnInit(): void {
    
  }

  checkLogin() {
    this.customerService.getCustomerByUsername(this.username).subscribe(
      (customer: Customer) => {
        if (customer && customer.password === this.password) {
          // Successful login
          alert('Login successful!');
          this.authService.setLoggedIn(true);
          this.router.navigate(['dashboard']);
        } else {
          // Failed login
          alert('Invalid username or password');
        }
      },
      error => {
        // Failed to fetch customer
        alert('An error occurred during login. Please register or try again later.');
        console.error(error);
      }
    );
  }
}
