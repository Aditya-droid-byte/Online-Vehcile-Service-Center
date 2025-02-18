import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { FormsModule } from '@angular/forms';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MakeRequestComponent } from './make-request/make-request.component';
import { RequestListComponent } from './request-list/request-list.component';
import { HttpClientModule } from '@angular/common/http';
import { UpdateRequestComponent } from './update-request/update-request.component';
import { RequestDetailsComponent } from './request-details/request-details.component';
import { ServicePageComponent } from './service-page/service-page.component';
import { RequestSentComponent } from './request-sent/request-sent.component';
import { HeaderComponent } from './header/header.component';
import { AboutUsComponent } from './about-us/about-us.component';

@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    LoginComponent,
    RegisterComponent,
    DashboardComponent,
    MakeRequestComponent,
    RequestListComponent,
    UpdateRequestComponent,
    RequestDetailsComponent,
    ServicePageComponent,
    RequestSentComponent,
    HeaderComponent,
    AboutUsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
