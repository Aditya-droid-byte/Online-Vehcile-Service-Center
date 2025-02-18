import { Component } from '@angular/core';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  customer: Customer = new Customer();

  constructor(private customerService: CustomerService, private router: Router) {}
 
  registerCustomer() { 
    this.customerService.createCustomer(this.customer).subscribe({ 
      next: (customer) => { 
        console.log(this.customer); 
        alert('Registration successful! Please Login'); 
        this.router.navigate(['login']); 
        return; 
      }, 
      error: (err) =>{ 
        if(err = 302){ 
          alert('Registration Failed! UserName already exist'); 
        }else{ 
          alert(err.error.msg); 
        } 
          return; 
      } 
  }) 
  }

  goToLogin() {
    this.router.navigate(['login']);
  }

  onSubmit() {
    console.log(this.customer);
    this.registerCustomer();
  }
}
