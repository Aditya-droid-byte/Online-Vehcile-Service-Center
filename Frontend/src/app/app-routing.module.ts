import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MakeRequestComponent } from './make-request/make-request.component';
import { RequestListComponent } from './request-list/request-list.component';
import { UpdateRequestComponent } from './update-request/update-request.component';
import { RequestDetailsComponent } from './request-details/request-details.component';
import { ServicePageComponent } from './service-page/service-page.component';
import { RequestSentComponent } from './request-sent/request-sent.component';
import { AboutUsComponent } from './about-us/about-us.component';


const routes: Routes = [
  { path: '', component: HomepageComponent },
  { path: 'home', component: HomepageComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'dashboard', component: DashboardComponent},
  { path: 'services', component: ServicePageComponent},
  { path: 'about-us', component: AboutUsComponent},
  { path: 'make-request', component: MakeRequestComponent},
  { path: 'requests', component: RequestListComponent},
  { path: 'update-request/:id', component: UpdateRequestComponent},
  { path: 'request-details/:id', component: RequestDetailsComponent},
  { path: 'request-sent', component: RequestSentComponent},

]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
