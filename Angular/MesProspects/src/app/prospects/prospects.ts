import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Prospect } from '../model/prospect.model';
import { ProspectService } from '../services/prospect';
import { RouterLink } from '@angular/router';


@Component({
  selector: 'app-prospects',
  imports: [CommonModule, RouterLink],
  templateUrl: './prospects.html'
})
export class Prospects implements OnInit {
  prospects: Prospect[] = [];
  constructor(private prospectService: ProspectService) { }
  ngOnInit() {
    this.prospects = this.prospectService.listeProspects();
  }
  supprimerProspect(p: Prospect) {
    //console.log(p);
    let conf = confirm("Etes-vous sûr ?");
    if (conf)
      this.prospectService.supprimerProspect(p);
  }

}

