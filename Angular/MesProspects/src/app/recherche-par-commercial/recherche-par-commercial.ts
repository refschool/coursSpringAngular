import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Prospect } from '../model/prospect.model';
import { Commercial } from '../model/commercial.model';
import { ProspectService } from '../services/prospect';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-recherche-par-commercial',
  imports: [FormsModule, CommonModule],
  templateUrl: './recherche-par-commercial.html',
  styles: ``,
})

export class RechercheParCommercial implements OnInit {
  prospects!: Prospect[];
  IdCommercial!: number;
  commercial!: Commercial[];

  constructor(
    private prospectService: ProspectService,

  ) { }
  ngOnInit(): void {
    this.prospectService.listeCommerciaux().
      subscribe(com => {
        this.commercial = com
        console.log(com);
      });

  }
  onChange() {
    this.prospectService.rechercherParCommercial(this.IdCommercial).
      subscribe(prospects => { this.prospects = prospects });
  }
}
