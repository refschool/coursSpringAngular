import { Component, OnInit } from '@angular/core';
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
export class AddProspect implements OnInit {
  newProspect = new Prospect();
  message: string = "";
  constructor(private prospectService: ProspectService) { }
  ngOnInit(): void {

  }
  addProspect() {
    console.log(this.newProspect);
    this.prospectService.ajouterProspect(this.newProspect);
    this.message = "Ajouté avec succès"
  }

}
