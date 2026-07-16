import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { Prospect } from '../model/prospect.model';
import { Commercial } from '../model/commercial.model';
import { ProspectService } from '../services/prospect';

@Component({
  selector: 'app-update-prospect',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './update-prospect.html',
  styles: ``
})
export class UpdateProspect implements OnInit {

  currentProspect = new Prospect();
  commercial: Commercial[] = [];
  updatedCommercialId!: number;

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private prospectService: ProspectService
  ) { }

  ngOnInit(): void {
    this.prospectService.listeCommerciaux().
      subscribe(commercials => {
        this.commercial = commercials;
      }
      );
    this.prospectService.consulterProspect(this.activatedRoute.snapshot.params['id']).
      subscribe(prod => {
        this.currentProspect = prod;
        this.updatedCommercialId = this.currentProspect.commercial?.idCommercial!;
      });
  }

  updateProspect(): void {

    this.currentProspect.commercial = {
      idCommercial: this.updatedCommercialId
    } as Commercial;

    this.prospectService.updateProspect(this.currentProspect)
      .subscribe(() => this.router.navigate(['prospects']));
  }

}