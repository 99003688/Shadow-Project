import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private UserService:UserService) { }

  ngOnInit(): void {
  }
  getUser(){
    this.UserService.getUser().subscribe(
      user=>{
        console.log(user)
      },
      error=>{
        console.log(error)
        
      }
    )

  }

}
