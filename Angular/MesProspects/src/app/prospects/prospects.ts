import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Prospect } from '../model/prospect.model';
import { ProspectService } from '../services/prospect';


@Component({
  selector: 'app-prospects',
  imports: [CommonModule],
  templateUrl: './prospects.html'
})
export class Prospects {
  prospects: Prospect[];
  constructor(private produitService: ProspectService) {
    this.prospects = produitService.listeProspects();
  }
}
