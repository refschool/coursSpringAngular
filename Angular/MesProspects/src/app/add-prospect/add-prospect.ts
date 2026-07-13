import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Prospect } from '../model/prospect.model';
import { ProspectService } from '../services/prospect';
import { Commercial } from '../model/commercial.model';
import { Router } from '@angular/router';
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

  commercial!: Commercial[];
  newIdCommercial!: number;
  newCommercial!: Commercial;

  constructor(
    private prospectService: ProspectService,
    private router: Router
  ) { }

  ngOnInit() {
    this.commercial = this.prospectService.listeCommerciaux();
  }

  addProspect() {
    this.newCommercial =
      this.prospectService.consulterCommercial(this.newIdCommercial);

    this.newProspect.commercial = this.newCommercial;

    this.prospectService.ajouterProspect(this.newProspect);

    this.router.navigate(['prospects']);
  }

}
