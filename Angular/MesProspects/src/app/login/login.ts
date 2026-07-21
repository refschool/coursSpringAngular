import { Component, OnInit } from '@angular/core';
import { User } from '../model/user.model';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-login',
  imports: [CommonModule, FormsModule],
  templateUrl: './login.html',
  styles: ``,
})
export class Login implements OnInit {
  user = new User();

  ngOnInit() {
  }

  onLoggedin() {
    console.log(this.user);
  }
}
