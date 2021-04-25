import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  {
    path:'',
    component:HomeComponent,
    pathMatch:'full'
  },
  {
path:"login",
component:LoginComponent,
pathMatch:"full"
  },
  {
  path:"dashboard",
component:DashboardComponent,
pathMatch:"full",
canActivate: [AuthGuard]
  },
{
  path:"home",
component:HomeComponent,
pathMatch:"full"
  },
];




@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
