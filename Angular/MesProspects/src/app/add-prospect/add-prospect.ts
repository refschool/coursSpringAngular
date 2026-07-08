import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Prospect } from '../model/prospect.model';
@Component({
  selector: 'app-add-prospect',
  imports: [FormsModule
  ],
  templateUrl: './add-prospect.html',
  styleUrl: './add-prospect.css',
})
export class AddProspect {
  newProspect = new Prospect();
  addProspect() {
    console.log(this.newProspect);
  }

}
