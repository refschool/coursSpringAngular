import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-prospects',
  imports: [CommonModule],
  templateUrl: './prospects.html'
})
export class Prospects {
  prospects: string[];
  constructor() {
    this.prospects = ["Yvon", "Thierry", "Emma"];
  }
}
