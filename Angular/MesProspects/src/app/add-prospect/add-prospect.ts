import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Prospect } from '../model/prospect.model';
import { ProspectService } from '../services/prospect';
@Component({
  selector: 'app-add-prospect',
  imports: [FormsModule
  ],
  templateUrl: './add-prospect.html',
  styleUrl: './add-prospect.css',
})
export class AddProspect {
  newProspect = new Prospect();
  constructor(private prospectService: ProspectService) { }
  addProspect() {
    //console.log(this.newProspect);
    this.prospectService.ajouterProspect(this.newProspect);
  }

}
